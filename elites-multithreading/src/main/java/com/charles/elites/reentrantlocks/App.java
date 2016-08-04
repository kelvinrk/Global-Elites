package com.charles.elites.reentrantlocks;

import com.charles.elites.utils.Run;

public class App {

    public static void main(String[] args) throws Exception {
        final ReentrantLockRunner reentrantLockRunner = new ReentrantLockRunner();
//        Thread t1 = new Thread(() -> {
//            try {
//                reentrantLockRunner.firstThread();
//            } catch (InterruptedException ignored) {
//            }
//        });
//
//        Thread t2 = new Thread(() -> {
//            try {
//                reentrantLockRunner.secondThread();
//            } catch (InterruptedException ignored) {
//            }
//        });
//
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
//        reentrantLockRunner.finished();

        Run.testRun(reentrantLockRunner);
    }

}
