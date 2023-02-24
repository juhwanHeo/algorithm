package com.programmers.level2;

/*
 * @level2
 * @TestName: 마법의 엘리베이터
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/148653
 */
public class MagicalElevator {

    static int[] count = {0, 1, 2, 3, 4, 5, 4, 3, 2, 1};
    static int answer;

    public static int solution(int storey) {
        answer = Integer.MAX_VALUE;

        dfs(storey, 0);
//        dfs(storey, 0 , 1);
        return answer;
    }

    static void dfs(int depth, int value) {
        if (depth < 10) {
            /* 6 이상이면 10으로 만들어서 -10 버튼을 눌러야함 */
            int p = depth > 5 ? 1 : 0;
            answer = Math.min(count[depth] + p + value, answer);
            return;
        }

        // 15 --> 10 --> 0
        if (depth % 10 <= 5) dfs(depth / 10, count[depth % 10] + value);
        // 15 --> 20 --> 10 --> 0
        if (depth % 10 >= 5) dfs(depth / 10 + 1, count[depth % 10] + value);
    }

    static void dfs(int storey, int value, int depth) {
        System.out.println(storey + ", " + value + ", " + depth);
        if (storey == 0) {
            answer = Math.min(answer, value);
            return;
        }
        if (depth > 100_000_000) return;

        int m = storey % (depth * 10);
        int digit = m / depth;

        dfs(storey - m, value + digit, depth * 10); // -
        dfs(storey + m, value + (10 - digit), depth * 10); // +
    }
}
