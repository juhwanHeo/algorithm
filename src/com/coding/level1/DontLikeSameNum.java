package com.coding.level1;

import java.util.*;

/*
 * @level1
 * @TestName: 같은 숫자는 싫어
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12906
 */
public class DontLikeSameNum {
    static int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> answer = new ArrayList<>();

        for (int num : arr) {
            if (!stack.isEmpty() && stack.peek() == num) continue;
            stack.push(num);
            answer.add(num);
        }

        return answer.stream()
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    public static void main(String[] args) {
        int[] arr = {
                1,1,3,3,0,1,1
        };

        System.out.println(Arrays.toString(solution(arr)));
    }
}
