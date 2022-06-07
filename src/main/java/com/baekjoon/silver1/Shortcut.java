package com.baekjoon.silver1;

import com.coding.utils.PrintUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * @Silver1
 * @TestName: 지름길
 * @URL: https://www.acmicpc.net/problem/1446
 */
public class Shortcut {

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

    static List<List<Node>> adj;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(stk.nextToken());
        int D = Integer.parseInt(stk.nextToken());

        adj = new ArrayList<>();
        dist = new int[10001];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i <= 10000; i++) {
            adj.add(new ArrayList<>());
            if (i < D) adj.get(i).add(new Node(i + 1, 1));
        }

        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            int cost = Integer.parseInt(stk.nextToken());

            adj.get(start).add(new Node(end, cost));
        }

        dijkstra(0);
        System.out.println(adj);
        PrintUtils.printArray1(dist);
        System.out.println(dist[D]);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int current = node.end;

            for (Node next : adj.get(current)) {
                if (dist[next.end] > dist[current] + next.cost) {
                    dist[next.end] = dist[current] + next.cost;
                    pq.offer(new Node(next.end, dist[current]));
                }
            }

            adj.get(current).forEach(next -> {
                if (dist[next.end] > dist[current] + next.cost) {
                    dist[next.end] = dist[current] + next.cost;
                    pq.offer(new Node(next.end, dist[current]));
                }
            });
        }
    }
}

