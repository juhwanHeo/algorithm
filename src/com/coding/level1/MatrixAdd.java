package com.coding.level1;

import java.util.Arrays;

/*
 * @level1
 * @TestName: 행렬의 덧셈
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12950
 */
public class MatrixAdd {
    static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];

        for (int i = 0; i < answer.length; i++) {
            for (int k = 0; k < answer[0].length; k++) {
                answer[i][k] = arr1[i][k] + arr2[i][k];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] arr11 = {
                {1, 2}
                ,{2, 3}
        };
        int[][] arr21 = {
                {3, 4}
                ,{5, 6}
        };
//        System.out.println(solution(n1)); // 8
//        System.out.println(solution(16)); // 8
        System.out.println(Arrays.deepToString(solution(arr11, arr21))); // 8
    }
}
