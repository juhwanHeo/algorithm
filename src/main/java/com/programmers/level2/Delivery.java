package com.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
 * @level2
 * @TestName: 배달
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12978
 */
public class Delivery {

    static class Node implements Comparable<Node>{
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node) {
            return weight - node.weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "end=" + end +
                    ", weight=" + weight +
                    '}';
        }
    }

    static List<List<Node>> adj;
    static int[] dist;
    public static int solution(int N, int[][] road, int K) {
        adj = new ArrayList<>();
        dist = new int[N + 1];
        for (int i = 0; i <= N; i++)  adj.add(new ArrayList<>());

        for (int[] ints : road) {
            int start = ints[0];
            int end = ints[1];
            int weight = ints[2];

            adj.get(start).add(new Node(end, weight));
            adj.get(end).add(new Node(start, weight));
        }
        System.out.println(adj);

        dijkstra(1);

        System.out.println("Arrays.toString(dist) = " + Arrays.toString(dist));

        return (int) Arrays.stream(dist)
                .filter(value -> value <= K)
                .count();
    }

    public static void dijkstra(int first){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        queue.add(new Node(first, 0));
        dist[first] = 0;

        while (!queue.isEmpty()) {
            Node edge = queue.poll();
            int end = edge.end;

            for (Node next : adj.get(end)) {
                if (dist[next.end] >= dist[end] + next.weight) {
                    dist[next.end] = dist[end] + next.weight;
                    queue.add(new Node(next.end, next.weight));
                }
            }
        }
    }


    public static void main(String[] args) {
        int n1 = 5;
        int k1 = 3;
        int[][] road1 = {
                {1,2,1},
                {2,3,3},
                {5,2,2},
                {1,4,2},
                {5,3,1},
                {5,4,2}
        }; // 4

        int[][] road2 = new int[][] {
                {1, 2, 4}, {1, 3, 1}, {3, 4, 1}, {4, 2, 1}, {2, 5, 1}
        }; // 5

//        System.out.println("solution() = " + solution(n1, road1, k1));
        System.out.println(solution(5, road2, 4));
    }

}
