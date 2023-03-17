package com.programmers.level1;

import java.util.Arrays;

/*
 * @level1
 * @TestName: 삼총사
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/131705
 */
public class Trio {
    static int answer;
    static int solution(int[] number) {
        answer = 0;

        boolean[] visited = new boolean[number.length];
        dfs(number, visited, 3, 0);
        return answer;
    }

    // depth: 현재 인덱스
    // 현재 인덱스를 뽑는다면 visited[depth] = true
    // 뽑지 않는다면 visited[depth] = false
    static void dfs(int[] number, boolean[] visited, int r, int depth) {
        if (r == 0) {
            System.out.println(Arrays.toString(visited) + ", n: " + number.length + ", r: " + r + ", depth: " + depth);
            int sum = 0;
            for (int i = 0; i < number.length; i++) {
                if (visited[i]) sum += number[i];
            }
            if (sum == 0) answer ++;
            return;
        }
        if (depth == number.length) return;

        visited[depth] = true;
        dfs(number, visited, r - 1, depth + 1);

        visited[depth] = false;
        // [true, false, false, false, false]
        // [false, true, false, false, false]
        dfs(number, visited, r, depth + 1);
    }
}
