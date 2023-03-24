package com.programmers.weekly;

import java.util.ArrayList;
import java.util.List;

/*
 * @Weekly 5
 * @TestName: 모음 사전
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/84512
 */
public class Task5 {

    static final String[] words = {"A", "E", "I", "O", "U"};

    // dfs 처음만 list에 값 저장
    static List<String> list = new ArrayList<>();
    public static int solution(String word) {
        int answer = 0;
//        List<String> list = new ArrayList<>();
        if (list.size() == 0) {
            System.out.println("### run dfs ");
            for (String s : words) {
                StringBuilder sb = new StringBuilder();
                sb.append(s);
                dfs(list, sb, 0);
            }
            System.out.println(list.size());
            System.out.println(list);
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word)) {
                answer = i + 1;
                break;
            }
        }

        return answer;
    }

    static void dfs(List<String> list, StringBuilder sb, int depth) {
        if (!list.contains(sb.toString())) list.add(sb.toString());
        if (sb.length() == 5) return;

        for (String word : words) {
            if (sb.length() < 5) {
                sb.append(word);
                dfs(list, sb, depth + 1);
                sb.delete(depth + 1, 5);
            }
        }
    }
}
