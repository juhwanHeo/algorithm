package com.coding.level1;

import java.util.stream.IntStream;

/*
 * @level1
 * @TestName: 내적
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/70128
 */
public class ScalarProduct {
    static int solution(int[] a, int[] b) {
        // 0.06ms
//        int answer = 0;
//        for (int i = 0; i < a.length; i++) {
//                answer += a[i] * b[i];
//        }
//        return answer;
        // Stream 연습 3.0ms
        return IntStream.range(0, a.length)
                .map(index -> a[index] * b[index])
                .sum(); // 3.0ms
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int[] b = {-3,-1,0,2};
        System.out.println(solution(a, b));
    }
}
