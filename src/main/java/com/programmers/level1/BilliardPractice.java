package com.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.coding.utils.Comb.answer;

/*
 * @level1
 * @TestName: 당구 연습
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/169198
 * @COMMENT: ??
 */
public class BilliardPractice {
    static int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        List<Integer> list = new ArrayList<>();
        // m == col, n == row
        int[] start = new int[]{startX, startY};
        for (int[] ball : balls) {
            if (m == n && isLine(start, ball)) {
//                list.add(getDistance(start[0], start[1], ball[0], ball[1]));
            }
            else {
            }
//                int min1 = calcMin(m, n, start, ball);
                int min2 = calcMin(m, n, ball, start);
//                list.add(Math.min(min1, min2));
            list.add(min2);

        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    private static boolean isLine(int[] point1, int[] point2) {
        int x = point1[0] - point2[0];
        int y = point1[1] - point2[1];
        if (x == 0 && y == 0) return true;
        if (x == 0) return false;
        if (y == 0) return false;
        return x / y == 1;
    }


    private static int calcMin(int m, int n, int[] base, int[] goal) {
        // (위, 아래, 왼쪽, 오른쪽)
        int[] output = new int[4];
        int goalX, goalY;
        // 위
        goalX = goal[0];
        goalY = m + (m - goal[1]);
        output[0] = getDistance(goalX, goalY, base[0], base[1]);
        // 아레

        goalX = goal[0];
        goalY = goal[1] * -1;
        output[1] = getDistance(goalX, goalY, base[0], base[1]);
        // 왼쪽
        goalX = goal[0] * -1;
        goalY = goal[1];
        output[2] = getDistance(goalX, goalY, base[0], base[1]);
        // 오른쪽
        goalX = n + (n - goal[0]);
        goalY = goal[1];
        output[3] = getDistance(goalX, goalY, base[0], base[1]);

        int min1 = Math.min(output[0], output[1]);
        int min2 = Math.min(output[2], output[3]);
        return Math.min(min1, min2);
    }

    static int getDistance(int x1, int y1, int x2, int y2) {
        double pow = Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2);

        System.out.println(x1 + ", " + y1 + ", " + x2 + ", " + y2 + " : " + (int) pow);
        return (int) pow;
    }
}
