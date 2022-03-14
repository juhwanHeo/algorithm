package com.coding.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/*
 * @level2
 * @TestName: 방문 길이
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/49994
 */
public class DoorLength {

    static class Point {
        int x;
        int y;
        int movedX;
        int movedY;

        public Point(int x, int y, int movedX, int movedY) {
            this.x = x;
            this.y = y;
            this.movedX = movedX;
            this.movedY = movedY;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return (x == point.x && y == point.y
                        && movedX == point.movedX && movedY == point.movedY)
                    || (x == point.x && y == point.movedY
                        && movedX == point.movedX && movedY == point.y)
                    || (x == point.movedX && y == point.y
                        && movedX == point.x && movedY == point.movedY);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, movedX, movedY);
        }
    }

    static int[][] rooms;
    static List<Point> list;
    // x, y , mX, mY == x, y , mx, my
    // 0, 0 , 0 , 1  == 0, 1 , 0 , 0
    public static int solution(String dirs) {
        rooms = new int[11][11];
        list = new ArrayList<>();

        int answer = 0;
        int[] current = {5, 5};
        for (String s : dirs.split("")) {
            int x = current[0];
            int y = current[1];
            int movedX = x;
            int movedY = y;
            switch (s) {
                case "U":
                    movedY++;
                    break;
                case "D":
                    movedY--;
                    break;
                case "R":
                    movedX++;
                    break;
                case "L":
                    movedX--;
                    break;
            }
            if (canMove(movedX, movedY)) {
                Point point = new Point(x, y , movedX, movedY);
                if (rooms[y][x] == 0 || !list.contains(point)) {
                    answer++;
                    list.add(point);
                }

                current[0] = movedX;
                current[1] = movedY;
                rooms[movedY][movedX] = 1;
            }
        }

        for (int[] room : rooms) {
            System.out.println(Arrays.toString(room));
        }
        return answer;
    }

    public static boolean canMove(int movedRow, int movedCol) {
        return movedRow >= 0 && movedRow < rooms.length
                && movedCol >=0 && movedCol < rooms[0].length;
    }

    public static void main(String[] args) {
        String dirs1 = "ULURRDLLU"; // 7
        String dirs2 = "LULLLLLLU"; // 7
        String dirs3 = "LRLRL"; // 1
//        System.out.println("dirs2.length() = " + dirs2.length());
//        System.out.println("solution(dirs1) = " + solution(dirs1));
//        System.out.println("solution(dirs2) = " + solution(dirs2));
        System.out.println("solution(dirs3) = " + solution(dirs3));

    }
}
