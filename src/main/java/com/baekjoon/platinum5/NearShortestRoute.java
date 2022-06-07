package com.baekjoon.platinum5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * @Platinum5
 * @TestName: 거의 최단 경로
 * @URL: https://www.acmicpc.net/problem/5719
 * @COMMENT: Stack 으로 최단 경로들 지운 다음
 * 다음 최단 경로를 하나씩 구하는 방식으로 했다가 메모리 초과가 발생하여
 * 각각의 노드가 어디서 왓는지 저장하고, 백트래킹을 통해 제거해 주어 해결
 */
public class NearShortestRoute {

    private static class Node implements Comparable<Node>{
        int end;
        int weight;

        public Node(int next, int weight) {
            this.end = next;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(weight, o.weight);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "end=" + end +
                    ", weight=" + weight +
                    '}';
        }
    }

//    static int parent[];
    static List<List<Node>> adj;
    static List<Integer>[] path;
    static int[] dist;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(stk.nextToken());
            int M = Integer.parseInt(stk.nextToken());
            if (N == 0 && M == 0) break;

            stk = new StringTokenizer(br.readLine(), " ");
            int S = Integer.parseInt(stk.nextToken());
            int D = Integer.parseInt(stk.nextToken());

            path = new ArrayList[N];
            adj = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                adj.add(new ArrayList<>());
                path[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                stk = new StringTokenizer(br.readLine(), " ");

                int start = Integer.parseInt(stk.nextToken());
                int end = Integer.parseInt(stk.nextToken());
                int cost = Integer.parseInt(stk.nextToken());
                adj.get(start).add(new Node(end, cost));
            }

//            int cnt = 0;
//            int minCost = getCost(N, S, D);
//            int nextCost = minCost;
//            while (minCost == nextCost) {
//                if (cnt++ == N + 1) {
//                    nextCost = -1;
//                    break;
//                }
//                nextCost = getCost(N, S, D);
//            }
//

            visited = new boolean[N][N];
            dist = new int[N];
            dijkstra(S);
            removePath(S, D);
            dijkstra(S);


            sb.append(dist[D] == Integer.MAX_VALUE ? -1 : dist[D]).append('\n');
        }

        System.out.println(sb);
    }
    
    private static void removePath(int S, int D) {
        if (S == D) return;
        for (int remove : path[D]) {
            if (!visited[remove][D]) {
                visited[remove][D] = true;
                removePath(S, remove);
            }
        }
    }

    private static void dijkstra(int start){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int current = node.end;

            for (Node next : adj.get(current)) {
                if (visited[current][next.end]) continue;
                if (dist[next.end] == dist[current] + next.weight) {
                    path[next.end].add(current);
                }
                else if (dist[next.end] > dist[current] + next.weight) {
                    dist[next.end] = dist[current] + next.weight;
                    path[next.end].clear();
                    path[next.end].add(current);
                    queue.add(new Node(next.end, next.weight));
                }
                for (List<Integer> list : path) {
                    System.out.println(list);
                }
                System.out.println("==========\n");
            }
        }

    }


//    private static int getCost(int N, int S, int D) {
//        dist = new int[N + 1];
//        parent = new int[N + 1];
//        dijkstra(S);
//        adj.forEach(System.out::println);
//
//        Stack<Integer> stack = searchPath(S, D);
//        StringBuilder sb = new StringBuilder();
//        while (stack.size() > 1) {
//            int node = stack.pop();
//            visited[node][stack.peek()] = true;
//            adj.get(node).removeIf(n -> n.end == stack.peek());
//            sb.append(node).append(" ");
//        }
//
//        System.out.println("sb = " + sb);
//        System.out.println("dist[D] = " + dist[D]);
//        PrintUtils.printArray1(dist);
//        return dist[D];
//    }
//
//    private static Stack<Integer> searchPath(int start, int end){
//        Stack<Integer> stack = new Stack<>();
//        int cur = end;
//
//        while(cur != start) {
//            stack.push(cur);
//
//            cur = parent[cur];
//        }
//        stack.push(cur);
//
//        return stack;
//    }

}
