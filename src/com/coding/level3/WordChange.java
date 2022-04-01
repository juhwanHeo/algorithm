package com.coding.level3;

/*
 * @level3
 * @TestName: 단어 변환
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/43163
 */
public class WordChange {

    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    static int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        dfs(begin, target, words, 0);

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    /*
    * 모든 경우 탐색
    * 방문 순서에 따라 비용이 달라짐
    * --> 백트래킹
    */
    static void dfs(String word, String target, String[] words, int depth) {
        System.out.println("word = " + word + ", depth = " + depth + ", answer = " + answer);
        if (word.equals(target)) {
            answer = Math.min(answer, depth);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && isOk(word, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, depth + 1);
                visited[i] = false;
            }
        }

        System.out.println("=============================\n");
    }

    private static boolean isOk(String word, String target) {
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == target.charAt(i)) count++;
        }

        return count == word.length() - 1;
    }

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";

        String[] words = {
                "hot", "dot", "dog", "lot", "log", "cog"
        };

        System.out.println(solution(begin, target, words));
    }
}
