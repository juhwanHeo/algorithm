package com.baekjoon.bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * @bronze3
 * @TestName: 시그마
 * @URL: https://www.acmicpc.net/problem/2355
 */
public class Sigma {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        long A = Integer.parseInt(stk.nextToken());
        long B = Integer.parseInt(stk.nextToken());

        long max = Math.max(A, B);
        long min = Math.min(A, B);

        long sum = (((max + 1) * max) / 2) - (((min - 1) * min) / 2);

        System.out.println(sum);
    }
}
