package com.baekjoon.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * @Silver4
 * @TestName: 소수 찾기
 * @URL: https://www.acmicpc.net/problem/1978
 */
public class FindPrime {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        int count = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(stk.nextToken());
            if (isPrime(num)) count ++;
        }

        System.out.println(count);

    }

    private static boolean isPrime(int val) {
        if (val < 2) return false;
        if (val == 2) return true;

        for (int i = 3; i <= Math.sqrt(val); i++) {
            if (val % i == 0) return false;
        }
        return true;
    }
}

