package com.baekjoon.gold3;

import com.coding.utils.PrintUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * @Gold3
 * @TestName: 내리막길
 * @URL: https://www.acmicpc.net/problem/1520
 */
public class DownHillRoad {
    static int row;
    static int col;
    static int[][] dp;
    static boolean[][] visited;
    static int[][] dirs = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}}; // 상하좌우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        row = Integer.parseInt(stk.nextToken());
        col = Integer.parseInt(stk.nextToken());

        int[][] maps = new int[row][col];

        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            final String[] split = line.split(" ");
            for (int j = 0; j < split.length; j++) {
                maps[i][j] = Integer.parseInt(split[j]);
            }
        }

        int result = solution(row, col, maps);
        System.out.println(result);
    }

    public static int solution(int N, int M, int[][] maps) {
        dp = new int[N][M];
        visited = new boolean[N][M]; // visited 안쓰고 Array.fill로 가능해 보임
//        for (int[] ints : dp) Arrays.fill(ints,-1);

        return dfs(maps, 0, 0, 0);
    }

    private static int dfs(int[][] maps, int row, int col, int depth) {
        if (maps.length - 1 == row && maps[0].length - 1 == col) return 1;
        if (visited[row][col]) return dp[row][col];
        int curValue = maps[row][col];
        visited[row][col] = true;

//        System.out.println(row + ", " + col + ": " + curValue);
        for (int[] dir : dirs) {
            int movedRow = row + dir[0];
            int movedCol = col + dir[1];
            boolean canMove = canMove(maps, movedRow, movedCol);
            if (canMove) {
                if (curValue > maps[movedRow][movedCol])  {
                    dp[row][col] += dfs(maps, movedRow, movedCol, depth + 1);
                }
            }
        }
        PrintUtils.printArray(dp);

        return dp[row][col];
    }

    private static boolean canMove(int[][] maps, int movedRow, int movedCol) {
        return movedRow >= 0 && movedCol >= 0
                && movedRow < maps.length && movedCol < maps[0].length
                ;
    }
}
