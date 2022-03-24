package com.coding.level2;

import java.util.Arrays;

/*
 * @level2
 * @TestName: 최댓값과 최솟값
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12939
 */
public class MaxAndMin {

    public static String solution(String s) {
        int[] split = Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        return split[0] + " " + split[split.length - 1];
    }


    public static void main(String[] args) {

//        System.out.println(solution("()()"));
        System.out.println(solution("1 2 3 4"));
    }
}
