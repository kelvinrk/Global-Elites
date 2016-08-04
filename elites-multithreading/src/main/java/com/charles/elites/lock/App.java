package com.charles.elites.lock;

public class App {

    public static void main(String[] args) {
        System.out.println("Synchronized Objects: ");
        WorkerObjectSynchronized worker1 = new WorkerObjectSynchronized();
        worker1.doWork();
        System.out.println("Synchronized Methods: ");
        WorkerMethodsSynchronized worker2 = new WorkerMethodsSynchronized();
        worker2.doWork();
    }
}
