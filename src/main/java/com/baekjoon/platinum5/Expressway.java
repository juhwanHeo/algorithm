package com.baekjoon.platinum5;

import com.coding.utils.Node2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * @Platinum5
 * @TestName: 고속도로
 * @URL: https://www.acmicpc.net/problem/1702
 */
public class Expressway {

    private static class Pair {
        int cost, time;

        public Pair(int cost, int time) {
            this.cost = cost;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "cost=" + cost +
                    ", time=" + time +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return cost == pair.cost && time == pair.time;
        }

        @Override
        public int hashCode() {
            return Objects.hash(cost, time);
        }
    }
    static List<List<Node2>> adj;
    static int[] dist;
    static int[] fee;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int s = Integer.parseInt(stk.nextToken());
        int e = Integer.parseInt(stk.nextToken());

        adj = new ArrayList<>();
        for (int i = 0; i <= m; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(stk.nextToken());
            int r = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            int t = Integer.parseInt(stk.nextToken());

            adj.get(p).add(new Node2(r, t, c));
            adj.get(r).add(new Node2(p, t, c));
        }


        dist = new int[n + 1];
        fee = new int[n + 1];
        visited = new boolean[n + 1];
        dijkstraMinCost(s);
        Pair minCost = new Pair(fee[e], dist[e]);

        dist = new int[n + 1];
        fee = new int[n + 1];
        visited = new boolean[n + 1];
        dijkstraMinFee(s);
        Pair minFee = new Pair(fee[e], dist[e]);

        System.out.println("minCost = " + minCost);
        System.out.println("minFee = " + minFee);
        if (minCost.equals(minFee)) System.out.println(1);
        else System.out.println(2);
    }

    private static void dijkstraMinCost(int start){
        PriorityQueue<Node2> pq = new PriorityQueue<>(
                (o1, o2) -> {
                    if (o1.cost != o2.cost) return Integer.compare(o1.cost, o2.cost);
                    return Integer.compare(o1.fee, o2.fee);
                }
        );
        pq.offer(new Node2(start, 0, 0));
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(fee, Integer.MAX_VALUE);
        dist[start] = 0;
        fee[start] = 0;
        visited[start] = true;

        while (!pq.isEmpty()) {
            Node2 node = pq.poll();
            int current = node.end;

            for (Node2 next : adj.get(current)) {
                if (dist[next.end] > dist[current] + next.cost) {
                    visited[next.end] = true;
                    dist[next.end] = dist[current] + next.cost;
                    fee[next.end] = fee[current] + next.fee;
                    pq.offer(new Node2(next.end,  dist[current], fee[current]));
                }
            }
        }

    }

    private static void dijkstraMinFee(int start){
        PriorityQueue<Node2> pq = new PriorityQueue<>(
                (o1, o2) -> {
                    if (o1.fee != o2.fee) return Integer.compare(o1.fee, o2.fee);
                    return Integer.compare(o1.cost, o2.cost);
                }
        );

        pq.offer(new Node2(start, 0, 0));
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(fee, Integer.MAX_VALUE);
        dist[start] = 0;
        fee[start] = 0;
        visited[start] = true;

        while (!pq.isEmpty()) {
            Node2 node = pq.poll();
            int current = node.end;

            for (Node2 next : adj.get(current)) {
                if (fee[next.end] > fee[current] + next.fee) {
                    fee[next.end] = fee[current] + next.fee;
                    dist[next.end] = dist[current] + next.cost;
                    pq.offer(new Node2(next.end,  dist[current], fee[current]));
                }
            }
        }
    }
}
