package com.baekjoon.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * @bronze1
 * @TestName: 더하기 사이클
 * @URL: https://www.acmicpc.net/problem/1110
 */
public class PlusCycle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int copy = N;

        while (true) {
            // 원본 오른쪽 수 + 합의 오른쪽 수
            int right = (N % 10) * 10;
            int sumRight = ((N / 10) + (N % 10)) % 10;
            N = right + sumRight;

            cnt++;

            if (copy == N) {
                break;
            }
        }

        System.out.println(cnt);
    }
}
