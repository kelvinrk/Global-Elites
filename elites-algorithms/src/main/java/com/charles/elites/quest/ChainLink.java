package com.charles.elites.quest;

enum Side { NONE, LEFT, RIGHT }

public class ChainLink {
    private ChainLink left, right;

    public void append(ChainLink rightPart) {
        if (this.right != null)
            throw new IllegalStateException("Link is already connected.");

        this.right = rightPart;
        rightPart.left = this;
    }

    public Side longerSide() {
        ChainLink cur = this;
        int left = 0;
        int right = 0;
        while(cur.left != null && cur.left != this) {
            left++;
            cur = cur.left;
        }
        if(cur.left == this)
            return Side.NONE;
        cur = this;
        while(cur.right != null) {
            right++;
            cur = cur.right;
        }
        if(left == right)
            return Side.NONE;
        return left > right ? Side.LEFT : Side.RIGHT;
    }

    public static void main(String[] args) {
        ChainLink left = new ChainLink();
        ChainLink middle = new ChainLink();
        ChainLink right = new ChainLink();
        left.append(middle);
        middle.append(right);

        System.out.println(left.longerSide());
    }
}