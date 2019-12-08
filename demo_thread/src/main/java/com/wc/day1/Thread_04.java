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
    static int num = 0;
    static boolean flag = false;

    public int get(){
        return list.size();
    }

    public void put(int i){
        list.add("a" + i);
    }

    public static void main(String[] args) {
        Thread_04 t4 = new Thread_04();

        //生产者
        Thread t1 = new Thread(() -> {
            synchronized(t4){
                while (!flag){
                    num ++;
                    if(t4.get() > 10){
                        System.out.println("生产满了");
                        try {
                            t4.wait();
                            flag = false;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("开始生产--" + num);
                    t4.put(num);
                }
                System.out.println("生产结束");
            }
        });

        //消费
        Thread t2 = new Thread(() -> {
            synchronized(t4){
                while (flag) {
                    if (t4.get()>0){
                        list.remove(0);
                        System.out.println("开始消费--" + t4.get());
                        t4.notify();
                    }
                }
            }
        });

    }
}
