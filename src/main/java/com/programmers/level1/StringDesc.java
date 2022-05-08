package com.programmers.level1;

import java.util.Arrays;
import java.util.Comparator;

/*
 * @level1
 * @TestName: 문자열 내림차순으로 배치하기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12917
 */
public class StringDesc {
    static String solution(String s) {

        return String.join("", Arrays.stream(s.split(""))
                .sorted(Comparator.reverseOrder())
                .toArray(String[]::new));
    }

    public static void main(String[] args) {
        System.out.println("solution(\"Zbcdefg\") = " + solution("Zbcdefg"));
    }
}
