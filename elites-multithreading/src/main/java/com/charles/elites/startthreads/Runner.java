package com.charles.elites.startthreads;

import com.charles.elites.utils.Out;

/**
 * Starting Threads with extends
 */
public class Runner extends Thread {

    @Override
    public void run() {
        Out.print();
    }

    public static void main(String[] args) {
        Runner runner1 = new Runner();
        runner1.start();

        Runner runner2 = new Runner();
        runner2.start();
    }
}
