package com.charles.elites.amazon.oa2;

import java.util.*;

public class KNearestPoints {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Point> points = new ArrayList<Point>();
        Point org = new Point(0, 0);
        points.add(new Point(1, 1, org));
        points.add(new Point(1, 3, org));
        points.add(new Point(-1, -1, org));
        points.add(new Point(1, 2, org));
        points.add(new Point(2, 1, org));
        points.add(new Point(4, 2, org));
        points.add(new Point(6, 1, org));
        points.add(new Point(3, 3, org));
        points.add(new Point(2, 2, org));

        List<Point> res = find(points, 4);
        System.out.println(res);
    }

    public static List<Point> find(List<Point> points, int k) {
        PriorityQueue<Point> queue = new PriorityQueue<Point>(k);
        for (Point p : points) {
            if (queue.size() < k)
                queue.offer(p);
            else if (queue.peek().compareTo(p) < 0) {
                queue.poll();
                queue.offer(p);
            }
        }
        List<Point> res = new ArrayList<Point>();
        for (Point p : queue) {
            res.add(p);
        }
        return res;
    }
}

class Point implements Comparable<Point> {
    int x;
    int y;
    double dis;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, Point origin) {
        this.x = x;
        this.y = y;
        this.dis = Math.hypot(x - origin.x, y - origin.y);
    }

    @Override
    public int compareTo(Point p) {
        return Double.valueOf(p.dis).compareTo(this.dis);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
