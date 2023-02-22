package com.programmers.kakao2020.internship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
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
        adjList = new List[n];
        directAdjList = new List[n];
        finished = new boolean[n];
        answer = true;

        for (int i = 0; i < n ; i++) {
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
            directAdjList[end].add(start);
        }

        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(!answer) break;
            if(!visited[i]) checkCycle(i);
        }

        System.out.println("adjList: " + Arrays.deepToString(adjList));
        System.out.println("directAdjList: " + Arrays.deepToString(directAdjList));
        System.out.println("visited: " + Arrays.toString(visited));
        System.out.println("finished: " + Arrays.toString(finished));
        System.out.println();
        return answer;
    }

    static void dfs(int n){
        visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while(!stack.isEmpty()) {
            int current = stack.pop();
            visited[current] = true;

            for (int i = 0; i < adjList[current].size(); i++) {
                int next = adjList[current].get(i);
                if (!visited[next]) {
                    directAdjList[next].add(current);
                    stack.push(next);
                }
            }
        }
    }

    static void checkCycle(int here) {
        if(!answer) return;
        visited[here] = true;
        for (int i = 0; i < directAdjList[here].size(); i++) {
            int there = directAdjList[here].get(i);

            if (!visited[there]) checkCycle(there);
            else if (!finished[there]) {
                answer = false;
                return;
            }
        }
        finished[here] = true;
    }
}

