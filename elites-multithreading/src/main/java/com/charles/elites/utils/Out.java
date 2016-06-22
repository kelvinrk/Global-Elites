package com.charles.elites.utils;

import com.charles.elites.synchronize.Worker;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Kelvin.R.K on 6/24/2016.
 */
public final class Out {
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
}
