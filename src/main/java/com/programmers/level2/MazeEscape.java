package com.programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @level2
 * @TestName: 미로 탈출
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/159993
 */
public class MazeEscape {

    static class Point {
        int row, col, cost;

        public Point(int row, int col) {
            this(row, col, 0);
        }

        public Point(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return  "(" + row + ", " + col + ", "  + cost + ")";
        }
    }

    static boolean[][] visited;
    static int[][] maze;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static int solution(String[] maps) {
        Point start = null;
        Point lever = null;
        Point end = null;
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].charAt(j) == 'S') start = new Point(i, j);
                else if (maps[i].charAt(j) == 'L') lever = new Point(i, j);
                else if (maps[i].charAt(j) == 'E') end = new Point(i, j);
            }
        }


        int stol = bfs(maps, start, lever, 'L');
        int ltoe = bfs(maps, lever, end, 'E');

        if (stol == -1 || ltoe == -1) return -1;
        return stol + ltoe;
    }

    static void print(int[][] maze){
        for (int[] ints : maze) {
            System.out.println(Arrays.toString(ints));
        }
    }

    // 아직 레버를 당기지 않았더라도 출구가 있는 칸을 지나갈 수 있습니다
    static int bfs(String[] maps, Point start, Point end, char type) {
        Queue<Point> queue = new LinkedList<>();
        start.cost = 0;
        queue.add(start);
        visited = new boolean[maps.length][maps[0].length()];
        maze = new int[maps.length][maps[0].length()];

        for (int[] arr : maze) Arrays.fill(arr, -1);
        visited[start.row][start.col] = true;
        while (!queue.isEmpty()) {
            System.out.println(queue);
            Point current = queue.poll();

            if (maps[current.row].charAt(current.col) == type) break;;
            for (int[] dir : dirs) {
                int nRow = current.row + dir[0];
                int nCol = current.col + dir[1];

                if (canMove(maps, nRow, nCol)) {
                    visited[nRow][nCol] = true;
                    maze[nRow][nCol] = current.cost + 1;
                    queue.add(new Point(nRow, nCol, current.cost + 1));
                }
            }
        }

        return maze[end.row][end.col];
    }

    static int dfs(String[] maps, Point current, char type, int depth) {
        if (maps[current.row].charAt(current.col) == type) {
            return depth;
        }
        System.out.println(current.row + ", " + current.col + ", " + depth);

        visited[current.row][current.col] = true;
        for (int[] dir : dirs) {
            int nRow = current.row + dir[0];
            int nCol = current.col + dir[1];

            if (canMove(maps, nRow, nCol)) {
                dfs(maps, new Point(nRow, nCol), type, depth + 1);
            }
        }

        return depth;
    }

    private static boolean canMove(String[] maps, int movedRow, int movedCol) {
        return movedRow >= 0 && movedRow < maps.length
                && movedCol >= 0 && movedCol < maps[0].length()
                && !visited[movedRow][movedCol]
                && maps[movedRow].charAt(movedCol) != 'X';
    }

}
