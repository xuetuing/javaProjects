package com.company.algorithm.other;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
    public static void main(String[] args) {
        for(int i = 0; i < 1000; i++) {
            long nanos = System.nanoTime() / 1000;
            System.out.print(nanos);
            System.out.print(" -> ");
            String nanoStr = String.valueOf(nanos);
            System.out.println(nanoStr.substring(nanoStr.length() - 3));
        }

    }
}
