package com.charles.elites.utils;

import java.util.List;
import java.util.Random;

/**
 * Created by Kelvin.R.K on 6/24/2016.
 */
public final class Out {

    private static Random random = new Random();

    public static void print() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello: " + i + " Thread: " + Thread.currentThread().getName());

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addToList(List<Integer> list) {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            //do your work here
            e.printStackTrace();
        }
        list.add(random.nextInt(100));
    }
}
