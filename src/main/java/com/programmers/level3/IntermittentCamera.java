package com.programmers.level3;

import java.util.Arrays;
import java.util.Comparator;

/*
 * @level3
 * @TestName: 단속카메라
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/42884
 */
public class IntermittentCamera {

    public static int solution(int[][] routes) {
        int answer = 1;
        int maxValue = 30_000;
        Arrays.sort(routes, Comparator.comparingInt(a -> a[0]));

        for (int[] route : routes) System.out.println(Arrays.toString(route));

        for (int[] route : routes) {
            int start = route[0];
            int end = route[1];
            System.out.println(start + " ~ " + end + ", " + maxValue);
            if (start > maxValue) {
                answer += 1;
                maxValue = end;
            }
            maxValue = Math.min(maxValue, end);
        }

        return answer;
    }
}
