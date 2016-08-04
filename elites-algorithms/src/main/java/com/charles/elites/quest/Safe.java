package com.charles.elites.quest;

import java.util.ArrayList;
import java.util.Collection;

public class Safe {
    private Collection<String> items = new ArrayList<String>();
    private int capacity;

    public Safe(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public Collection<String> getItems() {
        return new ArrayList<String>(items);
    }

    public void addItem(String item) {
        if (this.items.size() >= capacity)
            throw new IllegalStateException();

        items.add(item);
    }

    @Override
    public String toString() {
        return String.format("Safe: %d/%d", items.size(), capacity);
    }

    public static void main(String[] args) {
        Safe safe = new Safe(2);
        safe.addItem("item");
        System.out.println(safe);
    }
}