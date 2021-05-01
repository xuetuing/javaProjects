package com.company.problemlocation.stack;

public class ThreadWaitingOn extends Thread{
    Object lockForWait = new Object();

    public ThreadWaitingOn() {
        this.setName(this.getClass().getName());
    }

    public void run(){
        func();
    }

    public void func() {
        synchronized (lockForWait) {
            func_waiting();
        }
    }

    public void func_waiting() {
        try {
            lockForWait.wait(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
