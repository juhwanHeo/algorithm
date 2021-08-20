package com.coding.kakao2020.blind;

import java.util.*;

/*
 * @2020 kakao blind
 * @TestName: 가사 검색
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/60060?language=java
 * @COMMENT: https://kiyongpro.github.io/kakao/lyrics-Search/ Trie 구조 공부
 */

public class Test4 {

    public static int[] solution(String[] words, String[] queries) {
        List<Integer> answer = new ArrayList<>();
        for (String query : queries) {
            int cnt = 0;
            String remove = query.replaceAll("\\?", "");
            for (String word : words) {
                if (word.length() != query.length()) continue;
                if (query.startsWith("?")) {
                    if (word.endsWith(remove)) cnt ++;
                }
                else {
                    if (word.startsWith(remove)) cnt ++;
                }
            }
            answer.add(cnt);
        }

        return answer.stream()
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    public static void main(String[] args) {
        String[] words1 = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries1 = {"fro??", "????o", "fr???", "fro???", "pro?"};
        int[] res1 = {3, 2, 4, 1, 0};

        System.out.println("myRes1: " + Arrays.toString(solution(words1, queries1)));
    }

}

