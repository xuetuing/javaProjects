package com.company.implmyself;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(2);
        List<Thread> list = new ArrayList<>(4);
        int times = 100;
        int threads = 400;
        long starTime = System.currentTimeMillis();
        //两个生产者线程
        for (int i = 0; i < threads; i++) {
            int offerSet = i * times;
            Thread producer = new Thread(() -> {
                for (int j = 0; j < times; j++) {
                    try {
                        queue.put(offerSet + j);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            list.add(producer);
            producer.start();
        }

        //两个消费者线程
        for (int i = 0; i < threads; i++) {
            Thread consumer = new Thread(() -> {
                for (int j = 0; j < times; j++) {
                    try {
                        System.out.println(queue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            list.add(consumer);
            consumer.start();
        }

        for(Thread t: list) {
            t.join();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("耗时:" + (endTime - starTime));
    }

}
