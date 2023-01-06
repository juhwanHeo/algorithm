package com.programmers.level3;

import com.coding.utils.PrintUtils;

import java.util.*;

/*
 * @level3
 * @TestName: 등대
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/133500
 */
public class Lighthouse {

    static List<List<Integer>> adj;

    static Set<Integer> root;
//    static boolean[] lighted;
    static int[] visited;

    static int solution(int n, int[][] lighthouse) {
//        int answer = n / 2;
        int answer = 0;
//        lighted = new boolean[n + 1];
        visited = new int[n + 1];
        adj = new ArrayList<>();
//        root = new HashSet<>();

        for (int i = 0; i < n + 1; i++) adj.add(new ArrayList<>());

        for (int[] light : lighthouse) {
            int start = light[0];
            int end = light[1];

            adj.get(start).add(end);
            adj.get(end).add(start);
        }

        for (int i = 1; i < adj.size(); i++) {
            System.out.println(i + ": " + adj.get(i));
        }

//        root = new HashSet<>();
//        dfs(1);
//        System.out.println("root: " + root);
//        return Math.min(answer, root.size());
//        int[] visit = new int[n + 1];
        dfs(1);
        for (int v : visited) {
            if (v == 2) answer++;
        }
        return answer;
    }


    static void dfs(int node) {
        visited[node] = 1;
        for (Integer next : adj.get(node)) {
            System.out.println("node: " + node + ", next: " + next + ", visit node: " + visited[node] + ", visit next: " + visited[next]);
            if (visited[next] == 0) {
                dfs(next);
                if (visited[next] == 1) visited[node] = 2;
            }
        }
    }

//    static void dfs2(int node) {
//        lighted[node] = true;
//
//        for (Integer nextNode : adj.get(node)) {
//            if (!lighted[nextNode]){
//                dfs(nextNode);
////                if (lighted[nextNode]) ;
//            }
//        }
//
//    }
}
