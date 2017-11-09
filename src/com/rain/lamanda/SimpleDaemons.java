package com.rain.lamanda;

import java.util.concurrent.TimeUnit;

public class SimpleDaemons {
    public static void main(String[] args) throws Exception {
        for (int i = 0;i < 10;i++) {
            Thread thread = new Thread(() -> {
                try {
                    while (true) {
                        // TimeUnit底层调用Thread.sleep()
                        TimeUnit.MILLISECONDS.sleep(100);
                        System.out.println(Thread.currentThread());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            // 设置当前线程为后台线程
            thread.setDaemon(true);
            thread.start();
        }
        TimeUnit.MILLISECONDS.sleep(100);
    }
}
