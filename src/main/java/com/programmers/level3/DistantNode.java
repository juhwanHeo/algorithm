package com.programmers.level3;

import java.util.*;

/*
 * @level3
 * @TestName: 가장 먼 노드
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/49189
 * @COMMENT: bfs로 풀이 변경해서 해결
 */
public class DistantNode {

    static List<List<Integer>> adj;
    static int[] dist;
    static boolean[] visited;
    public static int solution(int n, int[][] edge) {
        adj = new ArrayList<>();
        dist = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int[] data : edge) {
            adj.get(data[0]).add(data[1]);
            adj.get(data[1]).add(data[0]);
        }

        System.out.println(adj);

        bfs(1);


        int max = Arrays.stream(dist)
                .filter(val -> val <= n)
                .max()
                .orElse(-1);

        return (int) Arrays.stream(dist)
                .filter(val ->val == max)
                .count();
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            for (Integer newIndex : adj.get(node)) {
                if (!visited[newIndex]) {
                    visited[newIndex] = true;
                    dist[newIndex] = dist[node] + 1;

                    System.out.println(Arrays.toString(dist));
                    q.offer(newIndex);
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

//        int n2 = 6;
//        int[][] vertex2 = {
//                {3, 6},
//                {4, 3},
//                {3, 2},
//                {1, 2},
//                {2, 4},
//                {5, 2}
//        };
//
//
//        int n3 = 5;
//        int[][] vertex3 = {
//                {1, 2},
//                {1, 3},
//                {4, 5},
//        };
        int res = 3;
        int myRes = solution(n, vertex);
        System.out.println(myRes);
        System.out.println(myRes == res);
    }

}
