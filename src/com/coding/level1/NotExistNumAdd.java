package com.coding.level1;

import java.util.Arrays;

/*
 * @level1
 * @TestName: 없는 숫자 더하기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/86051
 */
public class NotExistNumAdd {
    static int solution(int[] numbers) {
        return 45 - (int) Arrays.stream(numbers)
                .mapToLong(Long::valueOf)
                .sum();
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,6,7,8,0};
        int res = 14;
        System.out.println(solution(arr1));
    }
}
