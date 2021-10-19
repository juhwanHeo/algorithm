package com.coding.level2;

/*
 * @level2
 * @TestName: 가장 큰 정사각형
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12905
 */
public class BigSquare {

    static int[][] dp;
    public static int solution(int[][] board) {
        int answer = 0;
        dp = new int[board.length + 1][board[0].length + 1];

        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[0].length; k++) {
                dp[i + 1][k + 1] = board[i][k];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int k = 1; k < dp[0].length; k++) {
                if(dp[i][k] == 1) {
                    int left = dp[i - 1][k];
                    int up = dp[i][k - 1];
                    int leftUp = dp[i -1][k -1];
                    int min = Math.min(left, Math.min(up, leftUp));

                    dp[i][k] = min + 1;
                    answer = Math.max(answer, dp[i][k]);
                }
            }
        }

        return (int) Math.pow(answer, 2);
    }


    public static void main(String[] args) {
        int[][] board = {
                {0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0} // 9
        };

        System.out.println(solution(board));
    }
}
