package com.charles.elites.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Kelvin.R.K on 7/30/2016.
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue= new LinkedList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        deque.pollLast();
    }
}
