package com.programmers.level1;

import java.util.Arrays;

/*
 * @level1
 * @TestName: 평균 구하기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12944
 */
public class Average {
    static double solution(int[] arr) {
        return Arrays.stream(arr)
                .average()
                .orElse(Double.MAX_VALUE);
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4};
        System.out.println(solution(arr1));
    }
}
