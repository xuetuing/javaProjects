package com.company.jdk8chacracter.stream;

import javafx.scene.control.TableRow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        System.out.println(-1 << 2);
        ExecutorService executorService =  Executors.newFixedThreadPool(10);
        ExecutorService executorService1 =  Executors.newSingleThreadExecutor();
        ExecutorService executorService2 =  Executors.newCachedThreadPool();

        for (int i = 0; i <= 100 ; i++) {
            executorService2.execute(new myTask(i));
        }
        executorService2.shutdown();
    }
}

class myTask implements Runnable {
    private int i;

    public myTask(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "->" + i);

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
