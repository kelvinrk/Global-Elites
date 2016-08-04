package com.charles.elites.objects;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import jersey.repackaged.com.google.common.base.MoreObjects;

/**
 * Created by Kelvin.R.K on 7/1/2016.
 */
public class Employee implements Comparable<Employee> {
    private int id;
    private String firstName;


    private String lastName;
    private String department;

    public Employee(int id, String firstName, String lastName, String department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    @Override
    public int compareTo(Employee that) {
        return ComparisonChain.start()
                .compare(this.id, that.id, Ordering.natural())
                .compare(this.lastName, that.lastName, Ordering.natural())
                .compare(this.firstName, that.firstName, Ordering.natural())
                .compare(this.department, that.department, Ordering.natural().nullsLast())
                .result();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this.getClass())
                .add("ID", id)
                .add("lastName", lastName)
                .add("firstName", firstName)
                .add("department", department)
                .toString();
    }
}