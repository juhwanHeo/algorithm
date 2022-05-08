package com.programmers.level1;

import java.util.Arrays;

/*
 * @level1
 * @TestName: 나누어 떨어지는 숫자 배열
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12910
 */
public class DivideIntegerArr {
    static int[] solution(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr)
                .filter(value -> value % divisor == 0)
                .sorted()
                .toArray();

        if (answer.length > 0) return answer;
        return new int[] {-1};
    }

    public static void main(String[] args) {
        int[] arr = {
                5, 9, 7, 10
        };

        System.out.println(Arrays.toString(solution(arr, 5)));
    }
}
