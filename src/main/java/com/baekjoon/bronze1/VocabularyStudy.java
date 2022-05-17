package com.baekjoon.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
 * @bronze1
 * @TestName: 단어 공부
 * @URL: https://www.acmicpc.net/problem/1157
 */
public class VocabularyStudy {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        Map<String, Integer> map = new HashMap<>();

        for (String ch : word.split("")) {
            String key = ch.toUpperCase();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        System.out.println(map);

        String maxKey = "";
        int maxCount = Integer.MIN_VALUE;
        boolean isOk = true;
        for (String key : map.keySet()) {
            int cnt = map.get(key);

            if (cnt > maxCount) {
                maxCount = cnt;
                maxKey = key;
                isOk = true;
            }
            else if (cnt == maxCount) isOk = false;

        }

        System.out.println("maxKey = " + maxKey);
        System.out.println("maxCount = " + maxCount);
        if (isOk) System.out.println(maxKey);
        else System.out.println("?");
    }
}
