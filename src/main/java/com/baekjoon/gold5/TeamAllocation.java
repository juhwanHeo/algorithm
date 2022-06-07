package com.baekjoon.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * @Gold5
 * @TestName: 팀 배분
 * @URL: https://www.acmicpc.net/problem/1953
 */
public class TeamAllocation {

    static List<Integer> teamA, teamB;
    static List<List<Integer>> adj;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        adj = new ArrayList<>();
        teamA = new ArrayList<>();
        teamB = new ArrayList<>();

        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            int count = Integer.parseInt(stk.nextToken());
            for (int j = 0; j < count; j++) {
                int end = Integer.parseInt(stk.nextToken());
                adj.get(i + 1).add(end);
            }
        }

        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                teamA.add(i);
                dfs(i, 1);
            }
        }

        if (teamB.isEmpty()) {
            teamA.remove(1);
            teamB.add(1);
        }

        Collections.sort(teamA);
        Collections.sort(teamB);

        StringBuilder sb = new StringBuilder();
        sb.append(teamA.size()).append('\n');

        for (int data : teamA) sb.append(data).append(' ');
        sb.append('\n');

        sb.append(teamB.size()).append('\n');
        for (int data : teamB) sb.append(data).append(' ');

        System.out.println(sb);
    }

    /*
    * 싫어하는 사람을 다른 팀으로 배정
    * */
    private static void dfs(int start, int team) {
        // teamA
        if (team == 1) {
            for (int next : adj.get(start)) {
                if (!visited[next]){
                    visited[next] = true;
                    teamB.add(next);
                    dfs(next, 0);
                }
            }
        }
        // teamB
        else {
            for (int next : adj.get(start)) {
                if (!visited[next]){
                    visited[next] = true;
                    teamA.add(next);
                    dfs(next, 1);
                }
            }
        }
    }
}
