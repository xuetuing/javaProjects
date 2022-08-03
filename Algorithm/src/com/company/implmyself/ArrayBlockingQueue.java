package com.company.implmyself;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//基于Array 实现简单阻塞队列
public class ArrayBlockingQueue<E> {
    /**
     * 1. 如何实现队列？
     *  尾部加，头部取，取出后元素左移（代价比较大，怎么解决？）
     * 2. 如何阻塞？
     * 增删时都加锁
     */
//    private int count;
    private AtomicInteger count = new AtomicInteger(0);

    private Object[] items;

//    private boolean isFull;
//
//    private boolean notEmpty;

    private final ReentrantLock lock;

//    private final Condition condition;
    // 拆分条件变量
    private final Condition notFull;

    private final Condition notEmpty;

    private int putIndex; //插入的位置

    private int takeIndex; // 取出的位置

    public ArrayBlockingQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        items = new Object[capacity];
        lock = new ReentrantLock();
//        condition = lock.newCondition();
        notEmpty = lock.newCondition();
        notFull = lock.newCondition();
    }

    public void put(E e) throws InterruptedException {
        /*
        synchronized (this) {
            while (count == items.length) {
                this.wait();
            }
            enqueue(e);
            this.notifyAll();
        }*/
        lock.lockInterruptibly();
        try {
            while (count.get() == items.length) {
//                condition.await();
                notFull.await();
            }
            enqueue(e);
//            condition.signalAll();
            notEmpty.signal();
        } finally {
            lock.unlock();
        }

    }

    public E take() throws InterruptedException {
        /*
        synchronized (this) {
            while (count == 0) {
                this.wait();
            }
            Object e = dequeue();
            this.notifyAll();
            return e;
        }*/
        lock.lockInterruptibly();
        try {
            while (count.get() == 0) {
//                condition.await();
                notEmpty.await();
            }
            E e = dequeue();
//            condition.signalAll();
            notFull.signal();
            return e;
        } finally {
            lock.unlock();
        }
    }

    public void enqueue(E e) {
        items[putIndex] = e;

        if (++putIndex == items.length) {
            putIndex = 0;
        }
        count.getAndIncrement();
    }

    public E dequeue() {
        E e = (E)items[takeIndex];
        items[takeIndex] = null;
        if (++takeIndex == items.length) {
            takeIndex = 0;
        }
        count.getAndDecrement();
        return e;
    }

}
