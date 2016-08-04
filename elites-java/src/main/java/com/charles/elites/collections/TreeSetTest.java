package com.charles.elites.collections;

import com.charles.elites.objects.Student;

import java.util.TreeSet;

/**
 * Created by Kelvin.R.K on 7/1/2016.
 */
public class TreeSetTest {
    
    private static TreeSet<Student> studentTreeMap = new TreeSet<>();

    private static TreeSet<Integer> treeSet = new TreeSet<>();
    
    public static void main(String[] args) {
//        loadStudentSet();
//        studentTreeMap.forEach(System.out::println);
//        System.out.println(studentTreeMap.contains(new Student(2, "XXX")));

        loadIntegerTreeSet();
        testTreeSet();
    }

    private static void loadStudentSet() {
        System.out.println(studentTreeMap.add(new Student(1, "Charles")));
        System.out.println(studentTreeMap.add(new Student(1, "Charles")));
        System.out.println(studentTreeMap.add(new Student(1, "Charles")));
        studentTreeMap.add(new Student(5, "Ronaldo"));
        studentTreeMap.add(new Student(6, "Caesar"));
        studentTreeMap.add(new Student(2, "Lucas"));
        studentTreeMap.add(new Student(4, "Neymar"));
        studentTreeMap.add(new Student(3, "Bale"));
        studentTreeMap.add(new Student(7, "Ibra"));

//        studentTreeMap.remove(new Student(2, "XXX"));
    }

    private static void testTreeSet() {
        System.out.println(treeSet.lower(3));
        System.out.println(treeSet.higher(100));
    }

    private static void loadIntegerTreeSet() {
        treeSet.add(10);
        treeSet.add(4);
        treeSet.add(7);
        treeSet.add(12);
        treeSet.add(5);
    }
}
