package com.programmers.kakao2017.preliminary;

import com.coding.utils.PrintUtils;

/*
 * @2017 카카오코드 예선
 * @TestName: 보행자 천국
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/1832
 */
public class PedestrianParadise {

    static int MOD = 20170805;
    public static int solution(int m, int n, int[][] cityMap) {
        // dp[][][0] 아래
        // dp[][][1] 오른쪽
        int[][][] dp = new int[m + 1][n + 1][2];

        dp[1][1][0] = dp[1][1][1] = 1;

        for (int row = 1; row <= m; row++) {
            for (int col = 1; col <= n; col++) {
                // pass
                if (cityMap[row - 1][col - 1] == 0){
                    System.out.println("Pass");
                    dp[row][col][0] += (dp[row - 1][col][0] + dp[row][col - 1][1]) % MOD;
                    dp[row][col][1] += (dp[row - 1][col][0] + dp[row][col - 1][1]) % MOD;
                }
                // 자동차 통행 금지
                else if (cityMap[row - 1][col - 1] == 1) {
                    System.out.println("No Pass");
                    dp[row][col][0] = 0;
                    dp[row][col][1] = 0;
                }
                // 좌, 우회전 금지
                else {
                    System.out.println("No Turn");
                    dp[row][col][0] = dp[row - 1][col][0];
                    dp[row][col][1] = dp[row][col - 1][1];
                }

                PrintUtils.printArray(dp);
            }
        }

        return dp[m][n][0];
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int n2 = 6;
        int[][] cityMap = {
                // 6
//                {0, 0, 0},
//                {0, 0, 0},
//                {0, 0, 0}
                // 2

                {0, 2, 0, 0, 0, 2},
                {0, 0, 2, 0, 1, 0},
                {1, 0, 0, 2, 2, 0}

        };

//        System.out.println(solution(m, n, cityMap));
        System.out.println(solution(m, n2, cityMap));

    }
}