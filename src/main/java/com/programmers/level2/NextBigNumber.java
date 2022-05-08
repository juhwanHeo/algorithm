package com.programmers.level2;

/*
 * @level2
 * @TestName: 다음 큰 숫자
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12911
 */
public class NextBigNumber {

    public static int solution(int n) {
        int cnt = Integer.bitCount(n);
        int val = n + 1;

        while (true) {
            int valCnt = Integer.bitCount(val);
            if (cnt == valCnt) break;

            val++;
        }
        return val;
    }


    public static void main(String[] args) {
        System.out.println(solution(78));
        System.out.println(solution(15));
    }
}
