package com.baekjoon.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * @Silver5
 * @TestName: BABBA
 * @URL: https://www.acmicpc.net/problem/9625
 */
public class BABBA {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int a = 0, b = 1, sum = 0;

        for (int i = 1; i < N; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }

        System.out.println(a + " " + b);

    }
}
