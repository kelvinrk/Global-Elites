package com.charles.elites.hash;

/**
 * Created by Kelvin.R.K on 6/25/2016.
 *
 * Override both equals and hasCode
 */
public class Teacher {

    private int id;
    private String name;

    public Teacher(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (id != teacher.id) return false;
        return name != null ? name.equals(teacher.name) : teacher.name == null;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
