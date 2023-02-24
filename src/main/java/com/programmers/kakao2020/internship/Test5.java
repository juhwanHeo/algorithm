package com.programmers.kakao2020.internship;

import java.util.*;
/*
 *
 * 효율성 테스트 9, 10 해결 x
 */

/*
 * @2020 kakao internship
 * @TestName: 동굴 탐험
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/67260
 * @COMMENT: 효율성 테스트 9, 10 해결 x
 */
public class Test5 {
    static List<Integer>[] adjList;
    static List<Integer>[] directAdjList;
    static boolean[] visited;
    static boolean[] finished;
    static boolean answer;

    public static boolean solution(int n, int[][] path, int[][] order) {
        adjList = new List[n + 1];
        directAdjList = new List[n + 1];
        answer = true;

        for (int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
            directAdjList[i] = new ArrayList<>();
        }

        // 양방향 그래프 생성
        for (int[] p : path) {
            int start = p[0];
            int end = p[1];
            adjList[start].add(end);
            adjList[end].add(start);
        }

        // dfs로 단방향 그래프 생성
        dfs(n);

        System.out.println("directAdjList: " + Arrays.deepToString(directAdjList));
        for (int[] o : order) {
            int start = o[0];
            int end = o[1];
            directAdjList[start].add(end);
        }

        finished = new boolean[n + 1];
        visited = new boolean[n + 1];
//        for (int i = 0; i < n; i++) {
//            if (!answer) break;
//            if (!visited[i]) checkCycle(i);
//        }

        System.out.println("adjList: " + Arrays.deepToString(adjList));
        System.out.println("directAdjList: " + Arrays.deepToString(directAdjList));
        System.out.println("visited: " + Arrays.toString(visited));
        System.out.println("finished: " + Arrays.toString(finished));
        System.out.println();
        return !checkCycle();
    }

    static void dfs(int n) {
        visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        visited[0] = true;
        while (!stack.isEmpty()) {
            int current = stack.pop();
            for (int next : adjList[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    directAdjList[current].add(next);
                    stack.push(next);
                }
            }
        }
    }

    static boolean checkCycle() {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int current = stack.peek();

            if (!visited[current]) {
                visited[current] = true;
                finished[current] = true;
            } else {
                finished[current] = false;
                stack.pop();
            }

            for (int next : directAdjList[current]) {
                if (!visited[next]) stack.push(next);
                else if (finished[next]) {
                    return true;
                }
            }
        }
        return false;
    }


    static void checkCycle(int current) {
        if (!answer) return;
        visited[current] = true;

        for (int next : directAdjList[current]) {
            if (!visited[next]) checkCycle(next);
            else if (!finished[next]) answer = false;
        }

        finished[current] = true;
    }
}

