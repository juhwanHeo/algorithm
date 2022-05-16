package com.baekjoon.silver5;

import com.coding.utils.PrintUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * @Silver5
 * @TestName: 파스칼 삼각형
 * @URL: https://www.acmicpc.net/problem/15489
 */
public class PascalTriangle {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int R = Integer.parseInt(split[0]);
        int C = Integer.parseInt(split[1]);
        int W = Integer.parseInt(split[2]);

        int height = R + W - 1;
        int[][] dp = new int[height][height];

        dp[0][0] = 1;
        for (int i = 1; i < height; i++) dp[i][0] = dp[i][i] = 1;
        for (int i = 2; i < height; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1]  +  dp[i - 1][j];
            }
        }

        int sum = 0;
        int endCol = C;
        for (int i = R - 1; i < height; i++) {
            for (int j = C - 1; j < endCol; j++) {
                sum += dp[i][j];
            }
            endCol++;
        }


        PrintUtils.printArray2(dp);
        System.out.println(sum);

    }
}
