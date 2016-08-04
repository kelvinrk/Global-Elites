package com.charles.elites.quest;

import java.util.LinkedList;
import java.util.Queue;

public class Tollgate {
    Queue<String> queue;

    public Tollgate() {
        this.queue = new LinkedList<String>();
    }

    public void enter(String licensePlate) {
        queue.offer(licensePlate);
    }

    public String exit() {
        if(queue.isEmpty())
            return null;
        return queue.poll();
    }

    public static void main(String[] args) {
        Tollgate tollgate = new Tollgate();
        tollgate.enter("New York");
        tollgate.enter("LA");
        System.out.println(tollgate.exit());
        System.out.println(tollgate.exit());
    }
}