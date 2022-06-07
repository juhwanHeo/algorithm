package com.baekjoon.gold5;

import com.coding.utils.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * @Gold5
 * @TestName: 노드사이의 거리
 * @URL: https://www.acmicpc.net/problem/1240
 */
public class DistanceBetweenNodes {

    static List<List<Node>> adj;
    static int[] dist;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            int cost = Integer.parseInt(stk.nextToken());


            adj.get(start).add(new Node(end, cost));
            adj.get(end).add(new Node(start, cost));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());

            visited = new boolean[N + 1];
            dist = new int[N + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            sb.append(bfs(start, end)).append('\n');
        }

        System.out.println(sb);
    }

    private static int bfs(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        visited[start] = true;
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int current = node.end;

            for (Node next : adj.get(current)) {
                if (!visited[next.end] && dist[next.end] > dist[current] + next.cost) {
                    visited[next.end] = true;
                    dist[next.end] = dist[current] + next.cost;
                    pq.offer(new Node(next.end,  dist[current]));
                }
            }
        }

        return dist[end];
    }
}
