package com.baekjoon.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * @bronze2
 * @TestName: 줄 세우기
 * @URL: https://www.acmicpc.net/problem/2605
 */
public class LineUp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int index = Integer.parseInt(stk.nextToken());
            list.add(index, i + 1);
        }

        Collections.reverse(list);

        StringBuilder sb = new StringBuilder();
        list.forEach(index -> sb.append(index).append(' '));
        System.out.println(sb);

    }
}
