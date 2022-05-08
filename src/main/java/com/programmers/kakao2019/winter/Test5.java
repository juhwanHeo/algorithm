package com.programmers.kakao2019.winter;

import java.util.Arrays;

/*
 * @2019 kakao winter internship
 * @TestName: 징검다리 건너기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/64062
 * @COMMENT: 정확성은 해결 했지만 효율성 해결이 안되서
 *           https://bcp0109.tistory.com/189?category=885291 참고
 *           https://www.crocus.co.kr/1000 공부하기
 */
public class Test5 {
    static int solution(int[] stones, int k) {
        int answer = 0;
        while (isOk(stones, k)) {
            stones = Arrays.stream(stones)
                    .map(m -> m = m - 1)
                    .toArray();
            // 연산 줄이기
            // .map(m -> m = (m - 1 >= 0) ? m-1 : m)
            answer++;
        }

        return answer;
    }
    static boolean isOk(int[] stones, int limit) {
        int zero = 0;
        for (int arr : stones) {
            if (zero == limit) return false;
            if (arr <= 0) zero++;
            else zero = 0;
            if (zero == limit) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] stones1 = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k1 = 3;
        int answer1 = 3;
        int myRes1 = solution(stones1, k1);
        System.out.println("answer1: " + answer1);
        System.out.println("myRes1: " + myRes1);

    }
}

