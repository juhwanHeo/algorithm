package com.programmers.kakao2022.blind;

import java.util.ArrayList;
import java.util.List;

/*
 * @2022 KAKAO BLIND RECRUITM합NT
 * @TestName: 양과 늑대
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/92343
 */
public class SheepWolf {

    static List<List<Integer>> list;
    static int answer = 0;
    public static int solution(int[] info, int[][] edges) {
        list = new ArrayList<>();
        for (int i = 0; i < info.length; i++) list.add(new ArrayList<>());
        for (int[] edge : edges) list.get(edge[0]).add(edge[1]);

        System.out.println(list);

        dfs(0, 0, 0, info, new ArrayList<>());

        return answer;
    }

    private static void dfs(int node, int sheep, int wolf, int[] info, List<Integer> lst) {
        if (info[node] == 0) sheep++;
        else wolf++;
        System.out.println(node + " node, " + " info: "+ info[node] + ", sheep: " + sheep + ", wolf: " + wolf);

        answer = Math.max(sheep, answer);
        if (wolf >= sheep) return;

        List<Integer> child = new ArrayList<>(lst);
        if (! list.get(node).isEmpty())
            child.addAll(list.get(node));
        child.remove(Integer.valueOf(node));

        System.out.println("child = " + child);

        for (int val : child) {
            dfs(val, sheep, wolf, info, child);
        }
    }

    public static void main(String[] args) {
        int[] info = {
                0, 0, 1,1,1,0,1,0,1,0,1,1
        };
        int[][] edge = {
                {0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9} // 5
        };

        System.out.println(solution(info, edge));
    }

}
