package com.charles.elites.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by Kelvin.R.K on 7/31/2016.
 */
public class MedianFinder {
    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(3);
        finder.addNum(7);
        finder.addNum(6);
        finder.addNum(2);
        System.out.println(finder.findMedian());
    }

    PriorityQueue<Long> small = new PriorityQueue<Long>(Collections.reverseOrder());
    PriorityQueue<Long> large = new PriorityQueue<Long>();
    // Adds a number into the data structure.
    public void addNum(int num) {
        large.add((long)num);
        small.add(large.poll());
        if(large.size() < small.size())
            large.add(small.poll());
        System.out.println(this);
    }

    // Returns the median of current data stream
    public double findMedian() {
        return large.size() > small.size() ?
                large.peek() : (large.peek() + small.peek()) / 2.0;
    }

    @Override
    public String toString() {
        return "MedianFinder{" +
                "small = " + small +
                ", large = " + large +
                '}';
    }
}
