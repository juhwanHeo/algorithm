package com.baekjoon.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * @Silver4
 * @TestName: 베스트 셀러
 * @URL: https://www.acmicpc.net/problem/1302
 */
public class BestSeller {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String title = br.readLine();;
            map.put(title, map.getOrDefault(title, 0 ) + 1);
        }

        int maxCnt = Integer.MIN_VALUE;
        for (String key : map.keySet()) {
            int cnt = map.get(key);

            if (cnt == maxCnt) list.add(key);
            else if (cnt > maxCnt) {
                list = new ArrayList<>();
                maxCnt = cnt;
                list.add(key);
            }
        }

        Collections.sort(list);
        System.out.println("map = " + map);
        System.out.println("list = " + list);
        System.out.println(list.get(0));
    }
}

