package com.baekjoon.silver2;

import com.coding.utils.PrintUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * @Silver2
 * @TestName: 특정 거리의 도시 찾기
 * @URL: https://www.acmicpc.net/problem/18352
 */
public class FindCity {

    private static class Node implements Comparable<Node> {
        int end;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        int cost;

        @Override
        public int compareTo(Node o) {
            return Integer.compare(cost, o.cost);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "end=" + end +
                    ", cost=" + cost +
                    "}";
        }
    }

//    static List<List<Integer>> adj;
    static List<List<Node>> adj;
    static int[] dist;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        int X = Integer.parseInt(stk.nextToken());

        adj = new ArrayList<>();
        dist = new int[N + 1];
        visited = new boolean[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i <= N; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());

            adj.get(start).add(new Node(end, 1));
        }

//        dfs(X, 0);

        dijkstra(X);
        System.out.println(adj);
        PrintUtils.printArray(dist);

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == K) list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        if (list.size() > 0) {
            for (int data : list) sb.append(data).append('\n');
            System.out.println(sb);
        }

        else System.out.println(-1);
    }


    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        visited[start] = true;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int current = node.end;

            for (Node next : adj.get(current)) {
                if (!visited[next.end] && dist[next.end] > dist[current] + next.cost) {
                    visited[next.end] = true;
                    dist[next.end] = dist[current] + next.cost;
                    pq.offer(new Node(next.end, dist[current]));
                }
            }

//            adj.get(current).forEach(next -> {
//                if (!visited[next.end] && dist[next.end] > dist[current] + next.cost) {
//                    visited[next.end] = true;
//                    dist[next.end] = dist[current] + next.cost;
//                    pq.offer(new Node(next.end, dist[current]));
//                }
//            });
        }
    }

    /*
    * dfs 메모리 초과
    * */
//    private static void dfs(int start, int cost) {
//        System.out.println("start: " + start + ", cost: " + cost);
//        dist[start] = Math.min(dist[start], cost);
//        for (int next : adj.get(start)) {
//            dfs(next, cost + 1);
//        }
//    }
}