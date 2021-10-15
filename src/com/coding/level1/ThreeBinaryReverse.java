package com.coding.level1;

/*
 * @level1
 * @TestName: 3진법 뒤집기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/68935
 */
public class ThreeBinaryReverse {
    static int solution(int n) {
        return Integer.parseInt(new StringBuilder(Integer.toUnsignedString(n, 3)).reverse().toString(), 3);
    }

    public static void main(String[] args) {
        int n = 45;
        System.out.println(solution(n));
    }
}
