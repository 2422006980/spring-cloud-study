package com.wc.day1;

/**
 * @author: wangcheng
 * @date: 2019/12/4
 * @description 创建线程new Thread()
 * @version: 1.0
 */
public class Thread_01 {

    static class Thread1 extends Thread{

        @Override
        public void run() {
            System.out.println("Thread1---run...");
        }
    }

    static class Thread2 extends Thread{

        @Override
        public void run() {
            System.out.println("Thread2---run...");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        t1.start();
        t2.start();

        System.out.println("main---run...");
    }
}
