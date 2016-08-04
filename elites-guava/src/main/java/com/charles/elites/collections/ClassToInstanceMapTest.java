package com.charles.elites.collections;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;

/**
 * Created by Kelvin.R.K on 5/10/2016.
 */
public class ClassToInstanceMapTest {
    public static void main(String[] args) {
        testClassToInstanceMap();
    }

    public static void testClassToInstanceMap() {
        ClassToInstanceMap<Number> numberMap = MutableClassToInstanceMap.create();
        numberMap.putInstance(Integer.class, 100);
        numberMap.putInstance(Double.class, 66.66);

        System.out.println(numberMap.getInstance(Integer.class));
        System.out.println(numberMap.getInstance(Double.class));
    }
}
