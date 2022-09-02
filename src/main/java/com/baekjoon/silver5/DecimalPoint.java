package com.baekjoon.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * @Silver5
 * @TestName: 소수
 * @URL: https://www.acmicpc.net/problem/1312
 */
public class DecimalPoint {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(stk.nextToken());
        int B = Integer.parseInt(stk.nextToken());
        int N = Integer.parseInt(stk.nextToken());

        System.out.println(getPoint(A, B, N));
    }


    public static int getPoint(int A, int B, int N) {
        int result = 0;
        for (int i = 0; i < N; i++) {
            A = (A % B) * 10;
            result = A / B;
        }

        return result;
    }
}
