package com.baekjoon.gold5;

import com.coding.utils.PrintUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * @Gold5
 * @TestName: 보물섬
 * @URL: https://www.acmicpc.net/problem/2589
 */
public class TreasureIsland {

    private static class Node {
        int row, col, cost;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public Node(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }

    static int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    //    static int[][] map;
    static char[][] charMap;
    static boolean[][] visited;
    static int maxHour;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        int R = Integer.parseInt(stk.nextToken());
        int C = Integer.parseInt(stk.nextToken());
        maxHour = Integer.MIN_VALUE;
        charMap = new char[R][C];

        for (int row = 0; row < R; row++) {
            String rowStr = br.readLine();
            for (int col = 0; col < C; col++) {
                charMap[row][col] = rowStr.charAt(col);
            }
        }

        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (charMap[row][col] != 'W') {
                    visited = new boolean[R][C];
//                    map = new int[R][C];
                    System.out.println("point: " + row + ", " + col);
                    bfs(row, col);
//                    PrintUtils.printArray(map);
                }
            }
        }
        System.out.println(maxHour);
    }

    private static void bfs(int row, int col) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(row, col, 1));
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int[] dir : dirs) {
                int movedRow = current.row + dir[0];
                int movedCol = current.col + dir[1];

                if (canMove(movedRow, movedCol)) {
                    visited[movedRow][movedCol] = true;
//                    map[movedRow][movedCol] += map[current.row][current.col] + 1;
//                    maxHour = Math.max(map[movedRow][movedCol], maxHour);
                    maxHour = Math.max(current.cost, maxHour);
                    queue.offer(new Node(movedRow, movedCol, current.cost + 1));
                }
            }

        }
    }

    private static boolean canMove(int movedRow, int movedCol) {
        return movedRow >= 0 && movedRow < charMap.length
                && movedCol >= 0 && movedCol < charMap[0].length
                && !visited[movedRow][movedCol]
                && charMap[movedRow][movedCol] != 'W';
    }

}
