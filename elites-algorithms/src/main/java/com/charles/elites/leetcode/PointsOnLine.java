package com.charles.elites.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kelvin.R.K on 7/26/2016.
 */
public class PointsOnLine {

    public static void main(String[] args) {
        Point[] points = {new Point(2, 3), new Point(3, 3), new Point(-5, 3)};
        new PointsOnLine().maxPoints(points);

    }
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0)
            return 0;
        Map<Double, Integer> res = new HashMap<Double, Integer>();
        int max = 0;
        for(int i = 0; i < points.length; i++) {
            int vertical = 0;
            int duplicates = 1;
            for(int j = i + 1; j < points.length; j++) {
                if(points[i].x == points[j].x) {
                    if(points[i].y == points[j].y)
                        duplicates++;
                    else
                        vertical++;
                } else {
                    double slope = points[i].y == points[j].y ? 0.0 : 1.0 * (points[i].y - points[j].y) / (points[j].x - points[i].x);
                    res.put(slope, res.getOrDefault(slope, 0) + 1);
                }
            }
            for(Integer count : res.values())
                max = Math.max(count + duplicates, max);
            max = Math.max(max, vertical + duplicates);
            res.clear();
        }
        return max;
    }
}

class Point {
     int x;
     int y;
     Point() { x = 0; y = 0; }
     Point(int a, int b) { x = a; y = b; }
}

