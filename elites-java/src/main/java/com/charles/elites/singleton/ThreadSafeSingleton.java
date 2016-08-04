package com.charles.elites.singleton;

/**
 * Created by Kelvin.R.K on 7/29/2016.
 */
public class ThreadSafeSingleton {

    private volatile static ThreadSafeSingleton instance;

    private ThreadSafeSingleton(){}

    public static synchronized ThreadSafeSingleton getInstance(){
        ThreadSafeSingleton result = instance;
        if(result == null){
            synchronized(ThreadSafeSingleton.class) {
                result = instance;
                if(result == null)
                    result = new ThreadSafeSingleton();
            }
        }
        return result;
    }

//    public static synchronized ThreadSafeSingleton getInstance(){
//        if(instance == null){
//            synchronized(ThreadSafeSingleton.class) {
//                if(instance == null)
//                    instance = new ThreadSafeSingleton();
//            }
//        }
//        return instance;
//    }
}