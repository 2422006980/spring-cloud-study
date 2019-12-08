package com.wc.day1;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author: wangcheng
 * @date: 2019/12/4
 * @description object: wait()、notify()、notifyAll()、yield()、sleep()、join()
 * @version: 1.0
 */
public class Thread_03 {
    static Semaphore semaphore = new Semaphore(3);
    void aaa() throws InterruptedException {
        semaphore.acquire();
        System.out.println(Thread.currentThread().getName() + 111);
    }

    public static void main(String[] args) throws InterruptedException {
//        Thread t1 = new Thread(()-> {
//
//            System.out.println("t1--->>run");
//        });
//
//        t1.start();


        Thread_03 test = new Thread_03();
        for(int i=1; i<10; i++){
            new Thread(()-> {
                try {
                    test.aaa();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
               // System.out.println("t1--->>run");
            }).start();

        }
        TimeUnit.SECONDS.sleep(1);
        semaphore.release(3);
        semaphore.release();

    }
}
