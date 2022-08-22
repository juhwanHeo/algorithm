package com.programmers.level3;

import com.coding.utils.PrintUtils;

import java.util.*;

/*
 * @level3
 * @TestName: 순위
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/49191
 */
public class Rank {

    private static final int WIN = 1;
    private static final int LOSS = 2;
    private static int[][] map;

    public static int solution(int n, int[][] results) {
        int answer = 0;
        map = new int[n][n];
        for (int[] result : results) {
            map[result[0] - 1][result[1] - 1] = WIN;
            map[result[1] - 1][result[0] - 1] = LOSS;
        }

        System.out.println("before");
        PrintUtils.printArray2(map);
        for (int i = 0; i < map.length; i++) {
            update(i);
        }

        System.out.println("after");
        PrintUtils.printArray2(map);

        for (int[] row : map) {
            long zero = Arrays.stream(row)
                    .filter(data -> data == 0)
                    .count();

            if (zero == 1) answer++;
        }
        return answer;
    }

    // A를 이긴 사람들은 A에게 패배한 사람들을 무조건 이긴다
    private static void update(int node) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[node].length; j++) {
                if (map[node][j] != 0) {
                    for (int k = 0; k < map[j].length; k++) {
                        if (map[node][j] == map[j][k]) {
                            map[node][k] = map[j][k];
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        int[][] result = {
                {4, 3},
                {4, 2},
                {3, 2},
                {1, 2},
                {2, 5}
        };

        int[][] result2 = {
                {1, 4},
                {4, 2},
                {2, 5},
                {5, 3}
        };

        int[][] result3 = {
                {1,2},
                {2,3},
                {1,4}
        };

//        System.out.println(solution(5, result));
        System.out.println(solution(5, result2));
//        System.out.println(solution(4, result3));

    }
}
