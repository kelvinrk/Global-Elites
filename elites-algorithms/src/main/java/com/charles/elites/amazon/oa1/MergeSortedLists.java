package com.charles.elites.amazon.oa1;

import java.util.*;

public class MergeSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode p1 = l1;
		ListNode l2 = new ListNode(2);
		ListNode p2 = l2;
		ListNode l3 = new ListNode(7);
		ListNode p3 = l3;
		for(int i = 3; i <= 20; i += 2) {
			p1.next = new ListNode(i);
			p1 = p1.next;
		}
		
		for(int i = 4; i <= 20; i += 2) {
			p2.next = new ListNode(i);
			p2 = p2.next;
		}
		
		for(int i = 8; i <= 30; i += 3) {
			p3.next = new ListNode(i);
			p3 = p3.next;
		}
		
		ListNode[] list = {l1, l2, l3};
		ListNode head = mergeKLists(list);
//		ListNode head = mergeTwoLists(l1, l2);
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode helper = new ListNode(0);
        ListNode p = helper;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                p.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                p.next = new ListNode(l2.val);
                l2= l2.next;
            }
            p = p.next;
        }
        if(l1 == null)
            p.next = l2;
        else 
            p.next = l1;
        return helper.next;
    }
	
	public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
//        PriorityQueue<ListNode> p = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
//                public int compare(ListNode l1, ListNode l2) {
//                    return l1.val - l2.val;
//                }
//            });
        PriorityQueue<ListNode> p = new PriorityQueue<ListNode>(lists.length, (l1, l2) -> l1.val - l2.val);
        ListNode helper = new ListNode(0);
        ListNode cur = helper;
        for(ListNode each : lists)
            if(each != null)
                p.offer(each);
        while(!p.isEmpty()) {
            ListNode temp = p.poll();
            if(temp.next != null)
                p.offer(temp.next);
            cur.next = temp;
            cur = cur.next;
        }
        return helper.next;
    }
}


