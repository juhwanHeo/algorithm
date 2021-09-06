package com.coding.level3;

import java.util.*;

/*
 * @level3
 * @TestName: 하오이의 탑
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12946
 */
public class HanoiTop {
    static int[][] solution(int n) {
        List<List<Integer>> list = new ArrayList<>();

        hanoi(list, n, 1, 2, 3);

        System.out.println(list);


        return list.stream()
                .map(lst -> lst.stream()
                        .mapToInt(Integer::intValue)
                        .toArray())
                .toArray(int[][]::new);
    }

    static void hanoi(List<List<Integer>> list,int n, int start, int mid, int to) {

        Integer[] arr = {start, to};
        if (n == 1) {
            list.add(Arrays.asList(arr));
            return;
        }

        hanoi(list, n - 1, start, to, mid);

        list.add(Arrays.asList(arr));

        hanoi(list, n - 1, mid, start, to);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(2)));
    }
}
