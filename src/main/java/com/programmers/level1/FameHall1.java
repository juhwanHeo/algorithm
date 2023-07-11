package com.programmers.level1;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @level1
 * @TestName: 명예의 전당 (1)
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12931
 */
public class FameHall1 {
    static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        Queue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < score.length; i++) {
            if (pq.size() == k) {
                if (score[i] > pq.peek()) {
                    pq.poll();
                    pq.offer(score[i]);
                }
            }
            else {
                pq.offer(score[i]);
            }

            if (!pq.isEmpty()) answer[i] = pq.peek();
        }

        return answer;
    }
}
