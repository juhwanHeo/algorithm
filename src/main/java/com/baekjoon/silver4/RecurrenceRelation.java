package com.baekjoon.silver4;

import com.coding.utils.PrintUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * @Silver4
 * @TestName: 점화식
 * @URL: https://www.acmicpc.net/problem/13699
 */
public class RecurrenceRelation {

    /*
     *
     *
     * t(0)=1
     * t(n)=t(0) * t(n-1)+t(1) * t(n-2)+...+t(n-1) * t(0)
     * 이 정의에 따르면,
     * t(1)=t(0)*t(0)=1
     * t(2)=t(0)*t(1) + t(1)*t(0)=2
     * t(3)=t(0)*t(2) + t(1)*t(1) + t(2)*t(0)=5
     * t(4)=t(0)*t(3) + t(1)*t(2) + t(1)*t(1) + t(2)*t(0) = 14
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n + 1];

        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        System.out.println(dp[n]);
        PrintUtils.printArray(dp);
    }
}

