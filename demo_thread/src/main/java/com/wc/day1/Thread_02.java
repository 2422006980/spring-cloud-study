package com.wc.day1;

/**
 * @author: wangcheng
 * @date: 2019/12/4
 * @description 创建线程implement Rannable
 * @version: 1.0
 */
public class Thread_02 {

    static class Thread1 implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread1---run...");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread1 t = new Thread1();
        Thread t1 = new Thread(t);
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread2---run...");
            }
        });
        t2.start();

        Thread t3 = new Thread(() -> {
            System.out.println("Thread3---run...");
        });
        t3.start();
        t3.join();
        Thread t4 = new Thread(() -> System.out.println("Thread4---run..."));
        t4.start();

        Thread.yield();
        System.out.println("main---run...");

    }
}
