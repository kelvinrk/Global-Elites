package com.charles.elites.bloomberg;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Kelvin.R.K on 7/5/2016.
 */
public class FamilyMember {
}

class Person {
    Person father;
    Person mother;
    List<Person> children;
    String name;

    public Person(Person father, Person mother, List<Person> children, String name) {
        this.father = father;
        this.mother = mother;
        this.children = children;
        this.name = name;
    }
}

class Family {
    Map<String, Set<Person>> members;

    boolean isMember(Person person) {
        return true;
    }

    boolean areCousin(Person a, Person b) {
        return areSibling(a.father, b.father) || areSibling(a.father, b.mother) ||
                areSibling(a.mother, b.father) || areSibling(a.mother, b.mother);
    }

    boolean areSibling(Person a, Person b) {
        return (a.father == b.father && a.mother == b.mother);
    }
}
