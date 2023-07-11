package com.programmers.level1;

/*
 * @level1
 * @TestName: 옹알이 (2)
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/133499
 * @COMMENT: 문자열 완탐 (중복은 허용이지만, 연속된 문자열은 허용 안됨)
 */
public class Babbling2 {

    static int answer;
    static String[] words = {"aya", "ye", "woo", "ma"};
    static int solution(String[] babbling) {
        answer = 0;

        for (String s : babbling) {
            StringBuilder sb = new StringBuilder();
            dfs(s, sb, s.length());
        }

        return answer;
    }

    static void dfs(String goal, StringBuilder current, int depth) {
        if (depth <= 0) {
            if (goal.equals(current.toString())) {
                answer++;
            }
            return;
        }

        for (String word : words) {
            String subString = current.substring(Math.max(current.length()  - word.length(), 0), Math.max(current.length(), 0));
            System.out.println("goal: " + goal + ", current: " + current + ", word: " + word + ", subString: " + subString);
            if (goal.contains(word) && !subString.equals(word)) {
                int currentLength = current.length();
                current.append(word);
                dfs(goal, current, depth - word.length());
                current.delete(currentLength, current.length());
            }
        }
    }
}
