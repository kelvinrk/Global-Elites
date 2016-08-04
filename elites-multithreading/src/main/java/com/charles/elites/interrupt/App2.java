package com.charles.elites.interrupt;

/**
 * Created by Kelvin.R.K on 7/3/2016.
 */
public class App2 {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Starting.");
        final int[] count = {0};

        Thread t = new Thread(() -> {
            for(int i = 0; i < 1E8; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted!");
                    break;
                }
                count[0]++;
            }
        });

        t.start();
        Thread.sleep(200);

        t.interrupt();
        System.out.println(count[0]);

        t.join();

        System.out.println("Finished.");
    }
}
