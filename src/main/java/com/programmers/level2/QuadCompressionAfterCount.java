package com.programmers.level2;

/*
 * @level2
 * @TestName: 쿼드압축 후 개수 세기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/68936
 */
public class QuadCompressionAfterCount {

    static int[] answer;
    public static int[] solution(int[][] arr) {
        answer = new int[2];
        dfs(0, 0, arr.length, arr);
        return answer;
    }

    private static boolean check(int x, int y, int len, int[][] arr) {
        for (int i = x; i < x + len; i++) {
            for (int k = y; k < y + len; k++) {
                if (arr[x][y] != arr[i][k]) return false;
            }
        }
        return true;
    }

    private static void dfs(int x, int y, int len, int[][] arr) {
        if (check(x, y, len, arr)) {
            answer[arr[x][y]]++;
            return;
        }

        dfs(x, y, len / 2, arr);
        dfs(x + len / 2, y, len / 2, arr);
        dfs(x, y + len / 2, len / 2, arr);
        dfs(x + len / 2, y + len / 2, len / 2, arr);
    }
}
