package com.company.problemlocation.stack;

public class Client {
    public static void main(String[] args) {
        Object shareObj = new Object();

        ThreadLocked threadLocked = new ThreadLocked(shareObj);
        threadLocked.start();

        ThreadWaitingTo threadWaitingTo = new ThreadWaitingTo(shareObj);
        threadWaitingTo.start();

        ThreadWaitingOn threadWaitingOn = new ThreadWaitingOn();
        threadWaitingOn.start();
    }
}
