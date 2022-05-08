package com.programmers.level1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @level1
 * @TestName: 체육복
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/42862
 */
public class WorkoutClothes {
    static int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n];
        Arrays.fill(students, 1);
        List<Integer> list = Arrays.stream(students)
                .boxed()
                .collect(Collectors.toList());

        for (int i : lost) list.set(i-1, 0);
        for (int i : reserve) list.set(i-1, list.get(i-1) + 1);

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) != 0) continue;
            int before = i - 1;
            int after = i + 1;
            if(before >= 0 && list.get(before) > 1) {
                list.set(i, 1);
                list.set(before, list.get(before) - 1);
                continue;
            }
            if(after < list.size() && list.get(after) > 1) {
                list.set(i, 1);
                list.set(after, list.get(after) -1);
            }
        }

        return (int) list.stream()
                .filter(val -> val > 0)
                .mapToInt(Integer::valueOf)
                .count();
    }

    public static void main(String[] args) {
        int n1 = 5;

        int[] lost1 = {2, 4};
        int[] reserve1 = {1, 3, 5};
        int res1 = 5;
        System.out.println(solution(n1, lost1, reserve1));
    }
}
