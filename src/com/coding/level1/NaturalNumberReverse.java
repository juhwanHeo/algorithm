package com.coding.level1;

import java.util.*;
import java.util.stream.Collectors;

/*
 * @level1
 * @TestName: 자연수 뒤집어 배열로 만들기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12932
 */
public class NaturalNumberReverse {

    public static int[] solution(long n) {
        List<String> list = Arrays.stream(String.valueOf(n).split(""))
                .collect(Collectors.toList());
        Collections.reverse(list);

        return list.stream()
                .mapToInt(Integer::parseInt)
                .toArray();

    }

    public static void main(String[] args) {
        long n1 = 12345;

        System.out.println("solution(n1) = " + Arrays.toString(solution(n1)));
    }
}
