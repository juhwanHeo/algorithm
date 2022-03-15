package com.coding.level2;

import java.util.*;

/*
 * @level2
 * @TestName: n^2 배열 자르기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/87390
 */
public class ArrayCutTwo {

    /*
     * 1 2 3
     * 2 2 3
     * 3 3 3
     * 3, 2, 2, 3
     * 행, 열 의 최대값
     */
    public static int[] solution(int n, long left, long right) {
        List<Long> list = new ArrayList<>();
        for (long i = left; i < right + 1; i++) {
            // '/' 행
            // '%' 열
            list.add(Math.max(i / n , i % n) + 1);
            System.out.println("/ " + i / n);
            System.out.println("% " + i % n + "\n");
        }

        return list.stream()
                .mapToInt(Long::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        int n1 = 3;
        int left1 = 2;
        int right1 = 5;

        // 3, 2, 2, 3
        System.out.println(Arrays.toString(solution(n1, left1, right1)));

    }
}
