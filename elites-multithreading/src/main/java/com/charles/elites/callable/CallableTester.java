package com.charles.elites.callable;

import java.util.concurrent.*;

/**
 * Till Java 1.4, threads could be implemented by either implementing
 * {@link Runnable} or extending {@link Thread}.
 * This was quite simple, but had a serious limitation;
 * They have a run method that cannot return values. In order to side-step this,
 * most programmers use side-effects (writing to a file etc.) to mimic returning
 * values to the invoker of the thread. Java 5 introduces the
 * {@link Callable} interface, that allows users to
 * return values from a thread.
 */
class CallableImpl implements Callable<Integer> {

    private int myName;

    CallableImpl(int i) {
        myName = i;
    }

    @Override
    public Integer call() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread : " + getMyName() + " value is : " + i);
        }
        return getMyName();
    }

    public int getMyName() {
        return myName;
    }

    public void setMyName(int myName) {
        this.myName = myName;
    }
}

public class CallableTester {

    public static void main(String[] args) throws InterruptedException {

        Callable<Integer> callable = new CallableImpl(2);
        ExecutorService executor = new ScheduledThreadPoolExecutor(1);
        Future<Integer> future = executor.submit(callable);

        try {
            System.out.println("Future value: " + future.get());
        } catch (Exception ignored) {}
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);
    }

}
