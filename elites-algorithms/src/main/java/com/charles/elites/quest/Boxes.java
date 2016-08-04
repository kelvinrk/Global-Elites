package com.charles.elites.quest;

public class Boxes {
    public static int minimalNumberOfBoxes(int products, int availableLargeBoxes, int availableSmallBoxes) {
        if(5 * availableLargeBoxes + availableSmallBoxes < products)
            return -1;
        int large = products / 5;
        if(large > availableLargeBoxes)
            large = availableLargeBoxes;
        int small = products - large * 5;
        if(small > availableSmallBoxes)
            return -1;
        return small + large;
    }

    public static void main(String[] args) {
        System.out.println(minimalNumberOfBoxes(16, 2, 10));
    }
}