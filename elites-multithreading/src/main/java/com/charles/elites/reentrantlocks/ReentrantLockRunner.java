package com.charles.elites.reentrantlocks;

import com.charles.elites.utils.Runner;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * {@link Lock}:
 * This is the base interface for Lock API. It provides all the features
 * of synchronized keyword with additional ways to create different Conditions
 * for locking, providing timeout for thread to wait for lock. Some of the
 * important methods are {@link Lock#lock()} to
 * acquire the lock, {@link Lock#unlock()} to release
 * the lock, {@link Lock#tryLock()} to wait for lock
 * for a certain period of time,
 * {@link Lock#newCondition()}
 * to create the Condition etc.
 */
public class ReentrantLockRunner implements Runner {

    private int count = 0;
    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();

    private void increment() {
        System.out.print("Call increment() from " + Thread.currentThread().getName());
        for (int i = 0; i < 10000; i++) {
            count++;
        }
        System.out.print(". count = " + count + "\n");
    }

    @Override
    public void firstThread() throws InterruptedException {
        lock.lock();
        System.out.println("Waiting ....");
        cond.await();
        System.out.println("Woken up!");
        try {
            increment();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void secondThread() throws InterruptedException {
        Thread.sleep(1000);
        lock.lock();
        System.out.println("Press the return key!");
        new Scanner(System.in).nextLine();
        System.out.println("Got return key!");
        cond.signal();
        try {
            increment();
        } finally {
            //should be written to unlock Thread whenever signal() is called
            lock.unlock();
        }
    }

    @Override
    public void finished() {
        System.out.println("Count is: " + count);
    }
}
