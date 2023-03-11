package com.programmers.kakao2020.blind;

import com.coding.utils.PrintUtils;

import java.util.LinkedList;
import java.util.Queue;

/*
 * @2020 kakao blind
 * @TestName: 블록 이동하기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/60063
 * @COMMENT: 10, 14 TC 틀림
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
//        int answer = 0;
        return bfs(board);
    }

    // L(1, 2), R(1, 3) -> L(2, 3)
    // L(5, 3), R(4, 3) -> R(5, 4) C(4,4)
    static int bfs(int[][] board) {
        int cost = 0;
        Queue<Point> queue = new LinkedList<>();

        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean[][] rotated = new boolean[board.length][board[0].length];
        visited[0][0] = true;
        visited[0][1] = true;
//        rotated[0][0] = true;
//        rotated[0][1] = true;
        queue.offer(new Point(0, 0, 0, 1, 0, 'h'));
        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int[] dir : dirs) {
                int nlRow = current.lRow + dir[0];
                int nlCol = current.lCol + dir[1];
                int nrRow = current.rRow + dir[0];
                int nrCol = current.rCol + dir[1];
                Point next = new Point(nlRow, nlCol, nrRow, nrCol, current.cost + 1, current.status);

                if (canMove(next, board, visited)) {
                    queue.offer(next);
                    visited[nlRow][nlCol] = true;
                    visited[nrRow][nrCol] = true;

                    if (next.lRow == board.length - 1 && next.lCol == board[0].length - 1
                            ||next.rRow == board.length - 1 && next.rCol == board[0].length - 1) {
                        cost = next.cost;
                        return cost;
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
                        visited[nlRow][nlCol] = true;
                        visited[nrRow][nrCol] = true;
                        rotated[current.lRow][current.lCol] = true;
                        rotated[current.rRow][current.rCol] = true;

                        if (next.lRow == board.length - 1 && next.lCol == board[0].length - 1
                                ||next.rRow == board.length - 1 && next.rCol == board[0].length - 1) {
                            cost = next.cost;
                            return cost;
                        }
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
                        visited[nlRow][nlCol] = true;
                        visited[nrRow][nrCol] = true;
                        rotated[current.lRow][current.lCol] = true;
                        rotated[current.rRow][current.rCol] = true;

                        if (next.lRow == board.length - 1 && next.lCol == board[0].length - 1
                                ||next.rRow == board.length - 1 && next.rCol == board[0].length - 1) {
                            cost = next.cost;
                            return cost;
                        }

                    }
                }
            }

        }

//        System.out.println();
//        PrintUtils.printArray(visited);
//        PrintUtils.printArray(rotated);
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
    static boolean canRotate(Point moved, int[][] map) {
        return isOk(moved, map)
                && map[moved.lRow][moved.lCol] == 0
                && map[moved.rRow][moved.rCol] == 0
                ;
    }

}
