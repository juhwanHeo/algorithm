package com.programmers.kakao2022.insternship;

import com.coding.utils.Node;

import java.util.*;

/*
 * @2022 KAKAO Tech Internship
 * @TestName: 등산코스 정하기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/118669
 * @COMMENT: 다익스트라
 */
public class DecidingHikingCourse {

    private static final int CODE_DOORWAY = -1;
    private static final int CODE_PEAK = -2;

    private static List<List<Node>> adj;
    private static int[] dist;
    private static int[] infos;
    public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {Integer.MIN_VALUE, Integer.MAX_VALUE};
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        dist = new int[n + 1];
        infos = new int[n + 1];

        // 출입구
        for (int gate : gates) infos[gate] = CODE_DOORWAY;

        // 봉우리
        for (int summit : summits) infos[summit] = CODE_PEAK;

        for (int[] path : paths) {
            int start = path[0];
            int end = path[1];
            int cost = path[2];

            if (infos[start] == CODE_DOORWAY || infos[end] == CODE_PEAK) adj.get(start).add(new Node(end, cost));
            else if (infos[start] == CODE_PEAK || infos[end] == CODE_DOORWAY) adj.get(end).add(new Node(start, cost));
            else {
                adj.get(start).add(new Node(end, cost));
                adj.get(end).add(new Node(start, cost));
            }
        }

        dijkstra();
        System.out.println("dist: " + Arrays.toString(dist));
        Arrays.sort(summits);
        for (int summit : summits) {
            System.out.println("summit = " + summit);
            System.out.println("dist[summit] = " + dist[summit]);
            System.out.println("answer[1] = " + answer[1] + '\n');
            if (dist[summit] < answer[1])  {
                answer[0] = summit;
                answer[1] = Math.min(answer[1], dist[summit]);
            }
        }

        return answer;
    }


    private static void dijkstra() {
        Queue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i < infos.length; i++) {
            if (infos[i] == CODE_DOORWAY) {
                pq.offer(new Node(i, 0));
                dist[i] = 0;
            }
        }

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int current = node.end;

            if(dist[current] < node.cost) continue;
            adj.get(current).forEach(next -> {
                if (dist[next.end] > Math.max(dist[current], next.cost)) {
                    dist[next.end] = Math.max(dist[current], next.cost);
                    pq.offer(next);
                }
            });
        }
    }
}
