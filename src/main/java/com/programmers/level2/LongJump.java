package com.programmers.level2;

import java.util.Arrays;

/*
 * @level2
 * @TestName: 멀리 뛰기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12914
 */
public class LongJump {

    static boolean[] visited;
    static long answer;
    public static long solution(int n) {
        if (n == 1 || n == 2) return n;
        answer = 0;
        visited = new boolean[n + 1];
//        dfs(0, n, 1);

        long[] dp = new long[n + 1];
        dp[1] = 1L;
        dp[2] = 2L;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        return dp[n];
    }

    /* 시간 초과*/
    static void dfs(int depth, int n, int r) {
        if (n <= r) {
//            System.out.println(n + ", " + r);
            answer++;
            return;
        }

        dfs(depth + 1, n, r + 1);
        dfs(depth + 1, n, r + 2);
    }
}
