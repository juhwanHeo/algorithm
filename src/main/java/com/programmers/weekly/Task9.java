package com.programmers.weekly;

import java.util.*;

/*
 * @Weekly 9
 * @TestName: 전력망을 둘로 나누기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/86971
 */
public class Task9 {
    static int[][] map;
    static boolean[] visited;
    static List<Integer>[] adj;
    static int[] childNum;

    public static int solution(int n, int[][] wires) {
        visited = new boolean[n + 1];
        childNum = new int[n + 1];
//        map = new int[n + 1][n + 1];
        adj = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) adj[i] = new ArrayList<>();
        Arrays.fill(childNum, -1);

        for (int[] wire : wires) {
            adj[wire[0]].add(wire[1]);
            adj[wire[1]].add(wire[0]);

//            map[wire[0]][wire[1]] = 1;
//            map[wire[1]][wire[0]] = 1;
        }

        bfs(1);
        childCount(1);

        System.out.println(Arrays.toString(childNum));

        return Arrays.stream(childNum)
                .filter(val -> val != -1)
                .map(val -> Math.abs(n - 2 * (val + 1)))
                .min()
                .orElse(Integer.MAX_VALUE);
    }

    private static int childCount(int start) {
        if (childNum[start] != -1) return childNum[start];
        int count = adj[start].size();

        for (int child : adj[start]) {
            count += childCount(child);
        }

        childNum[start] = count;
        return count;
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            Integer val = q.poll();
            for (Integer newVal : adj[val]) {
                q.offer(newVal);
                adj[newVal].remove(val);
            }
        }
    }

    private static void bfsFormat(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            Integer val = q.poll();
            System.out.println(val + " ");
            for (Integer newVal : adj[val]) {
                if (!visited[newVal]) {
                    q.offer(newVal);
                    visited[newVal] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int n1 = 9;
        int n2 = 4;
        int[][] wires = {
                {1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9} //3
        };

        System.out.println(solution(n1, wires));
    }
}
