package com.programmers.level1;

/*
 * @level1
 * @TestName: 소수 찾기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12921
 */
public class FindPrime {
    static int solution(int n) {
        int answer = 0;

        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) answer++;
        }

        return answer;
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
//        for (int i = 2; i <= Math.sqrt(n); i++) {
//            if (n % i == 0) return false;
//        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("solution(10) = " + solution(10)); // 4
    }
}
