package com.charles.elites.amazon.oa2;

import java.lang.*;
import java.util.*;

public class ShortestJobFirst {

	public static void main(String[] args) {
//		int[] a = {0,1,3,4,5,8};
//		int[] e = {5,2,3,1,1,4};
		
		int[] a = {0,1,3,9};
		int[] e = {2,1,7,5};
		System.out.println(shortestJobFirst(a, e));
//		System.out.println(solution(a, e));

	}

	public static double shortestJobFirst(int[] arrive, int[] execute) {
		int  curTime = 0;
		int waitTime = 0;
		int nextJobId = 0;
//		PriorityQueue<Process> queue = new PriorityQueue<Process>(arrive.length, new Comparator<Process>() {
//            public int compare(Process p1, Process p2) {
//                return p1.executeTime - p2.executeTime;
//            }
//        });

		PriorityQueue<Process> queue = new PriorityQueue<>(arrive.length,
				(p1, p2) -> p1.executeTime - p2.executeTime);
		
		while(!queue.isEmpty() || nextJobId < arrive.length) {
			if(!queue.isEmpty()) {
				Process cur = queue.poll();
				waitTime += Math.max(curTime - cur.arriveTime, 0);
				curTime += cur.executeTime;
				for(int i = nextJobId; i < arrive.length; i++) {
					if(arrive[i] <= curTime) {
						queue.offer(new Process(arrive[i], execute[i]));
						nextJobId = i + 1;
					} else 
						break;
				}
			} else {
				queue.offer(new Process(arrive[nextJobId], execute[nextJobId]));
				curTime = arrive[nextJobId++];
			}
		}
		return (double)waitTime / arrive.length;
	}
	
//	public static double shortestJobFirst(int[] arrive, int[] execute) {
//		int curTime = 0;
//		int waitTime = 0;
//		int finishedProcess = 0;
//		boolean[] visited = new boolean[arrive.length];
//		Process cur = new Process(arrive[0], execute[0]);
//		visited[0] = true;
//		while(finishedProcess < arrive.length) {
//			waitTime += curTime - cur.arriveTime;
//			curTime += cur.executeTime;
//			int shortest = Integer.MAX_VALUE;
//			int shortestIndex = 0;
//			for(int i = 0; i < arrive.length; i++) {
//				if(!visited[i] && arrive[i] <= curTime) {
//					if(execute[i] < shortest) {
//						shortest = execute[i];
//						shortestIndex = i;
//					}
//				}
//			}
//			if(shortest == Integer.MAX_VALUE) {
//				if(finishedProcess + 1 == arrive.length)
//					break;
//				else {
//					shortestIndex = finishedProcess + 1;
//					curTime = arrive[shortestIndex];
//				}
//			}
//			visited[shortestIndex] = true;
//			cur = new Process(arrive[shortestIndex], execute[shortestIndex]);
//			finishedProcess++;
//		}
//		return (double)waitTime / arrive.length;
//	}
}
