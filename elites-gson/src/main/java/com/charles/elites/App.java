package com.charles.elites;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        Student student = new Student();
        student.setId(100);

        String studentJson = new Gson().toJson(student);

        System.out.println(studentJson);

        Student studentFromJson = new Gson().fromJson(studentJson, Student.class);

        System.out.println(studentFromJson.getId());
    }
}
