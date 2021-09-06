package com.coding.level3;

import java.util.*;

/*
 * @level3
 * @TestName: 입국심사
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/43238
 */
public class Immigration {
    static long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = 0;
        long left = 0;
        long right = (long) n * times[times.length - 1];

        while(left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (int time : times) sum += mid / time;

            if (sum < n) left = mid + 1;
            else {
                right = mid - 1;
                answer = mid;
            }
        }

        return answer;
    }



    public static void main(String[] args) {
        int n1 = 6;
        int[] times1 = {7, 10};
        System.out.println(solution(n1, times1));
    }
}
