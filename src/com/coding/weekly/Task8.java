package com.coding.weekly;

import java.util.*;

/*
 * @Weekly 8
 * @TestName: 최소직사각형
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/86491
 */
public class Task8 {

    public static int solution(int[][] sizes) {
        for (int[] size : sizes) {
            Arrays.sort(size);
        }

        int maxWidth = Arrays.stream(sizes)
                .mapToInt(arr-> arr[0])
                .max()
                .orElse(Integer.MIN_VALUE);

        int maxHeight = Arrays.stream(sizes)
                .mapToInt(arr-> arr[1])
                .max()
                .orElse(Integer.MIN_VALUE);

        return maxWidth * maxHeight;
    }

    public static void main(String[] args) {

        int[][] sizes = {
                {60, 50},
                {70, 30},
                {60, 30},
                {80, 40}
        };

        int res1 = 4000;

        System.out.println(solution(sizes));

    }
}
