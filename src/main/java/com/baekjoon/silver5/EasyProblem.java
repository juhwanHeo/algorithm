package com.baekjoon.silver5;

import com.coding.utils.PrintUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * @Silver5
 * @TestName: 쉡게 푸는 문제
 * @URL: https://www.acmicpc.net/problem/1292
 */
public class EasyProblem {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(stk.nextToken());
        int B = Integer.parseInt(stk.nextToken());

        int[] dp = new int[1000];

        int data = 1;
        int cnt = 1;
        for (int i = 0; i < dp.length; i++) {
            dp[i] = data;
            if (data == cnt) {
                data++;
                cnt = 1;
            }
            else cnt++;
        }

        int sum = 0;
        for (int i = A - 1; i < B; i++) sum += dp[i];

        System.out.println(sum);
    }
}
