package com.charles.elites.basic;

import com.charles.elites.io.Output;
import com.charles.elites.objects.Employee;
import com.google.common.collect.Sets;

import java.util.TreeSet;

/**
 * Created by Kelvin.R.K on 7/1/2016.
 */
public class ComparisonChainTest {
    public static void main(String[] args) {
        testComparisonChain();
    }

    public static void testComparisonChain() {
        TreeSet<Employee> treeSet = Sets.newTreeSet();
        treeSet.add(new Employee(1, "Cole", "Ramsey", "IT"));
        treeSet.add(new Employee(2, "Jacob", "Omen", "HR"));
        treeSet.add(new Employee(3, "Jacob", "Nani", "IB"));
        treeSet.add(new Employee(4, "Zach", "Ross", "EQ"));
        Output.print(treeSet);
    }
}

