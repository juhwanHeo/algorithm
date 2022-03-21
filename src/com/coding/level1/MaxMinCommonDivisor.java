package com.coding.level1;

import java.util.Arrays;

/*
 * @level1
 * @TestName: 최대공약수 와 최소공배수
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12940
 */
public class MaxMinCommonDivisor {

    public static int[] solution(int n, int m) {
        int[] answer = new int[2];
        int max = Math.max(n, m);
        int min = Math.min(n, m);
        int gcd = gcd(max, min);

        answer[0] = gcd;
        answer[1] = max * min / gcd;
        return answer;
    }

    private static int gcd(int big, int small) {
        return (big % small == 0) ? small : gcd(small, big % small);
    }

    static int GCD(int a, int b){ // 최대 공약수
        if (a % b == 0) {
            return b;
        }
        return GCD(b, a % b);
    }

    public static void main(String[] args) {

        System.out.println("solution() = " + Arrays.toString(solution(3, 12)));
        System.out.println("solution() = " + Arrays.toString(solution(2, 5)));
    }
}
