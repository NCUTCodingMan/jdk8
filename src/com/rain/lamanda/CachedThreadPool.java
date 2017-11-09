package com.rain.lamanda;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CachedThreadPool {
    public static void main(String[] args) {
        callable();
    }

    public static void runnable() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            final Date date = new Date();
            executorService.execute(() -> {                
                System.out.println(date);
            });
        }
        executorService.shutdown();
    }

    public static void callable() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            // 需要注意的是,在Lambda表达式中使用的外部变量在效果上必须是final的
            final Date date = new Date();
            futures.add(executorService.submit(() -> {
                return "time of run this method..." + date;
            }));
        }

        // 遍历
        futures.forEach((n) -> {
            try {
                System.out.println(n.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e1) {
                e1.printStackTrace();
            } finally {
                executorService.shutdown();
            }
        });
    }
}