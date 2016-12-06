package com.rayworks.java;

import java.util.concurrent.*;

public class Main {

    private static Runnable task;

    public static class TestHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println(">>> Thread Terminated with exception " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // write your code here
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                System.out.println("Thread gen...");

                thread.setUncaughtExceptionHandler(new TestHandler());
                return thread;
            }
        };
        ExecutorService executorService = Executors.newSingleThreadExecutor(threadFactory);
        /***
         * !!! Only execute() method will pass the exception to the UncaughtExceptionHandler
         */
        task = new Runnable() {
            @Override
            public void run() {
                int i = 1 / 0;
            }
        };
        executorService.execute(task);

        Future<?> future = executorService.submit(task);
        try {
            future.get();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            future.cancel(true);
        }

        try {
            Thread.currentThread().sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdownNow();
        }

    }
}
