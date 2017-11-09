package com.rain.lamanda;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 三者有一定的关系
 * Callable
 *  类似Runnable的接口,仅仅包含一个抽象方法.可以理解为一个任务;
 *  里面包含call();与run()不同的是该方法有返回值并且可以跑出异常
 * Future
 *  可用来取消任务;查询任务状态;获取任务执行之后的返回值
 * FutureTask
 *  间接实现了Runnable与Future接口
 *  可用于任务执行以及获取任务返回值
 */
public class CallableAndFuture {
    public static void main(String[] args) {
        futureTack();
    }
    
    public static void future() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> future = executorService.submit(() -> {
            int i = 0;
            int sum = 0 ;
            for (i = 0;i < 10;i++) {
                sum += i;
            }
            return sum;
        });
        
        try {            
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e1) {
            e1.printStackTrace();
        }
        
        executorService.shutdown();
    }
    
    public static void futureTack() {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            int i = 0;
            int sum = 0 ;
            for (i = 0;i < 10;i++) {
                sum += i;
            }
            return sum;
        });
        
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(futureTask);
        try {            
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e1) {
            e1.printStackTrace();
        }
        executorService.shutdown();
    }
}