package com.charles.elites.quest;

import java.util.HashMap;

public class NamesCount {
    private int count;
    private HashMap<String, Integer> counts = new HashMap<String, Integer>();

    /**
     * Adds the name.
     * @param name Name.
     */
    public void addName(String name) {

        if(!counts.containsKey(name)) {
            counts.put(name, 1);
        } else {
            counts.put(name, counts.get(name) + 1);
        }
        count++;
    }

    /**
     * Returns proportion of parameter name in all calls to addName.
     * @param name Name.
     * @return Double in interval [0, 1]. Returns 0 if AddName has not been called.
     */
    public double nameProportion(String name) {
        return (double)counts.get(name) / count;
    }

    public static void main(String[] args) {
        NamesCount namesCount = new NamesCount();

        namesCount.addName("James");
        namesCount.addName("John");
        namesCount.addName("Mary");
        namesCount.addName("Mary");

        System.out.println(namesCount.counts);

        System.out.println("Fraction of Johns: " + namesCount.nameProportion("John"));
        System.out.println("Fraction of Marys: " + namesCount.nameProportion("Mary"));
    }
}