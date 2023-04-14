package com.programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

/*
 * @level2
 * @TestName: 요격 시스템
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/181188
 */
public class InterceptorMissile {

    public static int solution(int[][] targets) {
        int answer = 1;

        Arrays.sort(targets, Comparator.comparingInt(a -> a[1]));

        System.out.println(Arrays.deepToString(targets));

        int end = targets[0][1];
        for (int[] target : targets) {
            int nextStart = target[0];
            int nextEnd = target[1];

            System.out.println(nextStart + " ~ " + nextEnd + ", end: " + end);
            if (end <= nextStart) {

                answer++;
                end = nextEnd;
            }

        }
        return answer;
    }

}
