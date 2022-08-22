package com.programmers.kakao2022.insternship;

import com.coding.utils.PrintUtils;

import java.util.Arrays;

/*
 * @2022 KAKAO Tech Internship
 * @TestName: 코딩 테스트 공부
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/118668
 * @COMMENT: DP, [4, 7, 8, 10] 정확성 실패 반례 필요
 */
public class CodingTestStudy {
    private static final int MAX_VALUE = 1_000_000_000;
    private static final int MAX_SIZE = 100;
    private static int maxAlp, maxCop;

    public static int solution(int alp, int cop, int[][] problems) {
        maxAlp = Integer.MIN_VALUE;
        maxCop = Integer.MIN_VALUE;
        updateMaxAlpCop(problems);

        System.out.println("maxAlp = " + maxAlp);
        System.out.println("maxCop = " + maxCop);

        int[][] dp = new int[MAX_SIZE][MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++) Arrays.fill(dp[i], MAX_VALUE);
        dp[alp][cop] = 0;
        for (int i = alp; i <= maxAlp; i++) {
            for (int k = cop; k <= maxCop; k++) {
                // alp
                dp[i + 1][k] = Math.min(dp[i + 1][k], dp[i][k] + 1);

                // cop
                dp[i][k + 1] = Math.min(dp[i][k + 1], dp[i][k] + 1);

                // problems
                for (int[] problem : problems) {
                    int alpReq = problem[0];
                    int copReq = problem[1];
                    int alpRwd = problem[2];
                    int copRwd = problem[3];
                    int cost = problem[4];

                    if (i >= alpReq && k >= copReq) {
                        dp[i + alpRwd][k + copRwd] = Math.min(dp[i + alpRwd][k + copRwd], dp[i][k] + cost);
                    }
                }
            }
        }

        System.out.println(dp[maxAlp][maxCop]);
        PrintUtils.printArray2(dp);

        return dp[maxAlp][maxCop];
    }

    private static void updateMaxAlpCop(int[][] problems) {
        for (int[] problem : problems) {
            int alpReq = problem[0];
            int copReq = problem[1];
            maxAlp = Math.max(maxAlp, alpReq);
            maxCop = Math.max(maxCop, copReq);
        }
    }
}
