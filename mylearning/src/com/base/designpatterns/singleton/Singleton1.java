package com.base.designpatterns.singleton;

public class Singleton1 {
    // private static final Singleton1 instance = new Singleton1();
    // 很少用
    private static Singleton1 instance = new Singleton1();
    private Singleton1() {
    }

    public Singleton1 getInstance(){
        return instance;
    }
}
