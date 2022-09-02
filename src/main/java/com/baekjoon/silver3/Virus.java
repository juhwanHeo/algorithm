package com.baekjoon.silver3;

import com.coding.utils.PrintUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * @Silver3
 * @TestName: 바이러스
 * @URL: https://www.acmicpc.net/problem/2606
 */
public class Virus {

    static List<List<Integer>> adj;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int line = Integer.parseInt(br.readLine());

        adj = new ArrayList<>();
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < line; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());

            adj.get(start).add(end);
            adj.get(end).add(start);
        }

        System.out.println(adj);
        PrintUtils.printArray(visited);
        System.out.println((bfs(1) - 1));
    }

    private static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            count++;
            int node = queue.poll();
            for (int next : adj.get(node)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

        return count;
    }
}
/*
7
6
1 2
2 3
1 5
5 2
5 6
4 7
-- 4

10
7
1 2
2 3
3 4
5 6
7 8
8 9
9 1
-- 6
*/