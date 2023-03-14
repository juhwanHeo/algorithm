package com.programmers.kakao2020.blind;

import com.coding.utils.PrintUtils;

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

        public Point(int lRow, int lCol, int rRow, int rCol, int cost, char status) {
            this.lRow = lRow;
            this.lCol = lCol;
            this.rRow = rRow;
            this.rCol = rCol;
            this.cost = cost;
            this.status = status;
        }

        @Override
        public String toString() {
            return "(" + lRow + ", " + lCol + ", " + rRow + ", " + rCol + ", " + cost + ", " + status + ")";
        }
    }

    static int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    // lRow, lCol, rRow, rCol

    // horizontal
    static int[][] hRotates = {{-1, 0, -1, 0}, {1, 0, 1, 0}};
    // vertical
    static int[][] vRotates = {{0, -1, 0, -1}, {0, 1, 0, 1}};

    public static int solution(int[][] board) {
        return bfs(board);
    }

    static int bfs(int[][] board) {
        int cost = 0;
        Queue<Point> queue = new LinkedList<>();

        // visited[horizontal: 0 | vertical: 1][row][col]
        boolean[][][] visited = new boolean[2][board.length][board[0].length];
        boolean[][] rotated = new boolean[board.length][board[0].length];
        visited[0][0][0] = true;
        visited[0][1][0] = true;
        queue.offer(new Point(0, 0, 0, 1, 0, 'h'));
        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (current.lRow == board.length - 1 && current.lCol == board[0].length - 1
                    || current.rRow == board.length - 1 && current.rCol == board[0].length - 1) {
                cost = current.cost;
                break;
            }

            for (int[] dir : dirs) {
                int nlRow = current.lRow + dir[0];
                int nlCol = current.lCol + dir[1];
                int nrRow = current.rRow + dir[0];
                int nrCol = current.rCol + dir[1];
                Point next = new Point(nlRow, nlCol, nrRow, nrCol, current.cost + 1, current.status);

                if (canMove(next, board, visited)) {
                    queue.offer(next);
                    if (next.status == 'h') {
                        visited[0][nlRow][nlCol] = true;
                        visited[0][nrRow][nrCol] = true;
                    }
                    else {
                        visited[1][nlRow][nlCol] = true;
                        visited[1][nrRow][nrCol] = true;
                    }
                }
            }

            if (rotated[current.lRow][current.lCol] && rotated[current.rRow][current.rCol]) continue;
            if (current.status == 'h') {
                for (int[] rotate : hRotates) {
                    int nlRow = current.lRow + rotate[0];
                    int nlCol = current.lCol + rotate[1];
                    int nrRow = current.rRow + rotate[2];
                    int nrCol = current.rCol + rotate[3];
                    Point next = new Point(nlRow, nlCol, nrRow, nrCol, current.cost + 1, current.status);
                    if (canRotate(next, board)) {
                        queue.offer(new Point(current.lRow, current.lCol, nlRow, nlCol, current.cost + 1, 'v'));
                        queue.offer(new Point(nrRow, nrCol, current.rRow, current.rCol, current.cost + 1, 'v'));
                        rotated[current.lRow][current.lCol] = true;
                        rotated[current.rRow][current.rCol] = true;
                    }
                }
            }
            else {
                for (int[] rotate : vRotates) {
                    int nlRow = current.lRow + rotate[0];
                    int nlCol = current.lCol + rotate[1];
                    int nrRow = current.rRow + rotate[2];
                    int nrCol = current.rCol + rotate[3];
                    Point next = new Point(nlRow, nlCol, nrRow, nrCol, current.cost + 1, current.status);
                    if (canRotate(next, board)) {
                        queue.offer(new Point(current.lRow, current.lCol, nlRow, nlCol, current.cost + 1, 'h'));
                        queue.offer(new Point(nrRow, nrCol, current.rRow, current.rCol, current.cost + 1, 'h'));
                        rotated[current.lRow][current.lCol] = true;
                        rotated[current.rRow][current.rCol] = true;
                    }
                }
            }

        }

//        System.out.println();
        PrintUtils.printArray(visited[0]);
//        PrintUtils.printArray(rotated);
        return cost;
    }

    /*
    * map 크기 안에 있는지 확인
    * */
    static boolean isOk(Point moved, int[][] map) {
        return moved.lRow >= 0 && moved.lRow < map.length
                && moved.rRow >= 0 && moved.rRow < map.length
                && moved.lCol >= 0 && moved.lCol < map[0].length
                && moved.rCol >= 0 && moved.rCol < map[0].length
                ;
    }

    /*
    * 이동 가능 여부
    * */
    static boolean canMove(Point moved, int[][] map, boolean[][][] visited) {
        int type = (moved.status == 'h') ? 0 : 1;
        return isOk(moved, map)
                && (!visited[type][moved.lRow][moved.lCol] || !visited[type][moved.rRow][moved.rCol])
                && map[moved.lRow][moved.lCol] == 0
                && map[moved.rRow][moved.rCol] == 0
                ;
    }

    /*
    * 회전 가능 여부
    * */
    static boolean canRotate(Point moved, int[][] map) {
        return isOk(moved, map)
                && map[moved.lRow][moved.lCol] == 0
                && map[moved.rRow][moved.rCol] == 0
                ;
    }

}
