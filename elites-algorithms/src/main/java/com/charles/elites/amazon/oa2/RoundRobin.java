package com.charles.elites.amazon.oa2;

import java.util.*;

public class RoundRobin {

	public static void main(String[] args) {
		int[] a = {0,1,4};
		int[] e = {5,2,3};
		int q = 3;
		System.out.println(roundRobin(a, e, q));
	}

	//Assume arrive is sorted
	public static double roundRobin(int[] arrive, int[] execute, int q) {
		Queue<Process> queue = new LinkedList<>();
		int curTime = 0;
		int waitTime = 0;
		int nextProId = 0;
		while(!queue.isEmpty() || nextProId < arrive.length) {
			if(!queue.isEmpty()) {
				Process cur = queue.poll();
				waitTime += curTime - cur.arriveTime;
				curTime += Math.min(q, cur.executeTime);
				for (int i = nextProId; i < arrive.length && arrive[i] <= curTime; i++) {
					queue.offer(new Process(arrive[i], execute[i]));
					nextProId = i + 1;
				}
				if(cur.executeTime > q) {
					queue.offer(new Process(curTime, cur.executeTime - q));
				}
			} else {
				queue.offer(new Process(arrive[nextProId], execute[nextProId]));
				curTime = arrive[nextProId++];
			}
		}
		return (double)waitTime / arrive.length;
	}
}

    class Process {
    	int arriveTime;
    	int executeTime;
    	public Process(int arr, int exc) {
    		this.arriveTime = arr;
    		this.executeTime = exc;
    	}
    }
