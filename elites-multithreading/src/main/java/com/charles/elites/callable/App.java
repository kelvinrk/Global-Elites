package com.charles.elites.callable;

import java.util.Random;
import java.util.concurrent.*;

/**
 * {@link Callable} and
 * {@link Future}
 * in Java to get results from your threads and to allow
 * your threads to throw exceptions. Plus, Future allows you to control your
 * threads, checking to see if they’re running or not, waiting for results and
 * even interrupting them or de-scheduling them.
 */
public class App {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();

        //anonymous call of Callable
        Future<Integer> future = executor.submit(() -> {
            Random random = new Random();
            int duration = random.nextInt(4000);
            if (duration > 2000) {
                throw new TimeoutException ("Sleeping for too long.");
            }

            System.out.println("Starting ...");
            try {
                Thread.sleep(duration);
            } catch (InterruptedException ignored) {}
            System.out.println("Finished.");
            return duration;
        });

        executor.shutdown();
//        executor.awaitTermination(1, TimeUnit.DAYS);
        try {
            //get returned value from call()
            System.out.println("Result is: " + future.get());

        } catch (InterruptedException ignored) {
        } catch (ExecutionException e) {
            TimeoutException ex = (TimeoutException) e.getCause();
            System.out.println(ex.getMessage());
        }
    }

}
