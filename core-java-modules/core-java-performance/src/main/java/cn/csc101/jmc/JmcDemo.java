package cn.csc101.jmc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JmcDemo {
    /**
     * 消耗CPU的线程
     * 不断循环进行浮点运算
     */
    private static void cpuHigh() {
        Thread thread = new Thread(() -> {
            Thread.currentThread().setName("cpu_high_thread");
            while (true){
                double pi = 0;
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    pi += Math.pow(-1, i) / (2 * i + 1);
                }
                System.out.println("Pi: " + pi * 4);
            }
        });
        thread.start();
    }
    /**
     * 不断新增 BigDecimal 信息到 list
     */
    private static void allocate() {
        new Thread(()->{
            Thread.currentThread().setName("memory_allocate_thread");
            List<BigDecimal> list = new ArrayList<>();
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                list.add(new BigDecimal(i));
            }
        }).start();
    }
    /**
     * 死锁线程
     * 线程 dead_thread_A 与 线程 dead_thread_B 互相锁死
     */
    private static void deadThread() {
        /** 创建资源 */
        Object resourceA = new Object();
        Object resourceB = new Object();
        // 创建线程
        Thread threadA = new Thread(() -> {
            Thread.currentThread().setName("dead_thread_A");
            synchronized (resourceA) {
                System.out.println(Thread.currentThread() + " get ResourceA");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resourceB");
                synchronized (resourceB) {
                    System.out.println(Thread.currentThread() + " get resourceB");
                }
            }
        });

        Thread threadB = new Thread(() -> {
            Thread.currentThread().setName("dead_thread_A");
            synchronized (resourceB) {
                System.out.println(Thread.currentThread() + " get ResourceB");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resourceA");
                synchronized (resourceA) {
                    System.out.println(Thread.currentThread() + " get resourceA");
                }
            }
        });
        threadA.start();
        threadB.start();
    }

    public static void main(String[] args) {
        deadThread();
    }

}
