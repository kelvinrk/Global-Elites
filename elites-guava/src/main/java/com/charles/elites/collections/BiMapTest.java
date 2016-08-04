package com.charles.elites.collections;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.Map;

/**
 * Created by Kelvin.R.K on 5/10/2016.
 */
public class BiMapTest {
    public static void main(String[] args) {
        testHashBiMap();
    }

    public static void testHashBiMap() {
        BiMap<String, Integer> userId = HashBiMap.create();

        userId.put("Kelvin", 1);
        userId.put("Syer", 2);
        userId.put("Charles", 3);
        userId.put("Damon", 4);
        userId.put("Caro", 5);
        userId.put("Ronaldo", 6);
        userId.put("Messi", 7);
        userId.put("Neymar", 8);

        userId.forcePut("Ronaldo", 7);

        Map<Integer, String> idUser = userId.inverse();

        System.out.println("\n***************** userId *****************\n");
        System.out.println(userId);

        System.out.println("\n***************** idUser *****************\n");
        System.out.println(idUser);
    }

}
