package com.baekjoon.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * @Gold5
 * @TestName: 트리
 * @URL: https://www.acmicpc.net/problem/1068
 */
public class Tree {

    static List<List<Integer>> adj;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(br.readLine());

        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) adj.add(new ArrayList<>());

        int start = 0;
        for (int i = 0; i < N; i++) {
            int data = Integer.parseInt(stk.nextToken());
            if (data != -1) {
                adj.get(data).add(i);
            }
            else start = i;
        }

        System.out.println();
        System.out.println(adj);
        adj.get(R).clear();
        System.out.println(adj);
        dfs(start, R);

        if (start == R) System.out.println(0);
        else if (R != 0 && count == 0) System.out.println(1);
        else System.out.println(count);
    }

    private static void dfs(int node, int remove) {
        if (node == remove) return;
        if (adj.get(node).isEmpty() || (adj.get(node).size() == 1 && adj.get(node).get(0) == remove)) count++;
        for (Integer next : adj.get(node)) {
            if (next == remove) {
                continue;
            }
            dfs(next, remove);
        }
    }
}
/*

     3
    0 6
   4  125

7
3 6 6 -1 0 6 3
4
--> 4
* */
