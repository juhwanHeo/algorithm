package com.programmers.kakao2023.blind;

import java.util.*;

/*
 * @2023 KAKAO BLIND RECRUITM합NT
 * @TestName: 표 병합
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/150366
 * @COMMENT: 2, 14 Not Pass
 */
public class Test5 {

    static class Point implements Comparable<Point>{
        int col, row;
        String value;

        public Point(int row, int col, String value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return col == point.col && row == point.row;
        }

        @Override
        public int hashCode() {
            return Objects.hash(col, row, value);
        }

        @Override
        public String toString() {
            return "(" + row + ", " + col + ", " + value + ")";
        }

        @Override
        public int compareTo(Point o) {
            return value.compareTo(o.value);
        }
    }

    static Point[][] parent;
    static List<String> printList;
    public static String[] solution(String[] commands) {
//        parent = new Point[51]; // -1 연산 하기 귀찬음
        parent = new Point[5][5]; // -1 연산 하기 귀찬음
        printList = new ArrayList<>();
        for (int i = 0; i < parent.length; i++) {
            for (int j = 0; j < parent[i].length; j++) {
                parent[i][j] = new Point(i, j, null);
            }
        }
        for (String command : commands) {
            String[] split = command.split(" ");
            String cmd = split[0];
            System.out.println("### command: " + command);

            if ("UPDATE".equals(cmd)) {
                if (split.length == 4) {
                    int row = Integer.parseInt(split[1]);
                    int col = Integer.parseInt(split[2]);
                    String value = split[3];
                    update(row, col, value);
                }
                else {
                    String value1 = split[1];
                    String value2 = split[2];
                    update(value1, value2);

                }
            }
            else if ("MERGE".equals(cmd)) {
                int row1 = Integer.parseInt(split[1]);
                int col1 = Integer.parseInt(split[2]);
                int row2 = Integer.parseInt(split[3]);
                int col2 = Integer.parseInt(split[4]);
                merge(row1, col1, row2, col2);
            }

            else if ("UNMERGE".equals(cmd)) {
                int row = Integer.parseInt(split[1]);
                int col = Integer.parseInt(split[2]);

                unMerge(row, col);
            }
            else if ("PRINT".equals(cmd)) {
                int row = Integer.parseInt(split[1]);
                int col = Integer.parseInt(split[2]);
                print(row, col);
            }

            print();
        }

        return printList.stream()
                .map(String::valueOf)
                .toArray(String[]::new);
    }

    static Point find(Point point) {
        if (point == null || parent[point.row][point.col] == null) return point;
        if (parent[point.row][point.col].equals(point)) return point;
        return parent[point.row][point.col] = find(parent[point.row][point.col]);
    }

    // 선택한 셀의 값을 value2로 바꿉니다.
    static void update(String value1, String value2) {
//        Point point = map.get(value1);
//        if (point != null) point.value = value2;
        for (int i = 0; i < parent.length; i++) {
            for (int j = 0; j < parent[i].length; j++) {
                if (parent[i][j].value != null && parent[i][j].value.equals(value1))
                    parent[i][j].value = value2;
            }
        }
    }

    static void update(int r, int c, String value) {
        Point point = new Point(r, c, value);
        Point root = find(point);
        parent[r][c] = root != null ? root : point;
        parent[r][c].value = value;

        for (int i = 0; i < parent.length; i++) {
            for (int j = 0; j < parent[i].length; j++) {
                if (find(parent[i][j]).equals(root)) parent[i][j] = root;
            }
        }
    }

    /*
    * 두 셀 중 한 셀이 값을 가지고 있을 경우 병합된 셀은 그 값을 가지게 됩니다.
    * 두 셀 모두 값을 가지고 있을 경우 병합된 셀은 (r1, c1) 위치의 셀 값을 가지게 됩니다.
    * ### command: MERGE 2 1 1 1
    * */
    static void merge(int r1, int c1, int r2, int c2) {
        if (r1 == r2 && c1 == c2) return;
        Point point1 = find(parent[r1][c1]);
        Point point2 = find(parent[r2][c2]);

        String value1 = point1.value;
        String value2 = point2.value;

        parent[point2.row][point2.col] = point1;
        for (int i = 0; i < parent.length; i++) {
            for (int j = 0; j < parent[i].length; j++) {
                if (point1.equals(find(parent[i][j]))) parent[i][j] = point1;
            }
        }
        if (value1 == null && value2 != null)
            parent[point1.row][point1.col].value = point2.value;
    }

    static void unMerge(int r, int c) {
        Point root = find(parent[r][c]);
        if (root != null) {
            for (int i = 0; i < parent.length; i++) {
                for (int j = 0; j < parent[i].length; j++) {
                    if (root.equals(find(parent[i][j]))) parent[i][j] = new Point(i, j, null);
                }
            }

            Point newPoint = new Point(r, c, root.value != null ? root.value : null);
            parent[r][c] = newPoint;
        }
    }

    static void print(int r, int c) {
        String result = "EMPTY";
        Point point = find(parent[r][c]);
        System.out.println("### print parent: " + point);
        if (point != null && point.value != null) {
            result = find(point).value;
        }
        printList.add(result);
    }

    /*
    * Test Print
    * */
    static void print() {
        for (int i = 0; i < parent.length; i++) {
            for (int j = 0; j < parent[i].length; j++) {
                System.out.print(parent[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("=================================\n");
    }
}
