package com.baekjoon.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/*
 * @silver5
 * @TestName: 단어 정렬
 * @URL: https://www.acmicpc.net/problem/1181
 */
public class WordSoring {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();

        int cnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cnt; i++)  {
            String word = br.readLine();
            if (!list.contains(word)) list.add(word);
        }

        list.sort((str1, str2) -> {
            if (str1.length() != str2.length()) return Integer.compare(str1.length(), str2.length());
            return str1.compareTo(str2);
        });


        for (String s : list) System.out.println(s);
    }
}
