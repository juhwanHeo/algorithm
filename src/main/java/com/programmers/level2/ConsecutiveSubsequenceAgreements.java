package com.programmers.level2;

import java.util.*;

/*
 * @level2
 * @TestName: 연속 부분 수열 합의 개수

 * @URL: https://programmers.co.kr/learn/courses/30/lessons/131701
 */
public class ConsecutiveSubsequenceAgreements {

    static int[] array;
    static Set<Integer> set;
    public static int solution(int[] elements) {
        set = new HashSet<>();
        array = new int[elements.length * 2];

        for (int i = 0; i < elements.length; i++) {
            array[i] = elements[i];
            array[i + elements.length] = elements[i];
        }

        for (int i = 1; i <= elements.length; i++) dfs(array, i, 0);

        System.out.println("size: " + elements.length);
        System.out.println(Arrays.toString(array));
        System.out.println(set.size());
        System.out.println(set);
        return set.size();
    }

    static void dfs(int[] elements, int limit, int depth) {
        if (elements.length <= depth) return;

        int sum = 0, count = 0;
        for (int i = depth; i < elements.length; i++) {
            if (limit == count++) {
                set.add(sum);
                break;
            }
            sum += elements[i];
        }

        dfs(elements, limit, depth + 1);
    }
}
