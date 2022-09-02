package com.baekjoon.silver1;

import com.coding.utils.PrintUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
 * @Silver1
 * @TestName: 영역 구하기
 * @URL: https://www.acmicpc.net/problem/2583
 * @COMMENT: dfs로 구역 구분하기
 */
public class FindArea {

    static int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    static int[][] map;
    static boolean[][] visited;
    static List<Integer> areaList;
    static int areaCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        areaList = new ArrayList<>();
        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        areaCnt = 0;

        for (int i = 0; i <= N; i++) map[i][M] = 1;
        for (int i = 0; i <= M; i++) map[0][i] = 1;

        for (int i = 0; i < K; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int startCol = Integer.parseInt(stk.nextToken());
            int startRow = N - Integer.parseInt(stk.nextToken());
            int endCol = Integer.parseInt(stk.nextToken());
            int endRow = N - Integer.parseInt(stk.nextToken());

            for (int j = startRow; j > endRow; j--) {
                for (int k = startCol; k < endCol; k++) {
                    map[j][k] = 1;
                }
            }
        }

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if (map[i][j] == 0 && !visited[i][j]){
                    visited[i][j] = true;
                    dfs(i, j, 0);
                }

                if (areaCnt != 0) areaList.add(areaCnt);
                areaCnt = 0;
            }
        }

        PrintUtils.printArray(map);
        Collections.sort(areaList);
        StringBuilder sb = new StringBuilder();
        sb.append(areaList.size()).append("\n");
        areaList.forEach(area -> sb.append(area).append(" "));

        System.out.println(sb);
    }


    private static void dfs(int row, int col, int cnt) {
        visited[row][col] = true;
        areaCnt++;

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
                && map[movedRow][movedCol] == 0;
    }
}

