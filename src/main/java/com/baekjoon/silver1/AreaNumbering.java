package com.baekjoon.silver1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * @Silver1
 * @TestName: 단지번호붙이기
 * @URL: https://www.acmicpc.net/problem/2667
 * @COMMENT: dfs로 구역 구분하기
 */
public class AreaNumbering {

    static int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    static int[][] map;
    static boolean[][] visited;
    static List<Integer> areaList;
    static int areaCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(stk.nextToken());
        areaList = new ArrayList<>();
        map = new int[N + 1][N +1];
        visited = new boolean[N + 1][N + 1];
        areaCnt = 0;

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                dfs(i, j, 0);
            }
        }
        Collections.sort(areaList);

        StringBuilder sb = new StringBuilder();
        sb.append(areaList.size()).append("\n");
        areaList.forEach(area -> sb.append(area).append("\n"));

        System.out.println(sb);
    }


    private static void dfs(int row, int col, int cnt) {
        if (map[row][col] == 0 || visited[row][col]) {
            if (areaCnt != 0) areaList.add(areaCnt);
            areaCnt = 0;
            return;
        }

        areaCnt++;
        visited[row][col] = true;
        for (int[] dir : dirs) {
            int movedRow = row + dir[0];
            int movedCol = col + dir[1];

            if (canMove(movedRow, movedCol)) {
                dfs(movedRow, movedCol, cnt + 1);
            }
        }
    }

    private static boolean canMove(int movedRow, int movedCol) {
        return movedRow >= 0 && movedRow < map.length
                && movedCol >= 0 && movedCol < map[0].length
                && !visited[movedRow][movedCol]
                && map[movedRow][movedCol] == 1;
    }
}
