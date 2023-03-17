package com.programmers.level1;

/*
 * @level1
 * @TestName: 콜라 문제
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/132267
 */
public class CokeProblem {
    static int solution(int a, int b, int n) {
        int answer = 0;
        while (n >= a) {
            int mod = n % a;
            int count = (n / a) * b;
            n = count + mod;
            System.out.println("count: " + count + ", mod: " + mod + ", n: " + n);

            answer += count;
        }
        return answer;
    }
}
