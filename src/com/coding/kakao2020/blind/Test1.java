package com.coding.kakao2020.blind;

import java.util.*;

/*
 * @2020 kakao blind
 * @TestName: 문자열 압축
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/60057
 */
public class Test1 {
    public static int solution(String s) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i <= s.length() / 2; i++) {
            answer.add(compression(s, i));
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .min()
                .orElse(Integer.MAX_VALUE);
    }

    private static int compression(String str, int depth) {
        if (depth == 0) return str.length();
        int cnt = 1;
        String s = str + " ";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= s.length() - depth; i += depth) {
            int index = i + depth;
            if (index + depth > s.length()) {
                String rest = s.substring(i, s.length() - 1);
                if (sb.toString().equals(rest)) cnt++;
                if (cnt > 1) sb.append(cnt);
                sb.append(rest);
                break;
            }
            if(s.substring(i, index).equals(s.substring(index, index + depth))) cnt++;
            else {
                if (cnt > 1) sb.append(cnt);
                sb.append(s, i, index);
                cnt = 1;
            }
        }

        return sb.toString()
                .trim()
                .length();
    }


    public static void main(String[] args) {
//        String s1 = "aabbaccc";
//        int res1 = 7;
//        System.out.println("myRes1: " + solution(s1));

        String s2 = "ababcdcdababcdcd";
        int res2 = 9;
        System.out.println("myRes2: " + solution(s2));

//        String s3 = "abcabcdede";
//        int res3 = 8;
//        System.out.println("myRes3: " + solution(s3));
    }
}

