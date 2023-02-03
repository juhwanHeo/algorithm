package com.programmers.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @level2
 * @TestName: 무인도 여행
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/154540
 */
public class UninhabitedIslandTrip {

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;
    public static int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        visited = new boolean[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (!visited[i][j] && maps[i].charAt(j) != 'X') {
                    int cost = bfs(i, j, maps);
//                    int cost = dfs(i, j, maps);
                    answer.add(cost);
                }
            }
        }

        return answer.isEmpty()
                ? new int[]{-1}
                : answer.stream()
                .mapToInt(Integer::intValue)
                .sorted()
                .toArray();
    }

    static int bfs(int row, int col, String[] maps) {
        int cost = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            cost += Integer.parseInt(String.valueOf(maps[current[0]].charAt(current[1])));
            System.out.println(current[0] + ", " + current[1] + ": " + cost);

            for (int[] dir : dirs) {
                int nRow = current[0] + dir[0];
                int nCol = current[1] + dir[1];

                if (canMove(nRow, nCol, maps)) {
                    visited[nRow][nCol] = true;
                    queue.add(new int[]{nRow, nCol});
                }
            }
        }

        return cost;
    }


    static int dfs(int row, int col, String[] maps) {
        if (!canMove(row, col, maps)) {
            return 0;
        }

        visited[row][col] = true;
        int result = Integer.parseInt(String.valueOf(maps[row].charAt(col)));
        for (int[] dir : dirs) {
            int nRow = row + dir[0];
            int nCol = col + dir[1];
            result += dfs(nRow, nCol, maps);
        }

        return result;
    }

    private static boolean canMove(int movedRow, int movedCol, String[] maps) {
        return movedRow >= 0 && movedRow < maps.length
                && movedCol >= 0 && movedCol < maps[0].length()
                && !visited[movedRow][movedCol]
                && maps[movedRow].charAt(movedCol) != 'X';
    }
}
