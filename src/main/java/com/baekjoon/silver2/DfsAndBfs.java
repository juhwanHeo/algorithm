package com.baekjoon.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * @Silver2
 * @TestName: DFS와 BFS
 * @URL: https://www.acmicpc.net/problem/1260
 */
public class DfsAndBfs {

    static List<List<Integer>> adj;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int V = Integer.parseInt(stk.nextToken());

        sb = new StringBuilder();
        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());

            adj.get(start).add(end);
            adj.get(end).add(start);
        }
        for (List<Integer> list : adj) Collections.sort(list);

        visited = new boolean[N + 1];
        dfs(V);
        sb.append('\n');
        visited = new boolean[N  + 1];
        bfs(V);

        System.out.println(sb);
    }

    private static void dfs(int start) {
        if (visited[start]) return;
        sb.append(start).append(' ');
        visited[start] = true;
        adj.get(start).forEach(next -> {
            if (!visited[next]) dfs(next);
        });
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            sb.append(current).append(' ');
            adj.get(current).forEach(next -> {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            });
        }
    }
}