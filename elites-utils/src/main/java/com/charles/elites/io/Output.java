package com.charles.elites.io;

import java.util.Map;
import java.util.Set;

/**
 * Created by Kelvin.R.K on 7/1/2016.
 */
public final class Output {

    public static <T> void print(Set<T> set) {
        set.forEach(System.out::println);
    }

    public static <K, V> void print(Map<K, V> map) {
        map.forEach((k, v) -> System.out.println(k + " = " + v));
    }
}
