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
    static boolean answer = true;

    public boolean solution(int n, int[][] path, int[][] order) {
        adjList = new List[n];
        directAdjList = new List[n];
        finished = new boolean[n];

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

    void checkCycle(int here) {
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

    /*
    * 재귀 dfs 사용시 효율성테스트 탈락
    * stack을 사용한 dfs로 변경
    * dfs(0, -1);
    */
//    void dfs(int here, int before){
//        for (int i = 0; i < adjList[here].size(); i++) {
//            int there = adjList[here].get(i);
//            if(there == before) continue;
//
//            directAdjList[there].add(here);
//            dfs(there, here);
//        }
//    }

    void dfs(int n){
        visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while(!stack.isEmpty()) {
            int val = stack.pop();
            if(visited[val]) continue;
            else {
                visited[val] = true;
                for (int i = 0; i < adjList[val].size(); i++) {
                    int there = adjList[val].get(i);
                    if (!visited[there]) {
                        directAdjList[there].add(val);
                        stack.push(there);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        int[][] path1 = {{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}};
        int[][] order1 = {{8,5}, {6,7}, {4,1}};
        boolean answer1 = new Test5().solution(9, path1, order1);

        int[][] path2 = {{8,1},{0,1},{1,2},{0,7},{4,7},{0,3},{7,5},{3,6}};
        int[][] order2 = {{4,1},{5,2}};
        boolean answer2 = new Test5().solution(9, path2, order2);

        int[][] path3 = {{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}};
        int[][] order3 = {{4,1},{8,7},{6,5}};
        boolean answer3 = new Test5().solution(9, path3, order3);

        System.out.println("answer1: " + answer1);
        System.out.println("res1: " + true);

        System.out.println("answer2: " + answer2);
        System.out.println("res2: " + true);

        System.out.println("answer3: " + answer3);
        System.out.println("res3: " + false);
    }
}

