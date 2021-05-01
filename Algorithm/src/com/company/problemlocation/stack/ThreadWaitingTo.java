package com.company.problemlocation.stack;

public class ThreadWaitingTo extends Thread{
    Object lock = null;

    public ThreadWaitingTo(Object lock_) {
        this.lock = lock_;
        this.setName(this.getClass().getName());
    }

    public void run(){
        func();
    }

    public void func() {
        synchronized (lock) {
            func_waiting();
        }
    }

    public void func_waiting() {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
