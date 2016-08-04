package com.charles.elites.objects;

import jersey.repackaged.com.google.common.base.MoreObjects;

/**
 * Created by Kelvin.R.K on 6/25/2016.
 *
 * Only Override equals
 */
public class Student implements Comparable<Student>{
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public int compareTo(Student o) {
        return this.id - o.id;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper("Student")
                .add("ID", id)
                .add("Name", name)
                .toString();
    }
}
