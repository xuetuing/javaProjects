package com.company.designpattern.singleton;

public class DoubleCheckWithLock {
    private volatile static DoubleCheckWithLock instance = null;

    private DoubleCheckWithLock () {

    }

    public static DoubleCheckWithLock getInstance() {
        if(instance == null) {
            synchronized (DoubleCheckWithLock.class) {
                if(instance == null) {
                    instance = new DoubleCheckWithLock();
                }
            }
        }

        return instance;
    }

}
