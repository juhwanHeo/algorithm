package com.programmers.weekly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/*
 * @Weekly 10
 * @TestName: 교점에 별 만들기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/87377
 */
public class Task10 {

    static class Point {
        long x;
        long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    "} \n";
        }
    }

    public static String[] solution(int[][] lines) {
        List<Point> list = new ArrayList<>();
        List<String> answer = new ArrayList<>();

        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;

        for (int i = 0; i < lines.length; i++) {
            for (int k = i + 1; k < lines.length; k++) {
                Point point = getIntersection(lines[i], lines[k]);
                if (point != null)  {
                    list.add(point);
                    maxX = Math.max(maxX, point.x);
                    maxY = Math.max(maxY, point.y);
                    minX = Math.min(minX, point.x);
                    minY = Math.min(minY, point.y);

                }
            }
        }

        for (int y = 0; y < maxY - minY + 1; y++) {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < maxX - minX + 1; x++) {
                sb.append(".");
            }
            answer.add(sb.toString());
        }

        System.out.println(answer);
        System.out.println("maxX: " + maxX);
        System.out.println("maxY: " + maxY);
        System.out.println("minX: " + minX);
        System.out.println("minY: " + minY);
        System.out.println(list);
        System.out.println(list.size());

        for (Point point : list) {
            StringBuilder sb = new StringBuilder(answer.get((int) (maxY - point.y)));
            sb.setCharAt((int) (point.x - minX), '*');
            answer.set((int) (maxY - point.y), sb.toString());
        }

        return answer.toArray(new String[0]);
    }

    private static Point getIntersection(int[] p1, int[] p2) {
        long A = p1[0];
        long B = p1[1];
        long E = p1[2];
        long C = p2[0];
        long D = p2[1];
        long F = p2[2];

        long mok = A * D - B * C;
        if (mok == 0) return null;

        double x = ((B * F) - (E * D)) / (double) mok;
        double y = ((E * C) - (A * F)) / (double) mok;

        if ((x - (long) x == 0.0) && (y - (long) y == 0.0))
            return new Point((long) x, (long) y);
        return null;
    }

    public static void main(String[] args) {
        int n1 = 9;
        int n2 = 4;
        int[][] line = {
//                {2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}
                {0, 1, -1}, {1, 0, -1}, {1, 0, 1}
        };
        String[] res1 = {
                "....*....",
                ".........",
                ".........",
                "*.......*",
                ".........",
                ".........",
                ".........",
                ".........",
                "*.......*"
        };

        System.out.println(Arrays.toString(solution(line)));
    }
}
