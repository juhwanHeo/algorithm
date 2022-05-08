package com.programmers.kakao2017.preliminary;

import java.util.Arrays;

/*
 * @2017 카카오코드 예선
 * @TestName: 카카오프렌즈 컬러링북
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/1829
 */
public class ColoringBook {

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;
    static int count = 0;
    static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new boolean[m][n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (picture[row][col] != 0 && !visited[row][col]) {
                    dfs(picture, row, col);
                    numberOfArea++;
                }

                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
                count = 0;
            }
        }

        return new int[] {numberOfArea, maxSizeOfOneArea};
    }

    private static void dfs(int[][] picture, int row, int col) {
        visited[row][col] = true;
        count++;
        System.out.println("(" + row + ", " + col + ") : " + picture[row][col]);

        for (int[] dir : dirs) {
            int movedRow = row + dir[0];
            int movedCol = col + dir[1];

            if (canMove(picture, row, col, movedRow, movedCol)) dfs(picture, movedRow, movedCol);
        }
    }

    private static boolean canMove(int[][] array, int row, int col, int movedRow, int movedCol) {
        return movedRow >= 0 && movedRow < array.length
                && movedCol >= 0 && movedCol < array[0].length
                && !visited[movedRow][movedCol]
                && array[row][col] == array[movedRow][movedCol]
                && array[movedRow][movedCol] != 0;
    }

    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}
        };

        System.out.println(Arrays.toString(solution(m, n, picture)));

    }
}