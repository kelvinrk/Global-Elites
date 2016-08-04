package com.charles.elites.amazon.oa2;

public class InsertIntoCycleList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(3);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(5);
		ListNode l4 = new ListNode(5);
		ListNode l5 = new ListNode(6);
		ListNode l6 = new ListNode(10);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l1;
		ListNode res = insert(l3, 3);
		
		
//		ListNode lx = null;
//		ListNode res = insert(lx, 100);
		
//		ListNode single = new ListNode(10);
//		single.next = single;
//		ListNode res = insert(single, 100);
		
		ListNode p = res;
		System.out.print(p.val);
		while(p.next != res) {
			p = p.next;
			System.out.print(" -> " + p.val);
		}
	}

	
	public static ListNode insert(ListNode node, int val) {
		ListNode res = new ListNode(val);
		if(node == null) {
			res.next = res;
			return res;
		}
		if(node.next == node) {
			node.next = res;
			res.next = node;
			return res;
		}
		
		
		ListNode pre = findPreInsertNode(node, val);
		res.next = pre.next;
		pre.next = res;
		
		return res;
	}
	
	private static ListNode findPreInsertNode(ListNode node, int val) {
		ListNode minNode = findMin(node);
		ListNode pre = minNode;
		
		if(val < minNode.val) {
			while(pre.next != minNode) {
				pre = pre.next;
			}
			return pre;
		}
		
		while(pre.next.val < val && pre.next != minNode) {
			pre = pre.next;
		}
		
		return pre;
	}
	
	private static ListNode findMin(ListNode node) {
		ListNode p = node.next;
		ListNode res = node;
		int min = node.val;
		while(p != node) {
			if(p.val < min) {
				min = p.val;
				res = p;
			}
			p = p.next;
		}
		return res;
	}
}
