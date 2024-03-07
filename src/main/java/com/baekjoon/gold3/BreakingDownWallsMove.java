package com.baekjoon.gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*
 * @Gold3
 * @TestName: 벽 부수고 이동하기
 * @URL: https://www.acmicpc.net/problem/2206
 */
public class BreakingDownWallsMove {
    static int row;
    static int col;
    static int[][][] dp;
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
            final String[] split = line.split("");
            for (int j = 0; j < split.length; j++) {
                maps[i][j] = Integer.parseInt(split[j]);
            }
        }

        int result = solution(row, col, maps);
        System.out.println(result);
    }

    public static int solution(int N, int M, int[][] maps) {
        row = maps.length;
        col = maps[0].length;
        dp = new int[2][row][col];
        visited = new boolean[row][col];

        // dfs
//        for (int[] ints : dp[0]) {
//            Arrays.fill(ints, Integer.MAX_VALUE);
//        }
//
//        dfs(maps, 0, 0, 0, 1);
//        int result = dp[0][row - 1][col - 1];
//        if (result == Integer.MAX_VALUE) return -1;
//        return result;

        // bfs
        return bfs(maps);
    }

    static void dfs(int[][] maps, int r, int c, int breakCount, int depth) {
        if (row == r && col == c) return;
        if (breakCount == 2) return;
        if (visited[r][c]) return;;

        dp[0][r][c] = Math.min(dp[0][r][c], depth);
        for (int[] dir : dirs) {
            int movedRow = r + dir[0];
            int movedCol = c + dir[1];
//            int cost = depth;
//            System.out.println(movedRow + ", " + movedCol + ", " + breakCount + ", " + cost);
            if (movedRow >= 0 && movedCol >= 0 && movedRow < row && movedCol < col) {
                visited[r][c] = true;
                if (maps[movedRow][movedCol] == 1) dfs(maps, movedRow, movedCol, breakCount + 1, depth + 1);
                else dfs(maps, movedRow, movedCol, breakCount, depth + 1);
                visited[r][c] = false;
            }
        }
    }

    static int bfs(int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 1}); // row, col, break, cost

        dp[0][row - 1][col - 1] = Integer.MAX_VALUE;
        dp[1][row - 1][col - 1] = Integer.MAX_VALUE;
        dp[0][0][0] = 1;
        dp[1][0][0] = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] dir : dirs) {
                int movedRow = cur[0] + dir[0];
                int movedCol = cur[1] + dir[1];
                int breakCount = cur[2];
                int cost = cur[3];

                final boolean canMove = canMove(movedRow, movedCol);
                System.out.println(movedRow + ", " + movedCol + ", " + breakCount + ", " + canMove + ", " + cost);
                if (canMove) {
                    if (maps[movedRow][movedCol] == 1 || breakCount == 1) {
                        if (isOk(maps, movedRow, movedCol, 1, breakCount)) {
                            int movedBreakCount = (maps[movedRow][movedCol] == 1) ? breakCount + 1 : breakCount;
                            queue.offer(new int[] {movedRow, movedCol, movedBreakCount, cost + 1});
                            dp[1][movedRow][movedCol] = cost + 1;
                        }
                    }
                    else if (maps[movedRow][movedCol] == 0){
                        if (isOk(maps, movedRow, movedCol, 0, breakCount)) {
                            queue.offer(new int[] {movedRow, movedCol, breakCount, cost + 1});
                            dp[0][movedRow][movedCol] = cost + 1;
                        }
                    }
                }
            }
        }

        int cost = Math.min(dp[0][row - 1][col - 1], dp[1][row - 1][col - 1]);
        if (cost == Integer.MAX_VALUE) return -1;
        return cost;
    }

    private static boolean isOk(int[][] maps, int movedRow, int movedCol, int isBreak, int breakCount) {
        return (maps[movedRow][movedCol] == 0 || breakCount == 0)
                && breakCount <= 1
                && (dp[isBreak][movedRow][movedCol] == 0 || dp[isBreak][movedRow][movedCol] == Integer.MAX_VALUE)
                ;
    }

    private static boolean canMove(int movedRow, int movedCol) {
        return movedRow >= 0 && movedCol >= 0
                && movedRow < row && movedCol < col
                ;
    }
}
