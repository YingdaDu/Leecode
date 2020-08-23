package com.company;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.*;
import java.math.BigDecimal;
import java.text.NumberFormat;

public class Main {

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int dist(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }

    public static int closestDistance(int n, int[] xList, int[] yList) {
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(xList[i], yList[i]);
        }

        Point[] xPoints = Arrays.copyOf(points, n);
        Arrays.sort(xPoints, (p1, p2) -> p1.x - p2.x);
        return findClosest(xPoints, n);
    }

    private static int findClosest(Point[] points, int n) {
        if (n <= 3) return findMin(points);

        int mid = n / 2;
        Point midPoint = points[mid];

        Point[] left = new Point[mid];
        System.arraycopy(points, 0, left, 0, mid);
        Point[] right = new Point[n - mid];
        System.arraycopy(points, mid, right, 0, n - mid);
        int dl = findClosest(left, mid);
        int dr = findClosest(right, n - mid);

        int d = Math.min(dl, dr);

        //build strip b
        List<Point> strip = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (Math.abs(points[i].x - midPoint.x) < d) {
                strip.add(points[i]);
            }
        }
        Point[] stripArray = strip.toArray(new Point[0]);

        int d1 = stripClosest(stripArray, strip.size(), d);
        return Math.min(d, d1);
    }

    private static int stripClosest(Point[] strip, int n, int d) {
        Arrays.sort(strip, (a, b) -> a.y - b.y);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n && (strip[j].y - strip[i].y < d); j++) {
                min = Math.min(min, dist(strip[i], strip[j]));
            }
        }
        return min;
    }

    private static int findMin(Point[] points) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                min = Math.min(min, dist(points[i], points[j]));
            }
        }
        return min;
    }


    public static void main(String[] args) {
        int[] x1 = {2, 12, 40, 5, 12, 3};
        int[] y1 = {3, 30, 50, 1, 10, 4};
        int ans1 = closestDistance(6, x1, y1);
        System.out.println(ans1);
    }
}

