package com.baekjoon.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * @bronze1
 * @TestName: 수 정렬하기
 * @URL: https://www.acmicpc.net/problem/2750
 */
public class NumberSorting {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];

        for (int i = 0; i < N; i++) array[i] = Integer.parseInt(br.readLine());

        Arrays.sort(array);
        for (int j : array) sb.append(j).append("\n");
//        for (int i = 0; i < array.length; i++) sb.append(array[i]).append("\n");

        System.out.println(sb);
    }
}
