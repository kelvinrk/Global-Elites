package com.charles.elites.amazon.oa1;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}

public class ReverseHalfList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode p = head;
		for(int i = 2; i <= 4; i++) {
			p.next = new ListNode(i);
			p = p.next;
		}
		
		reverseHalf(head);
		p = head;
		while(p != null) {
			System.out.println(p.val);
			p = p.next;
		}

	}

	public static void reverseHalf(ListNode head) {
		if(head == null || head.next == null)
            return;
        ListNode pre = head;
        ListNode cur = head;
        while(cur.next != null && cur.next.next != null) {
            cur = cur.next.next;
            pre = pre.next;
        }
        cur = pre.next;
        if(cur == null)
            return;
        while(cur != null && cur.next != null) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
	}
}
