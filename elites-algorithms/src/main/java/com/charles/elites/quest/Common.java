package com.charles.elites.quest;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

public class Common {
    public static int kthMostCommon(int[] a, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i : a) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 0);
            }
        }

        Comparator<Map.Entry<Integer, Integer>> comp = new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        };


        Iterator it = map.entrySet().iterator();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>(map.size(), comp);
        while (it.hasNext()) {
            pq.offer((Map.Entry) it.next());
        }

        while(--k != 0) {
            pq.poll();
        }

        return (Integer) pq.poll().getKey();
    }

    public static void main(String[] args) {
        int x = kthMostCommon(new int[]{5, 4, 3, 2, 1, 5, 4, 3, 2, 5, 4, 3, 5, 4, 5}, 2);
        System.out.println(x);
    }
}