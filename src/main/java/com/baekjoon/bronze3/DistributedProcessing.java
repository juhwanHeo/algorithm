package com.baekjoon.bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * @bronze3
 * @TestName: 분산 처리
 * @URL: https://www.acmicpc.net/problem/1009
 */
public class DistributedProcessing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            long result = 1;

            for (int j = 0; j < b; j++) {
                result *= a;

                if (result >= 10) result %= 10;
                if (result == 0) result = 10;
            }
            sb.append(result).append('\n');

        }

        System.out.println(sb);

    }
}
