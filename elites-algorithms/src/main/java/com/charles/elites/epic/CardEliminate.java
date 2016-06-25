package com.charles.elites.epic;

class Card {
	int num;
	char letter;

	public Card(int num, char letter) {
		this.num = num;
		this.letter = letter;
	}
}
class ListNode {
	Card c;
	ListNode next;

	ListNode(Card c) {
		this.c = c;
		this.next = null;
	}
}
public class CardEliminate {

	public static void main(String[] args) {
		Card c = new Card(1, 'A');
		ListNode head = new ListNode(c);
		if(play(head))
			System.out.println("You Win!");
		else
			System.out.println("You Lost!");

	}
	private static boolean play(ListNode head) {
		Card c = new Card(0, 'a');
		ListNode helper = new ListNode(c);
		helper.next = head;
		ListNode p1 = helper;
		ListNode p2 = helper;
		int step = 4;
		while(step != 0) {
			p2 = p2.next;
			step--;
		}
		
		while(p2.next != null) {
			if(checkNum(p1, p2)) {
				p1 = helper;
				p2 = helper;
				if(initial(p2))
					return false;
			} else if(checkLetter(p1, p2)) {
				p1 = helper;
				p2 = helper;
				if(initial(p2))
					return false;
			} else {
				p1 = p1.next;
				p2 = p2.next;
			}
		}
		return helper.next == null;
	}
	private static boolean initial(ListNode p2) {
		int step = 4; 
		while(step != 0 && p2.next != null) {
			p2 = p2.next;
			step--;
		}
		if(p2.next == null)
			return false;
		return true;
	}
	private static boolean checkNum(ListNode p1, ListNode p2) {
		if(p1.next.c.num == p2.c.num) {
			p1 = p2.next;
			return true;
		}
		return false;
	}
	private static boolean checkLetter(ListNode p1, ListNode p2) {
		if(p1.next.c.letter == p2.c.letter) {
			p1.next.next = p2;
			return true;
		}
		return false;
	}
}
