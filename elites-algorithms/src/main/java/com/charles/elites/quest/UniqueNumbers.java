package com.charles.elites.quest;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UniqueNumbers {
    public static Collection<Integer> findUniqueNumbers(Collection<Integer> numbers) {
        if (numbers == null || numbers.size() < 2)
            return numbers;
        Set<Integer> duplicate = new HashSet<>();
        Set<Integer> once = new HashSet<>();

        Iterator it = numbers.iterator();
        while (it.hasNext()) {
            int i = (Integer) it.next();
            if (once.contains(i)) {
                once.remove(i);
                duplicate.add(i);
            } else if(!duplicate.contains(i)){
                once.add(i);
            }
        }
        return once;
    }

    public static void main(String[] args) {
        Collection<Integer> numbers = Arrays.asList(1, 2, 1, 3, 1, 4, 5, 6, 7);
        findUniqueNumbers(numbers).forEach(System.out::println);
    }
}