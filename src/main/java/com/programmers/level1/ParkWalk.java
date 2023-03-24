package com.programmers.level1;

/*
 * @level1
 * @TestName: 공원 산책
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/172928
 */
public class ParkWalk {

    static int currentRow, currentCol;
    public static int[] solution(String[] park, String[] routes) {
        calcRowCol(park);

        for (String route : routes) {
            String[] split = route.split(" ");
            String op = split[0];
            int n = Integer.parseInt(split[1]);

            dfs(park, currentRow, currentCol, op, n, 0);
        }

        return new int[] {currentRow, currentCol};
    }

    static void dfs(String[] park, int row, int col, String op, int n, int depth) {
        if (depth == n) {
            currentRow = row;
            currentCol = col;
            return;
        }

        int nRow = row, nCol = col;
        switch (op) {
            case "N": nRow -= 1; break;
            case "E": nCol += 1; break;
            case "W": nCol -= 1; break;
            case "S": nRow += 1; break;
        }

        if (canMove(park, nRow, nCol)) {
            dfs(park, nRow, nCol, op, n, depth + 1);
        }
    }

    // 주어진 방향으로 이동할 때 공원을 벗어나는지 확인합니다.
    // 주어진 방향으로 이동 중 장애물을 만나는지 확인합니다.
    static boolean canMove(String[] park, int nRow, int nCol) {
        return nRow >= 0 && nRow < park.length
                && nCol >= 0 && nCol < park[0].length()
                && park[nRow].charAt(nCol) != 'X'
                ;
    }

    static void calcRowCol(String[] park) {
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    currentRow = i;
                    currentCol = j;
                    return;
                }
            }
        }
    }
}
