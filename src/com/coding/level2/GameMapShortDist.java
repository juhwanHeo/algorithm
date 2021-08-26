package com.coding.level2;

import java.util.*;

/*
 * @level2
 * @TestName: 게임 맵 최단거리
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/1844
 * @COMMENT: BFS (Node Class 미사용)
 */
public class GameMapShortDist {
    static int solution(int[][] maps) {
        int row = maps.length, col = maps[0].length;
        int[][] visited = new int[row][col];
        visited[0][0] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});

        while(!queue.isEmpty()) {
            int[] q = queue.poll();
            int x = q[1];
            int y = q[0];
            if (y == row - 1 && x == col - 1)
                return visited[row - 1][col -1];

            // up
            if (y + 1 < row && maps[y + 1][x] == 1 && visited[y + 1][x] == 0) {
                queue.add(new int[] {y + 1, x});
                visited[y + 1][x] += visited[y][x] + 1;
            }
            // down
            if (y > 0 && maps[y - 1][x] == 1 && visited[y - 1][x] == 0) {
                queue.add(new int[] {y - 1, x});
                visited[y - 1][x] += visited[y][x] + 1;
            }
            // right
            if (x + 1 < col && maps[y][x + 1] == 1 && visited[y][x + 1] == 0) {
                queue.add(new int[] {y, x + 1});
                visited[y][x + 1] += visited[y][x] + 1;
            }
            // left
            if (x > 0 && maps[y][x - 1] == 1 && visited[y][x - 1] == 0) {
                queue.add(new int[] {y, x - 1});
                visited[y][x - 1] += visited[y][x] + 1;
            }
            System.out.println(Arrays.deepToString(visited));
        }

        return -1;
    }


    public static void main(String[] args) {
        int[][] map1 = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}
        };

        /*
        * [1, 0, 9, 10, 11],
        * [2, 0, 8, 00, 10],
        * [3, 0, 7, 08, 09],
        * [4, 5, 6, 00, 10],
        * [0, 0, 0, 00, 11]
        */
        System.out.println(solution(map1));
    }
}
