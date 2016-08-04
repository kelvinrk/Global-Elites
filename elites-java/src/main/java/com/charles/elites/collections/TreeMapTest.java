package com.charles.elites.collections;

import com.charles.elites.objects.Student;

import java.util.TreeMap;

/**
 * Created by Kelvin.R.K on 7/1/2016.
 */
public class TreeMapTest {

    private static TreeMap<Student, Integer> transcript = new TreeMap<>();

    public static void main(String[] args) {
        loadMap();
        transcript.keySet().forEach(System.out::println);
    }

    private static void loadMap() {
        transcript.put(new Student(1, "Charles"), 100);
        transcript.put(new Student(5, "Ronaldo"), 98);
        transcript.put(new Student(6, "Caesar"), 80);
        transcript.put(new Student(2, "Lucas"), 95);
        transcript.put(new Student(4, "Neymar"), 90);
        transcript.put(new Student(3, "Bale"), 92);
        transcript.put(new Student(7, "Ibra"), 88);
    }
}
