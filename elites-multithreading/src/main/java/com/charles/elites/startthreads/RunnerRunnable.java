package com.charles.elites.startthreads;

import com.charles.elites.utils.Out;

/**
 * Starting Threads using Runnable Interface
 */
public class RunnerRunnable implements Runnable {

    @Override
    public void run() {
        Out.print();
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnerRunnable());
        Thread thread2 = new Thread(new RunnerRunnable());
        thread1.start();
        thread2.start();
    }
}
