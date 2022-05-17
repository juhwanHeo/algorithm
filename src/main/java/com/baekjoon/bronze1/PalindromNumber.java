package com.baekjoon.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @bronze1
 * @TestName: 팰린드롬 수
 * @URL: https://www.acmicpc.net/problem/1259
 */
public class PalindromNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        while (true) {
            String number = br.readLine();
            if (number.equals("0")) break;
            list.add(number);
        }

        StringBuilder sb = new StringBuilder();
        list.stream()
                .map(PalindromNumber::isOk)
                .collect(Collectors.toList())
                .forEach(str -> sb.append(str).append("\n"));


        System.out.println(sb);
    }

    private static String isOk(String number) {
        if (number.length() == 1) return "yes";
        for (int i = 0; i < number.length() / 2 + 1; i++) {
            if (number.charAt(i) != number.charAt(number.length() - 1 - i)) return "no";
        }

        return "yes";
    }
}
