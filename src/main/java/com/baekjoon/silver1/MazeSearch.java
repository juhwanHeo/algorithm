package com.baekjoon.silver1;

import com.coding.utils.PrintUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * @Silver1
 * @TestName: 미로 탐색
 * @URL: https://www.acmicpc.net/problem/2178
 */
public class MazeSearch {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        bfs(0, 0);

        PrintUtils.printArray(map);
        System.out.println(map[N - 1][M - 1]);
    }

    static void bfs(int startRow, int startCol) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startCol, startRow));
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            if (point.x == N && point.y == M) break;

            for (int[] dir : dirs) {
                int movedCol = point.x + dir[0];
                int movedRow = point.y + dir[1];

                if (canMove(movedRow, movedCol)) {
                    map[movedRow][movedCol] =  map[point.y][point.x] + 1;
                    queue.add(new Point(movedCol, movedRow));
                    visited[movedRow][movedCol] = true;
                }
            }
        }
    }

    private static boolean canMove(int movedRow, int movedCol) {
        return movedRow >= 0 && movedRow < map.length
                && movedCol >= 0 && movedCol < map[0].length
                && !visited[movedRow][movedCol]
                && map[movedRow][movedCol] != 0;
    }
}

