package com.wc.day1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author: wangcheng
 * @date: 2019/12/8
 * @description wait()、notify()
 * @version: 1.0
 */
public class Thread_04 {

    static List<Object> list = new LinkedList<>();

    public void get() {

        while (true) {
            synchronized (list) {
                if (list.size() > 0) {
                    list.remove(0);
                    System.out.println(Thread.currentThread().getName() + "-开始消费--" + list.size());
                    list.notifyAll();

                } else {
                    try {
                        System.out.println(Thread.currentThread().getName() + "-余额不足");
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void put() {

        while (true) {
            synchronized (list) {
                if (list.size() >= 6) {
                    System.out.println(Thread.currentThread().getName() + "-生产满了");
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.add(1);
                System.out.println(Thread.currentThread().getName() + "-开始生产--" + list.size());
                list.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        Thread_04 aaa = new Thread_04();
        for (int i = 0; i < 5; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(() -> {
                aaa.put();
            }).start();
        }

        for (int i = 0; i < 5; i++) {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(() -> {
                aaa.get();
            }).start();
        }

    }

}
