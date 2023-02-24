package com.programmers.kakao2023.blind;

public class Test6 {

    // a b c d e f g h i j
    // k l m n o p q r s t
    // u v w x y z
    static String[] dirsStr = {"d" , "l", "r", "u"};
    static int[][] dirs = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
    static StringBuilder answer;
    static String result;
    static int endRow, endCol, mapRow, mapCol;
    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        result = null;
        answer = new StringBuilder();
        mapRow = n;
        mapCol = m;
        endRow = r;
        endCol = c;
        // x, y : start
        // r, c : end

        dfs(x, y, 0, k);

        return result != null ? result : "impossible";
    }

    static void dfs(int row, int col, int depth, int limit) {
//        if (depth + distance(row, col, endRow, endCol) > limit) return;
        if (result != null) return;
        if (limit == depth) {
            if (row == endRow && col == endCol) result = answer.toString();
            return;
        }

        for (int i = 0; i < dirs.length; i++) {
            int nRow = row + dirs[i][0];
            int nCol = col + dirs[i][1];
            if (nRow > 0 && nCol > 0 && nRow <= mapRow && nCol <= mapCol) {
                answer.append(dirsStr[i]);
                dfs(nRow, nCol, depth + 1, limit);
                answer.delete(depth, depth + 1);
            }
        }
    }

    static int distance(int x, int y, int r, int c) {
        return Math.abs(x - r) + Math.abs(y - c);
    }

    static class Direction {
        int d, l, r, u;
    }

    public static String solution2(int n, int m, int x, int y, int r, int c, int k) {
        StringBuilder answer = new StringBuilder();
        Direction direction = new Direction();
        int dist = distance(x, y ,r ,c);
        k -= dist;
        if (k < 0 || k % 2 != 0) return "impossible";

        if (x > r) direction.u += x - r;
        else direction.d += r - x;

        if (y > c) direction.l += y - c;
        else direction.r = c - y;

        for (int i = 0; i < direction.d; i++) answer.append("d");

        int d = Math.min(k / 2, n - (x + direction.d));
        for (int i = 0; i < d; i++) answer.append("d");
        direction.u += d;
        k -= 2 * d;

        for (int i = 0; i < direction.l; i++) answer.append("l");
        int l = Math.min(k / 2, y - direction.l - 1);
        for (int i = 0; i < l; i++) answer.append("l");
        direction.r += l;
        k -= 2 * l;

        for (int i = 0; i < k / 2; i++) answer.append("rl");
        for (int i = 0; i < direction.r; i++) answer.append("r");
        for (int i = 0; i < direction.u; i++) answer.append("u");
        return answer.toString();
    }

}
