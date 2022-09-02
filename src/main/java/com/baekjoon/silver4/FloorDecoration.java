package com.baekjoon.silver4;

import com.coding.utils.PrintUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * @Silver4
 * @TestName: 바닥 장식
 * @URL: https://www.acmicpc.net/problem/1388
 */
public class FloorDecoration {

    static boolean[][] visited;
    static char[][] map;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        visited = new boolean[N][M];
        map = new char[N][M];
        count = 0;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    count++;
                    dfs(i, j, map[i][j]);
                }
            }
        }
        System.out.println(count);
    }

    private static void dfs(int row, int col, char floor) {
        if (visited[row][col] || map[row][col] != floor) {
            return;
        }
        visited[row][col] = true;

        if (map[row][col] == '-' && map[0].length > col + 1) {
            dfs(row, col + 1, floor);
        }
        else if (map[row][col] == '|' && map.length > row + 1){
            dfs(row + 1, col, floor);
        }
    }
}

