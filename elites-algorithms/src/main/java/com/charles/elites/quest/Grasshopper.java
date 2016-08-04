package com.charles.elites.quest;

public class Grasshopper {
    private ListNode current;
    /**
     * Initialization of view field with n leaves and grasshopper on leaf 'position'.
     *
     * @param n        Number of leaves in row.
     * @param position
     */
    public Grasshopper(int n, int position) {
        ListNode head = new ListNode(1);
        ListNode pre = head;
        for (int i = 2; i <= n; i++) {
            ListNode cur = new ListNode(i);
            pre.next = cur;
            cur.pre = pre;
            pre = pre.next;
        }
        current = head;
        while(position != 1) {
            current = current.next;
            position--;
        }
    }

    /**
     * Grasshopper has eaten the current leaf and hopped left.
     */
    public void eatAndHopLeft() {
        if(current.pre != null && current.pre.pre != null) {
            current.pre.next = current.next;
            if(current.next != null)
                current.next.pre = current.pre;

            ListNode temp = current.pre;
            current.next = null;
            current.pre = null;
            current = temp.pre;
        }
    }

    /**
     * Grasshopper has eaten the current leaf and hopped right.
     */
    public void eatAndHopRight() {
        if(current.next != null && current.next.next != null) {
            if(current.pre != null)
                current.pre.next = current.next;
            current.next.pre = current.pre;

            ListNode temp = current.next;
            current.next = null;
            current.pre = null;
            current = temp.next;
        }
    }

    /**
     * Return the leaf number that grasshopper is feeding on right now.
     *
     * @return Leaf number that grasshopper is feeding on right now.
     */
    public int whereAmI() {
        return current.val;
    }

    public static void main(String[] args) {
        Grasshopper g = new Grasshopper(5, 2);
        System.out.println(g.whereAmI());

        g.eatAndHopRight();
        System.out.println(g.whereAmI());

        g.eatAndHopLeft();
        System.out.println(g.whereAmI());
    }
}

class ListNode {
    ListNode pre;
    ListNode next;
    int val;

    public ListNode(int val) {
        this.val = val;
    }
}