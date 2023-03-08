package com.programmers.kakao2020.blind;

import com.coding.utils.PrintUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @2020 kakao blind
 * @TestName: 블록 이동하기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/60063
 */
public class MovingBlocks {
    static class Point {
        int lRow, lCol, rRow, rCol, cost;
        char status;

        public Point(int lRow, int lCol, int rRow, int rCol, int cost) {
            this.lRow = lRow;
            this.lCol = lCol;
            this.rRow = rRow;
            this.rCol = rCol;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "(" + lRow + ", " + lCol + ", " + rRow + ", " + rCol + ", " + cost + ")";
        }
    }

    static int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    // lRow, lCol, rRow, rCol
    static int[][] rotates = {{0, 0, 1, -1}, {0, 0, -1, -1}, {-1, 1, 0, 0}, {1, 1, 0, 0}};
    static int[][] vRotates = {{0, 0, 1, -1}, {0, 0, -1, -1}, {-1, 1, 0, 0}, {1, 1, 0, 0}};
    public static int solution(int[][] board) {
//        int answer = 0;
        return bfs(board);
    }

    // L(1, 2), R(1, 3) -> L(2, 3)
    // L(5, 3), R(4, 3) -> R(5, 4) C(4,4)
    static int bfs(int[][] board) {
        int cost = 0;
        Queue<Point> queue = new LinkedList<>();

        boolean[][] visited = new boolean[board.length][board[0].length];
        int[][] map = new int[board.length][board[0].length];
        visited[0][0] = true;
        visited[0][1] = true;
        queue.offer(new Point(0, 0, 0, 1, 0));
        while (!queue.isEmpty()) {
            System.out.println(queue);
            Point current = queue.poll();
            
            if (current.lRow == board.length - 1 && current.lCol == board[0].length - 1
                    ||current.rRow == board.length - 1 && current.rCol == board[0].length - 1) {
                cost = current.cost;
                break;
            }

            for (int[] dir : dirs) {
                int nlRow = current.lRow + dir[0];
                int nlCol = current.lCol + dir[1];
                int nrRow = current.rRow + dir[0];
                int nrCol = current.rCol + dir[1];
                Point next = new Point(nlRow, nlCol, nrRow, nrCol, current.cost + 1);

                if (canMove(next, board, visited)) {
                    queue.offer(next);
                    visited[nlRow][nlCol] = true;
                    visited[nrRow][nrCol] = true;
                }
            }

            for (int[] rotate : rotates) {
                int nlRow = current.lRow + rotate[0];
                int nlCol = current.lCol + rotate[1];
                int nrRow = current.rRow + rotate[2];
                int nrCol = current.rCol + rotate[3];
                Point next = new Point(nlRow, nlCol, nrRow, nrCol, current.cost + 1);
                if (canRotate(rotate, next, board, visited)) {
                    queue.offer(new Point(nlRow, nlCol, nrRow, nrCol, current.cost + 1));
                    visited[nlRow][nlCol] = true;
                    visited[nrRow][nrCol] = true;
                }
            }

        }

        System.out.println();
        PrintUtils.printArray(visited);
        return cost;
    }

    static boolean isOk(Point moved, int[][] map) {
        return moved.lRow >= 0 && moved.lRow < map.length
                && moved.rRow >= 0 && moved.rRow < map.length
                && moved.lCol >= 0 && moved.lCol < map[0].length
                && moved.rCol >= 0 && moved.rCol < map[0].length
                ;
    }

    static boolean canMove(Point moved, int[][] map, boolean[][] visited) {
        return isOk(moved, map)
                && (!visited[moved.lRow][moved.lCol] || !visited[moved.rRow][moved.rCol])
                && map[moved.lRow][moved.lCol] == 0
                && map[moved.rRow][moved.rCol] == 0
                ;
    }

    /*
    * 회전하는 가능 여부
    * */
    static boolean canRotate(int[] rotate, Point moved, int[][] map, boolean[][] visited) {
        if (rotate[0] == 0) {

        }
        else if (rotate[2] == 0) {

        }
        return isOk(moved, map)
                // 이동할 Point 가 0인지 체크
                && map[moved.lRow][moved.lCol] == 0 && map[moved.rRow][moved.rCol] == 0
                ;
    }

}
