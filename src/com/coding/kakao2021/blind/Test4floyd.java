package com.coding.kakao2021.blind;

/*
 * @2021 kakao blind recruitment
 * @TestName: 합승 택시 요금
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/72413
 * @COMMENT: floyd알고리즘 공부하기
 */
public class Test4floyd {
    static int[][] dist;
    public static int solution(int n, int s, int a, int b, int[][] fares) {
        dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) dist[i][k] = 100000001;
            dist[i][i] = 0;
        }

        // 무방향 그래프
        for (int[] fare : fares) {
            dist[fare[0] - 1][fare[1] - 1] = fare[2];
            dist[fare[1] - 1][fare[0] - 1] = fare[2];
        }

        floyd(n, dist);
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int cur = dist[s-1][i] + dist[i][a-1] + dist[i][b-1];

            if(answer >= cur) answer = cur;
        }

        return answer;
    }

    public static void floyd(int n, int[][] dist) {
        for(int k = 0; k < n; k++) {
            for(int i=0; i < n; i++) {
                if(i==k) continue;
                for(int j=0; j < n; j++) {
                    if(j==k || i==j) continue;
                    dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n1 = 6;
        int s1 = 4;
        int a1 = 6;
        int b1 = 2;
        int[][] vertex = {
                {4, 1, 10},
                {3, 5, 24},
                {5, 6, 2},
                {3, 1, 41},
                {5, 1, 24},
                {4, 6, 50},
                {2, 4, 66},
                {2, 3, 22},
                {1, 6, 25}
        };

        int res = 82;
        int myRes = solution(n1, s1, a1, b1 , vertex);
        System.out.println(myRes);
        System.out.println(myRes == res);

    }

}
