package com.programmers.level2;

/*
 * @level2
 * @TestName: 카펫
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/42842
 */
public class Carpet {

    public static int[] solution(int brown, int yellow) {
        int[] answer = {};
        int sum = brown + yellow;

        dfs(1, 1, sum, 0);
        return answer;
    }

    static void dfs(int row, int col, int sum, int depth) {
        if (row < col) return;
        if (sum % (row * col) == 0) {
            System.out.println(row + ", " + row);
            return;
        }
        if (sum == depth) return;


        dfs(row + 1, col, sum, depth + 1);
        dfs(row, col + 1, sum, depth + 1);

    }
}
