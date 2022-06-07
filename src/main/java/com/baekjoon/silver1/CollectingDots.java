package com.baekjoon.silver1;

import com.coding.utils.PrintUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * @Silver1
 * @TestName: 점 모으기
 * @URL: https://www.acmicpc.net/problem/7571
 */
public class CollectingDots {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int[] xArr = new int[M];
        int[] yArr = new int[M];
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine(), " ");

            xArr[i] = Integer.parseInt(stk.nextToken());
            yArr[i] = Integer.parseInt(stk.nextToken());
        }


        Arrays.sort(xArr);
        Arrays.sort(yArr);

        int xMid = xArr[M / 2];
        int yMid = yArr[M / 2];
        int answer = 0;

        PrintUtils.printArray1(xArr);
        PrintUtils.printArray1(yArr);
        for (int i = 0; i < M; i++) {
            answer += Math.abs(xMid - xArr[i]) + Math.abs(yMid - yArr[i]);
            System.out.println(answer);
        }
    }
}

