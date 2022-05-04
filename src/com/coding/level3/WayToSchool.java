package com.coding.level3;

import com.coding.utils.PrintUtils;

/*
 * @level3
 * @TestName: 등굣길
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/42898
 */
public class WayToSchool {

    static int MOD = 1000000007;
    public static int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];
        int[][] way = new int[n + 1][m + 1];

        for (int[] puddle : puddles) way[puddle[1] - 1][puddle[0] - 1] = 1;

        PrintUtils.printArray2(way);

        dp[1][1] = 1;
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= m; col++) {
                // 통행 금지
                if (way[row - 1][col - 1] == 1) {
                    System.out.println("No Pass");
                    dp[row][col] = 0;
                }
                else {
                    System.out.println("Pass");
                    dp[row][col] += (dp[row - 1][col] + dp[row][col - 1]) % MOD;
                }
                PrintUtils.printArray2(dp);
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {
                {1, 2} // 4

        };

        System.out.println(solution(m, n, puddles));

    }
}