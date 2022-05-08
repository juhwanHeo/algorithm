package com.programmers.level1;

import java.util.Arrays;

/*
 * @level1
 * @TestName: 문자열 내 마음대로 정렬하기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12915
 */
public class MyStringSort {
    static String[] solution(String[] strings, int n) {
        return Arrays.stream(strings)
                .sorted((s1, s2) -> {
                    if (s1.charAt(n) != s2.charAt(n))
                        return s1.charAt(n) - s2.charAt(n);
                    return s1.compareTo(s2);
                })
                .toArray(String[]::new);
    }

    public static void main(String[] args) {
        String[] arr = {
                "sun", "bed", "car"
        };


        System.out.println("solution(arr, 1) = " + Arrays.toString(solution(arr, 1)));
    }
}
