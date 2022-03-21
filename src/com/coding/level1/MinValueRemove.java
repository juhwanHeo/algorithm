package com.coding.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @level1
 * @TestName: 제일 작은 수 제거하기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12935
 */
public class MinValueRemove {

    public static int[] solution(int[] arr) {
        int[] answer = { -1 };
        if (arr.length == 1) return answer;

        List<Integer> list = new ArrayList<>();

        for (int i : arr) list.add(i);

        Integer min = list.stream()
                .mapToInt(Integer::intValue)
                .min().orElse(Integer.MAX_VALUE);

        list.remove(min);
        if (!list.isEmpty())
            answer = list.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();

        return answer;
    }

    public static void main(String[] args) {

        int[] arr = {
                4,3,2,1
                // 4, 3, 2
        };
        System.out.println("solution(n1) = " + Arrays.toString(solution(arr)));
    }
}
