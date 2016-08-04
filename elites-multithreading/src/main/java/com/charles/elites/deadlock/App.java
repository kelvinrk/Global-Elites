package com.charles.elites.deadlock;

import com.charles.elites.utils.Run;

/**
 * <a href="https://wikipedia.org/wiki/Deadlock">Deadlock</a>
 * can occur in a situation when a thread is waiting for an object's lock,
 * that is acquired by another thread and the second thread is waiting for an
 * object lock that is acquired by first thread. Since, both threads are waiting
 * for each other to release the lock, the condition is called deadlock. If you
 * make sure that all locks are always taken in the same order by any thread,
 * deadlocks cannot occur.
 */
public class App {

    public static void main(String[] args) throws Exception {
        final DeadLockRunner deadLockRunner = new DeadLockRunner();
        Run.testRun(deadLockRunner);
    }
}
