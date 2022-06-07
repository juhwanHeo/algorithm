package com.baekjoon.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * @Gold5
 * @TestName: 최단경로
 * @URL: https://www.acmicpc.net/problem/1753
 */
public class ShortestRoute {

    private static class Node implements Comparable<Node> {

        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(weight, o.weight);
        }
    }

    static List<List<Node>> adj;
    static int[] dist;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(stk.nextToken());
        int E = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(br.readLine());

        dist = new int[V + 1];
        visited = new boolean[V + 1];
        adj = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            dist[i] = Integer.MAX_VALUE;
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            int weight = Integer.parseInt(stk.nextToken());

            adj.get(start).add(new Node(end, weight));
        }

        dijkstra(K);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) sb.append("INF").append('\n');
            else sb.append(dist[i]).append('\n');
        }

        System.out.println(sb);
    }

    // 다익스트라
    // dijkstra
    public static void dijkstra(int start){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node edge = queue.poll();
            int current = edge.end;

//            if (visited[current]) continue;
//            visited[current] = true;

            for (Node next : adj.get(current)) {
                if (dist[next.end] > dist[current] + next.weight) {
                    dist[next.end] = dist[current] + next.weight;
                    queue.offer(new Node(next.end, dist[current]));
                }
            }
        }
    }
}
