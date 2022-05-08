package com.programmers.level2;

import java.util.Arrays;

/*
 * @level2
 * @TestName: 행렬의 곱셈
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12949
 */
public class MatrixMultiplication {

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int row = 0; row < answer.length; row++) {
            for (int col = 0; col < answer[0].length; col++) {
                for (int i = 0; i < arr2.length; i++) {
                    answer[row][col] += arr1[row][i] * arr2[i][col];
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // 3 X 2
        int[][] arr1 = {
                {1, 4},
                {3, 2},
                {4, 1}
        };

        // 2 X 2
        int[][] arr2 = {
                {3, 3},
                {3, 3}
        };
        
        // (3 X 2) * (2 * 2)
        System.out.println(Arrays.deepToString(solution(arr1, arr2)));
    }

}
