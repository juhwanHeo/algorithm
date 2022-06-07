package com.baekjoon.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * @Silver5
 * @TestName: 집합
 * @URL: https://www.acmicpc.net/problem/11723
 */
public class Collection {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());


        List<String> all = new ArrayList<>();
        for (int i = 1; i <= 20; i++) all.add(String.valueOf(i));

        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

            String cmd = stk.nextToken();
            switch (cmd) {
                case "add":
                    set.add(stk.nextToken());
                    break;
                case "remove":
                    set.remove(stk.nextToken());
                    break;
                case "check":
                    if (set.contains(stk.nextToken())) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                case "toggle":
                    String x = stk.nextToken();
                    if (set.contains(x)) set.remove(x);
                    else set.add(x);
                    break;
                case "all":
                    set.addAll(all);
                    break;
                case "empty":
                    set.clear();
                    break;
            }

        }

        System.out.println(sb);
    }
}
