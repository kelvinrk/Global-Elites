package com.charles.elites.quest;

/**
 * Created by Kelvin.R.K on 6/26/2016.
 */
public class Reminder implements Runnable {
    private String message;
    private int seconds;

    public Reminder(int seconds, String message) {
        this.seconds = seconds;
        this.message = message;
    }

    public void run() {
        try {
            Thread.sleep(seconds * 1000);
            System.out.print(message + " ");
        } catch (InterruptedException e) {
            // Do nothing
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Reminder(1, "1"));
        Thread t2 = new Thread(new Reminder(2, "2"));
        Thread t3 = new Thread(new Reminder(3, "3"));
        t3.start();
        t1.start();
        t3.join();
        t2.start();
        t1.join();
        t2.join();
    }
}