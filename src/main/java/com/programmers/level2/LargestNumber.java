package com.programmers.level2;

import java.util.PriorityQueue;

/*
 * @level2
 * @TestName: 가장 큰 수
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/42746
 */
public class LargestNumber {
    static String solution(int[] numbers) {
        PriorityQueue<String> pq = new PriorityQueue<>(
                (s1, s2) -> Integer.parseInt(s2 + s1) - Integer.parseInt(s1 + s2)
        );
        StringBuilder sb = new StringBuilder();

        for (int num : numbers) pq.offer(String.valueOf(num));
        while (!pq.isEmpty()) sb.append(pq.poll());

        if (sb.toString().charAt(0) == '0')
            return "0";
        else return sb.toString();
    }


    public static void main(String[] args) {
        int[] nums1 = {3, 30, 34, 5, 9};
        System.out.println(solution(nums1));
    }
}
