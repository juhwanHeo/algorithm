package com.programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @level3
 * @TestName: 여행경로
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/43164
 * @COMMENT: DFS + Back-Tracking 참고 https://iseunghan.tistory.com/241
 */
public class TravelRoute {
    static List<String> list;
    static boolean[] visited;
    static String[] answer = {};

    public static String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        list = new ArrayList<>();

        Arrays.sort(tickets, (t1, t2) -> {
            if(t1[0].equals(t2[0])) return t1[1].compareTo(t2[1]);
            else return t1[0].compareTo(t2[0]);
        });

        list.add("ICN");
        dfs(tickets, "ICN", 0);
        return answer;
    }

    private static void dfs(String[][] tickets, String start, int depth) {
        if (answer.length > 0) return;

        if (depth == tickets.length) {
            answer = list.stream()
                    .map(String::valueOf)
                    .toArray(String[]::new);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                list.add(tickets[i][1]);
                dfs(tickets, tickets[i][1], depth + 1);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        String[][] tickets1 = {
                {"ICN", "JFK"},
                {"HND", "IAD"},
                {"JFK", "HND"}
        };
        String[] res1 = {"ICN", "JFK", "HND", "IAD"};

        System.out.println(Arrays.toString(solution(tickets1)));
    }

}
