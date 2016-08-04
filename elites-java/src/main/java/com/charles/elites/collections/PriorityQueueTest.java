package com.charles.elites.collections;

import com.charles.elites.objects.Student;

import java.util.PriorityQueue;

/**
 * Created by Kelvin.R.K on 7/5/2016.
 */
public class PriorityQueueTest {
    static int capacity = 10;
    static PriorityQueue<Student> queue = new PriorityQueue<>(capacity);
    
    public static void main(String[] args) {
        loadPriorityQueue();
        for(Student student : queue)
            System.out.println(student);
        System.out.println(queue.contains(new Student(2, "XXX")));
    }

    private static void testPriorityQueue() {

        PriorityQueue<Integer> queue = new PriorityQueue<>(capacity);

        for(int i = 0; i < 100; i++) {
            queue.offer(i);
        }
        queue.remove(1);
        System.out.println(queue);
    }
    
    private static void loadPriorityQueue() {
        queue.offer(new Student(1, "Charles"));
        queue.offer(new Student(5, "Ronaldo"));
        queue.offer(new Student(6, "Caesar"));
        queue.offer(new Student(2, "Lucas"));
        queue.offer(new Student(4, "Neymar"));
        queue.offer(new Student(3, "Bale"));
        queue.offer(new Student(7, "Ibra"));
    }
}
