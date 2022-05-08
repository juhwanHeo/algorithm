package com.programmers.kakao2020.blind;

import java.util.Arrays;

/*
 * @2020 kakao blind
 * @TestName: 외벽 점검
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/60062
 * @COMMENT: 원 인덱싱
 */
public class CheckWall {
    static int ret = Integer.MAX_VALUE;
    static boolean[] visited;
    public static int solution(int n, int[] weak, int[] dist) {
        int[] w = new int[weak.length * 2];

        for (int i = 0; i < w.length; i++) {
            if (i < weak.length) w[i] = weak[i];
            else w[i] = n + weak[i - weak.length];
        }

        System.out.println("w = " + Arrays.toString(w));
        System.out.println("dist = " + Arrays.toString(dist));
        System.out.println("weak.length = " + weak.length);
//        for (int i = 0; i < weak.length; i++) {
        for (int i = 1; i < 2; i++) {
            visited = new boolean[dist.length];
            System.out.println("(weak.length + i) = " + (weak.length + i));
            dfs(w, dist, i, weak.length + i, 0);
        }

        System.out.println("ret = " + ret);
        System.out.println("w = " + Arrays.toString(w));
        return ret <= n ? ret : -1 ;
    }

    public static void dfs(int[] weak, int[] dist, int start, int end, int sum) {
        if (start >= end) {
            ret = Math.min(ret, sum);
            System.out.println("dfs End ## sum: " + sum);
            return;
        }
        for (int i = 0; i < dist.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            int idx = start + 1;
            System.out.println("start = " + start);
            System.out.println("idx = " + idx);
            System.out.println("dist[" + i + "] = " + dist[i]);
            while (idx < end && (weak[idx] - weak[start]) <= dist[i]) {
                idx++;
            }
            System.out.println("idx = " + idx);
            dfs(weak, dist, idx, end, sum + 1);
            visited[i] = false;

        }
    }

    public static void main(String[] args) {
        int n = 12;
        int[] weak = {
                // 2
                1, 5, 6, 10

        };
        int[] dist = {
                1, 2, 3, 4
        };

        System.out.println("answer " + solution(n, weak, dist));

    }
}
