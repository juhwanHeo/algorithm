package com.coding.kakao2022.blind;

import java.util.Arrays;

/*
 * @2022 KAKAO BLIND RECRUITMENT
 * @TestName: 파괴되지 않은 건물
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/92344
 * @COMMENT: 누적합
 */
public class Undestroyed {
    static int[][] sum;
    static int N, M;

    public static int solution(int[][] board, int[][] skill) {
        N = board.length;
        M = board[0].length;

        sum = new int[N + 1][M + 1];
        for (int[] s : skill) {
            int y1 = s[1], x1 = s[2];
            int y2 = s[3], x2 = s[4];
            int degree = s[5] * (s[0] == 1 ? -1 : 1);

            sum[y1][x1] += degree;
            sum[y1][x2 + 1] += (degree * -1);
            sum[y2 + 1][x1] += (degree * -1);
            sum[y2 + 1][x2 + 1] += degree;

//            sum[y1][x1] += degree;
//            sum[y1][x2] += (degree * -1);
//            sum[y2][x1] += (degree * -1);
//            sum[y2][x2] += degree;

            for (int[] arr : sum) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println();
        }
        System.out.println("before");
        for (int[] arr : sum) {
            System.out.println(Arrays.toString(arr));
        }
        operate();

        System.out.println("\nafter");
        for (int[] arr : sum) {
            System.out.println(Arrays.toString(arr));
        }



        // 살아남은 건물 확인
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] + sum[i][j] > 0) answer++;
            }
        }
        return answer;
    }

    // 누적합 계산
    private static void operate() {
        // 상하
        System.out.println("N = " + N);
        for (int y = 1; y < N; y++) {
            System.out.println("y: " + y+ " \n ");
            for (int x = 0; x < M; x++) {
                sum[y][x] += sum[y - 1][x];
            }

            for (int[] arr : sum) {
                System.out.println(Arrays.toString(arr));
            }
        }
        // 좌우
        for (int x = 1; x < M; x++) {
            for (int y = 0; y < N; y++) {
                sum[y][x] += sum[y][x - 1];
            }
        }
    }

    public static void main(String[] args) {
        int[][] board = {
                {5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}
        };
        int[][] skill = {
                {1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}
        };
        System.out.println(solution(board, skill));
    }

}
