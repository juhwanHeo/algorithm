package com.programmers.kakao2022.insternship;

import java.util.LinkedList;
import java.util.Queue;

/*
 * @2022 KAKAO Tech Internship
 * @TestName: 두 큐 합 같게 만들기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/118670
 * @COMMENT: Deque
 */
public class TwoQueueSameSum {
    static int MAX_VALUE = 600_000;
    public static long solution(int[] queue1, int[] queue2) {
        long answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long sum1 = 0;
        long sum2 = 0;
        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];

            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }

        while (sum1 != sum2 && answer <= MAX_VALUE) {
            int val;
            answer ++;

            if (sum1 > sum2) {
                val = q1.poll();
                q2.offer(val);

                sum1 -= val;
                sum2 += val;
            }
            else {
                val = q2.poll();
                q1.offer(val);

                sum1 += val;
                sum2 -= val;
            }

            if(sum1 - sum2 == -1) return -1;
            if (q1.isEmpty() || q2.isEmpty()) return -1;
        }
        return (answer <= MAX_VALUE) ? answer : -1;
    }

}
