package com.coding.level2;

import java.util.*;

/*
 * @level2
 * @TestName: 최솟값 만들기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12941
 */
public class MakeMinValue {

    public static int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[B.length - i - 1];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] A1 = {
                1,4,2
        };
        int[] B1 = {
                5,4,4
        };

        System.out.println(solution(A1, B1));

    }
}
