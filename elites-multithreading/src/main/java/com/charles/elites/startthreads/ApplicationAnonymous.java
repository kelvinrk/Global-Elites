package com.charles.elites.startthreads;

/**
 * Starting threads using the Thread constructor with anonymous classes
 */
public class ApplicationAnonymous {

    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hello: " + i + " Thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {
                }
            }
        };
        Thread thread1 = new Thread(task);
        thread1.start();
    }
}
