package com.coding.kakao2021.blind;

import java.util.*;

/*
 * @2021 kakao blind recruitment
 * @TestName: 합승 택시 요금
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/72413
 * @COMMENT: 다익스트라 알고리즘으로 푼 Jong-DO님의 코드 공부하기
 */
class Edge implements Comparable<Edge>{
    int next;
    int cost;
    Edge(int next, int cost){
        this.next = next;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge e){
        return this.cost - e.cost;
    }
}
public class Test4Dijk {
    static ArrayList<ArrayList<Edge>> graph;
    private static void dijkstra(int start, int[] costs){
        PriorityQueue<Edge> pq = new PriorityQueue<>(graph.get(start));
        for(Edge e : graph.get(start)) costs[e.next] = e.cost;
        costs[start] = 0;
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            if(costs[e.next] < e.cost) continue;
            for(Edge ne : graph.get(e.next)){
                if(costs[ne.next] > e.cost + ne.cost){
                    costs[ne.next] = e.cost + ne.cost;
                    pq.add(new Edge(ne.next, e.cost + ne.cost));
                }
            }
        }
    }

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i ++) graph.add(new ArrayList<>());
        for(int[] i : fares){
            graph.get(i[0] - 1).add(new Edge(i[1] - 1, i[2]));
            graph.get(i[1] - 1).add(new Edge(i[0] - 1, i[2]));
        }
        int[] startA = new int[n];
        int[] startB = new int[n];
        int[] start = new int[n];

        Arrays.fill(startA, Integer.MAX_VALUE);
        Arrays.fill(startB, Integer.MAX_VALUE);
        Arrays.fill(start, Integer.MAX_VALUE);

        dijkstra(a - 1, startA);
        dijkstra(b - 1, startB);
        dijkstra(s - 1, start);

        for(int i = 0 ; i < n ; i ++) answer = Math.min(answer, startA[i] + startB[i] + start[i]);
        return answer;
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
