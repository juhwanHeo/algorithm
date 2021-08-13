package com.coding.level1;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * @level1
 * @TestName: 문자열 다루기 기본
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12918
 */
public class StringHandling01 {
    public boolean solution(String s) {
        return s.matches("^[0-9]{4}|[0-9]{6}$");
    }

    public static void main(String[] args) {
        String regex = "^[0-9]{4}|[0-9]{6}$";
        System.out.println("a234".matches(regex));
        System.out.println("1234".matches(regex));
    }
}
