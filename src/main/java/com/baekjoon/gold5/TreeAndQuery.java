package com.baekjoon.gold5;

import com.coding.utils.MakeGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * @Gold5
 * @TestName: 트리와 쿼리
 * @URL: https://www.acmicpc.net/problem/15681
 */
public class TreeAndQuery {

    private static List<List<Integer>> adj = new ArrayList<>();
    private static List<List<Integer>> tree = new ArrayList<>();
    private static int[] dp, size;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int edgeN = Integer.parseInt(stk.nextToken());
        int root = Integer.parseInt(stk.nextToken());
        int queryN = Integer.parseInt(stk.nextToken());
        int[][] edges = new int[edgeN][2];
        adj = new ArrayList<>();
        tree = new ArrayList<>();


        for (int i = 0; i < edgeN - 1; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            edges[i] = new int[] {start, end};
        }

        for (int i = 0; i <= edgeN; i++) {
            adj.add(new ArrayList<>());
            tree.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];

            adj.get(start).add(end);
            adj.get(end).add(start);
        }

//        adj = MakeGraph.makeAdjTwoWay(edge, edgeN);
        dp = new int[edgeN + 1];
        visited = new boolean[edgeN + 1];
        size = new int[edgeN + 1];

//        makeTree(root, -1);
//        countSubtreeNodes(root);
        dfs(root);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < queryN; i++) {
            int query = Integer.parseInt(br.readLine());
            sb.append(dp[query]).append("\n");
        }

        System.out.println(sb);
    }

    /*
        def makeTree(currentNode, parent) :
            for(Node in connect[currentNode]) :
                if Node != parent:
                    add Node to currentNode’s child
                    set Node’s parent to currentNode
                    makeTree(Node, currentNode)
    */
    private static void makeTree(int start, int parent) {
        for (int node : adj.get(start)) {
            if (node != parent) {
                tree.get(start).add(node);
                dp[node] = start;
                makeTree(node, start);
            }

        }
    }

    /*
        def countSubtreeNodes(currentNode) :
            size[currentNode] = 1 // 자신도 자신을 루트로 하는 서브트리에 포함되므로 0이 아닌 1에서 시작한다.
            for Node in currentNode’s child:
                countSubtreeNode(Node)
                size[currentNode] += size[Node]
    */

    private static void countSubtreeNodes(int start) {
        size[start] = 1;
        for (int node : tree.get(start)) {
            countSubtreeNodes(node);
            size[start] += size[node];
        }
    }

    private static int dfs(int start) {
        if (dp[start] != 0) return dp[start];

        int cnt = 1;
        visited[start] = true;

        for (int node : adj.get(start)) {
            if (visited[node]) continue;
            cnt += dfs(node);
        }

        dp[start] = cnt;
        return dp[start];
    }
}
