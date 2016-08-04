package com.charles.elites.utils;


/**
 * Created by Kelvin.R.K on 7/2/2016.
 */
public final class Run {
    public static void testRun(Runner runner) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                runner.firstThread();
            } catch (Exception ignored) {
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                runner.secondThread();
            } catch (Exception ignored) {
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        runner.finished();
    }
}
