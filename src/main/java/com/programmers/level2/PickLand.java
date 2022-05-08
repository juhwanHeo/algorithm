package com.programmers.level2;

import java.util.Arrays;

/*
 * @level2
 * @TestName: 땅따먹기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12913
 * @COMMENT DP 문제
 */
public class PickLand {

    public static int solution(int[][] land) {
        for(int i = 1; i < land.length; i++) {
            land[i][0] += max(land[i - 1][1], land[i - 1][2], land[i - 1][3]);
            land[i][1] += max(land[i - 1][0], land[i - 1][2], land[i - 1][3]);
            land[i][2] += max(land[i - 1][1], land[i - 1][3], land[i - 1][0]);
            land[i][3] += max(land[i - 1][1], land[i - 1][2], land[i - 1][0]);

            for (int[] data : land) {
                System.out.println("Arrays.toString(data) = " + Arrays.toString(data));
            }
            System.out.println("===========\n");
        }

        int max = Integer.MIN_VALUE;
        for(int number : land[land.length - 1]) {
            max = Math.max(max, number);
        }

        return max;
    }

    private static int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }


    public static void main(String[] args) {

        int[][] land1 = {
//                {1, 2, 3, 5},
//                {5, 6, 7, 8},
//                {4, 3, 2, 1}
                {4, 3, 3, 1},
                {2, 2, 2, 1},
                {6, 6, 6, 4},
                {8, 7, 6, 5}


        };
        System.out.println(solution(new int[][]{{1, 1, 1, 1}, {2, 2, 2, 3}, {3, 3, 3, 6}, {4, 4, 4, 7}}));
        System.out.println(solution(land1));
    }
}
