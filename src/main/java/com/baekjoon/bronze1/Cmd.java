package com.baekjoon.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * @bronze1
 * @TestName: 명령 프롬프트
 * @URL: https://www.acmicpc.net/problem/1032
 */
public class Cmd {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(new StringBuilder(br.readLine()));

        for (int i = 0; i < list.get(0).length(); i++) {
            StringBuilder first = list.get(0);

            int index = i;
            boolean isNotOk = list.stream()
                    .anyMatch(str -> str.charAt(index) != first.charAt(index));

            if (isNotOk) {
                for (StringBuilder sb : list) {
                    sb.setCharAt(i, '?');
                }
            }
        }

        System.out.println(list.get(0));

    }
}
