package com.programmers.level3;

import com.coding.utils.PrintUtils;

import java.util.*;

/*
 * @level3
 * @TestName: 섬 연결하기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/42861
 */
public class ConnectingIslands {
    static int[] parent;
    public static int solution(int n, int[][] costs) {
        int answer = 0;

        Arrays.sort(costs, (int[] a1, int[] a2) -> a1[2] - a2[2]);
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        PrintUtils.printArray(parent);
        for (int[] cost : costs) {
            int start = cost[0];
            int end = cost[1];
            int weight = cost[2];

            int startParent = find(start);
            int endParent = find(end);

            System.out.println("startParent: " + startParent);
            System.out.println("endParent: " + endParent);
            if (startParent == endParent) continue;

            answer += weight;
            parent[endParent] = startParent;
            PrintUtils.printArray(parent);
        }

        return answer;
    }


    static int find(int node) {
        if (parent[node] == node) return node;
        return parent[node] = find(parent[node]);
    }
}