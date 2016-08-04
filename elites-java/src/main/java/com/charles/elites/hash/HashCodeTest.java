package com.charles.elites.hash;

import com.charles.elites.objects.Student;
import com.charles.elites.objects.Teacher;
import com.google.common.collect.Sets;

import java.util.Set;

/**
 * Created by Kelvin.R.K on 6/25/2016.
 */
public class HashCodeTest {
    public static void main(String[] args) {
        testTeacher();
        testStudent();
    }

    private static void testTeacher() {
        Teacher t1 = new Teacher(1, "Luis");
        Teacher t2 = new Teacher(1, "Cabin");
        Teacher t3 = new Teacher(2, "Cavali");
        Teacher t4 = new Teacher(3, "Cavali");
        Teacher t5 = new Teacher(4, "Laza");

        System.out.println("************************** HashCode **************************\n");
        System.out.println("t1 " + t1.hashCode());
        System.out.println("t2 " + t2.hashCode());
        System.out.println("t3 " + t3.hashCode());
        System.out.println("t4 " + t4.hashCode());
        System.out.println("t5 " + t5.hashCode());

        Set<Teacher> set = Sets.newHashSet();
        set.add(t1);
        set.add(t2);
        set.add(t3);
        set.add(t4);
        set.add(t5);

        System.out.println("t1.hashCode() == t2.hashCode() : " + (t1.hashCode() == t2.hashCode()));
        System.out.println("set.contains(new Teacher(1, \"Luis\")) " + set.contains(new Teacher(1, "Luis")));
        System.out.println(set);
    }

    private static void testStudent() {
        Student s1 = new Student(1, "Kevin");
        Student s2 = new Student(1, "Jack");
        Student s3 = new Student(2, "Cristiano");

        System.out.println("\n************************** HashCode **************************\n");
        System.out.println("s1 " + s1.hashCode());
        System.out.println("s2 " + s2.hashCode());
        System.out.println("s3 " + s3.hashCode());

        Set<Student> set = Sets.newHashSet();
        set.add(s1);
        set.add(s2);
        set.add(s3);

        System.out.println("set.contains(new Student(1, \"Kevin\")) " + set.contains(new Student(1, "Kevin")));
        System.out.println("set.contains(s1) " + set.contains(s1));
    }
}
