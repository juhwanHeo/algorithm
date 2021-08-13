package com.coding.level1;

import java.util.*;
import java.util.stream.Collectors;

/*
 * @level1
 * @TestName: K번째수
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/42748
 */
public class NumK {
    static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        List<Integer> list = Arrays.stream(array)
                .boxed()
                .collect(Collectors.toList());

        for (int i = 0; i < commands.length; i++) {
            answer[i] = list.subList(commands[i][0]-1, commands[i][1]).stream()
                    .sorted()
                    .mapToInt(Integer::intValue)
                    .toArray()[commands[i][2]-1];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2, 5, 3}, {4, 4, 1}, {1, 7, 3}
        };
        int[] res = {5, 6, 3};

        System.out.println(Arrays.toString(solution(array, commands)));
    }
}
