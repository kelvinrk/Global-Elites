package com.charles.elites.sam;

/**
 * Created by Kelvin.R.K on 7/30/2016.
 */
@FunctionalInterface
public interface SimpleFunctionalInterface {
    void doWork();

    String toString();

    boolean equals(Object o);

//    void talk();

    default void talk() {
        System.out.println("Hello friend!");
    }
}
