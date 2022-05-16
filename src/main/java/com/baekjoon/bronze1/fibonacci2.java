package com.baekjoon.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * @bronze1
 * @TestName: 피보나치 수 2
 * @URL: https://www.acmicpc.net/problem/2748
 */
public class fibonacci2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N < 2) {
            System.out.print(N);
            return ;
        }

        long[] dp = new long[N + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        System.out.print(dp[N]);

    }
}
