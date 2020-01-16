package com.base.designpatterns.singleton;
//静态内部类 可取代DCL
public class Singleton5 {
    private Singleton5() {
    }

    public static Singleton5 getInstance(){
        return SingletonHolder.sinstance;
    }

    private static class SingletonHolder{
        private static final Singleton5 sinstance = new Singleton5();
    }
}
