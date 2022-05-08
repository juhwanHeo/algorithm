package com.programmers.level1;

/*
 * @level1
 * @TestName: 약수의 합
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12928
 */
public class DivisorSum {
    static int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) answer += i;
        }

        answer += n;
        return answer;
    }

    public static void main(String[] args) {
        int n1 = 12;
        System.out.println(solution(n1)); // 28
    }
}
