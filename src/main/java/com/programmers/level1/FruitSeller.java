package com.programmers.level1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @level1
 * @TestName: 과일 장수
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/135808
 */
public class FruitSeller {
    static int solution(int k, int m, int[] score) {
        int answer = 0;

        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : score) pq.offer(i);

        int cnt = 0, min = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            int value = pq.poll();
            min = Math.min(value, min);
            cnt++;

            if (cnt == m) {
                answer += min * m;
                cnt = 0;
            }
        }


        return answer;
    }

    static int solution2(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);

        for(int i = score.length; i >= m; i -= m){
            answer += score[i - m] * m;
        }

        return answer;
    }
}
