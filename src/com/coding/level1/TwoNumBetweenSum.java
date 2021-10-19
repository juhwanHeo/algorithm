package com.coding.level1;

/*
 * @level1
 * @TestName: 두 정수 사이의 합
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12912
 */
public class TwoNumBetweenSum {
    public static long solution(int a, int b) {
        long answer = 0;

        for (int i = Math.min(a, b); i <= Math.max(a,b); i++) {
            answer += i;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, 5));
    }
}
