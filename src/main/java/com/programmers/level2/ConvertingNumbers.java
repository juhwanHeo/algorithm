package com.programmers.level2;

import java.util.*;

/*
 * @level2
 * @TestName: 숫자 변환하기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/154538
 */
public class ConvertingNumbers {

    public static int solution(int x, int y, int n) {
        if (x == y) return 0;
        int[] dp = new int[1_000_001];
//        int[] dp = new int[51];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[x] = 0;
        for (int i = 0; i < dp.length; i++) {
            // 10
            if (dp[i] == Integer.MAX_VALUE) continue;
            // x에 n을 더합니다
            int plus = i + n;
            // x에 2를 곱합니다.
            int multiplyBy2 = i * 2;
            // x에 3을 곱합니다.
            int multiplyBy3 = i * 3;

            if (plus <= y) dp[plus] = Math.min(dp[plus], dp[i] + 1);
            if (multiplyBy2 <= y) dp[multiplyBy2] = Math.min(dp[multiplyBy2], dp[i] + 1);
            if (multiplyBy3 <= y) dp[multiplyBy3] = Math.min(dp[multiplyBy3], dp[i] + 1);
        }


//        for (int i = 1; i < dp.length; i++) {
//            System.out.print(dp[i] + " ");
//            if (i % 10 == 0) System.out.println();
//        }
//        System.out.println();
        return dp[y] == Integer.MAX_VALUE ? -1 : dp[y];
    }
}
