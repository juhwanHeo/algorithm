package com.programmers.kakao2017.finalround;

import com.coding.utils.MakeGraph;
import com.coding.utils.PrintUtils;

import java.util.Arrays;
import java.util.List;

/*
 * @2017 카카오코드 본선
 * @TestName: GPS
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/1837
 */
public class GPS {

    private static final int INF = 10001;
    public static int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int dp[][] = new int[k][n + 1];
        List<List<Integer>> adj = MakeGraph.makeAdjTwoWay(edge_list, n);

        for (int[] array : dp) Arrays.fill(array, INF);

        dp[0][gps_log[0]] = 0;
        PrintUtils.printArray(dp);

        for (int i = 1; i < k; i++) {
            for (int j = 1; j < n + 1; j++) {

                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);

                for (int node : adj.get(j)) {
                    dp[i][j] = Math.min(dp[i - 1][node], dp[i][j]);
                }

                dp[i][j] += (gps_log[i] == j) ? 0 : 1;
                PrintUtils.printArray(dp);
            }
        }
        return dp[k - 1][gps_log[k - 1]] >= INF ? -1 : dp[k - 1][gps_log[k - 1]];
    }

    public static void main(String[] args) {
        int n = 7;
        int m = 10;
        int[][] edgeList = {
                {1, 2},
                {1, 3},
                {2, 3},
                {2, 4},
                {3, 4},
                {3, 5},
                {4, 6},
                {5, 6},
                {5, 7},
                {6, 7}
        };
        int k = 6;
        int[] gpsLog = {
                1, 2, 3, 3, 6, 7
        };

        System.out.println(solution(n, m, edgeList, k, gpsLog));

    }
}

