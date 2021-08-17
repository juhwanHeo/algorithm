package com.coding.level2;

import java.util.*;
import java.util.stream.Collectors;

/*
 * @level2
 * @TestName: 더 맵게
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/42626
 */
public class Spicier {
    static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = Arrays.stream(scoville)
                .boxed()
                .collect(Collectors.toCollection(PriorityQueue::new));

        if(queue.size() == 1) return -1;
        while(queue.stream().anyMatch(val -> val < K)) {
            if(queue.peek() >= K) break;
//            int val1 = queue.poll();
//            int val2 = queue.poll();
            int val1 = queue.peek() != null ? queue.poll() : -2;
            int val2 = queue.peek() != null ? queue.poll() : -2;
            int res = val1 + val2 * 2;
            queue.offer(res);
            answer++;

        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 9, 10, 12};
        int k = 7;
        System.out.println(solution(nums, k));
    }
}

