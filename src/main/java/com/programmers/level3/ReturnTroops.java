package com.programmers.level3;

import com.coding.utils.PrintUtils;

import java.util.*;

/*
 * @level3
 * @TestName: 부대 복귀
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/132266
 */
public class ReturnTroops {
    static List<List<Integer>> adj;
    static boolean[] visited;
    static int[] dist;
    static final int MAX_VALUE = 1_000_000_000;
    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<Integer> list = new ArrayList<>();
        adj = new ArrayList<>();
        visited = new boolean[n + 1];
        dist = new int[n + 1];

        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        Arrays.fill(dist, MAX_VALUE);

        for (int[] road : roads) {
            int start = road[0];
            int end = road[1];

            adj.get(start).add(end);
            adj.get(end).add(start);
        }

        bfs(destination);

        for (int source : sources) list.add(dist[source]);
        return list.stream()
                .map(val -> {
                    if (val >= MAX_VALUE) return -1;
                    return val;
                })
                .mapToInt(Integer::intValue)
                .toArray();
    }

    static void bfs(int start) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(start);
        visited[start] = true;
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : adj.get(current)) {
                if (dist[next] > dist[current] + 1) {
                    visited[next] = true;
                    dist[next] = dist[current] + 1;
                    queue.add(next);
                }
            }
        }
    }
}