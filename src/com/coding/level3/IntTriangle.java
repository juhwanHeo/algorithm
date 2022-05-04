package com.coding.level3;

import com.coding.utils.PrintUtils;

/*
 * @level3
 * @TestName: 정수 삼각형
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/43105
 */
public class IntTriangle {

    public static int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];

        dp[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            for (int k = 0; k < triangle[i].length; k++) {
                if (k == 0) {
                    dp[i][k] = dp[i - 1][0] + triangle[i][k];
                }
                else if (k == triangle[i].length - 1) {
                    dp[i][k] = dp[i - 1][k - 1] + triangle[i][k];
                }
                else {
                    dp[i][k] = Math.max(dp[i - 1][k - 1], dp[i - 1][k]) + triangle[i][k];
                }

                PrintUtils.printArray2(dp);
            }
        }

        for (int i = 0; i < triangle.length; i++) {
            answer = Math.max(answer, dp[triangle.length - 1][i]);
        }

        return answer;
    }


    public static void main(String[] args) {
        int[][] triangle = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };

        System.out.println(solution(triangle));

    }
}