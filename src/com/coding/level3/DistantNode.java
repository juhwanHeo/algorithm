package com.coding.level3;

import java.util.*;

/*
 * @level3
 * @TestName: 가장 먼 노드
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/49189
 * @COMMENT: 11개 테케 중 3개 정답
 */
class Node implements Comparable<Node>{
    int end;
    int weight;

    Node(int end) {
        this.end = end;
        this.weight = 1;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.weight, o.weight);
    }

    @Override
    public String toString() {
        return "(" + end + ")";
    }
}
public class DistantNode {

    static List<Node>[] adj;
    static boolean[] check;
    static int[] dist;
    public static int solution(int n, int[][] edge) {
        adj = new ArrayList[n+1];
        check = new boolean[n+1];
        dist = new int[n+1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] ints : edge) {
            int start = ints[0];
            int end = ints[1];
            // 무방향 그래프
            adj[start].add(new Node(end));
            adj[end].add(new Node(start));
        }

        dijkstra(1);
        System.out.println(Arrays.toString(dist));
        int max = Arrays.stream(dist)
                .filter(val -> val <= n)
                .max()
                .orElse(Integer.MIN_VALUE);
        return (int) Arrays.stream(dist)
                .filter(val ->val == max)
                .count();
    }

    public static void dijkstra(int first){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        queue.add(new Node(first));
        dist[first] = 0;
        while (!queue.isEmpty()) {
            Node edge = queue.poll();
            int end = edge.end;
            if(check[end]) continue;
            else check[end] = true;
            for (Node next : adj[end]) {
                if (dist[next.end] >= dist[end] + next.weight) {
                    dist[next.end] = dist[end] + next.weight;
                    queue.add(new Node(next.end));
                }
            }
        }
    }
    public static void main(String[] args) {
        int n = 6;
        int[][] vertex = {
                {3, 6},
                {4, 3},
                {3, 2},
                {1, 3},
                {1, 2},
                {2, 4},
                {5, 2}
        };

        int n2 = 6;
        int[][] vertex2 = {
                {3, 6},
                {4, 3},
                {3, 2},
                {1, 2},
                {2, 4},
                {5, 2}
        };


        int n3 = 5;
        int[][] vertex3 = {
                {1, 2},
                {1, 3},
                {4, 5},
        };
        int res = 3;
        int myRes = solution(n, vertex);
        int myRes2 = solution(n2, vertex2);
        int myRes3 = solution(n3, vertex3);
        System.out.println(myRes);
        System.out.println(myRes == res);

        System.out.println(myRes2);
        System.out.println(myRes3);
    }

}
