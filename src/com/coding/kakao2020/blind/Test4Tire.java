package com.coding.kakao2020.blind;

import java.util.*;

/*
 * @2020 kakao blind
 * @TestName: 가사 검색
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/60060?language=java
 * @COMMENT: 효율성 테스트 통과 x해서, https://kiyongpro.github.io/kakao/lyrics-Search/ Trie 구조 공부
 */

public class Test4Tire {
    static class TrieNode {
        Map<Character, TrieNode> children;
        int cnt;

        TrieNode() {
            this.children = new HashMap<>();
            this.cnt = 0;
        }

        TrieNode(char c) {
            this();
        }

    }
    static class Trie {
        TrieNode preNode;
        TrieNode sufNode;

        Trie() {
            preNode = new TrieNode();
            sufNode = new TrieNode();
        }

        public void insert(String word) {
            TrieNode preNode = this.preNode;
            TrieNode sufNode = this.sufNode;

            for (char w : word.toCharArray()) {
                preNode.cnt++;
                preNode = preNode.children.computeIfAbsent(w, TrieNode::new);
            }

            for (int i = word.length() - 1; i >= 0; i--) {
                sufNode.cnt++;
                sufNode = sufNode.children.computeIfAbsent(word.charAt(i), TrieNode::new);
                
            }
        }

        public int getCount(String word) {
            if (word.startsWith("?")) return getCountBack(word);
            else return getCountFront(word);
        }

        public int getCountFront(String word) {
            TrieNode preNode = this.preNode;
            for (char w : word.toCharArray()) {
                if (w == '?') break;
                if (!preNode.children.containsKey(w)) return 0;
                preNode = preNode.children.get(w);
            }
            return preNode.cnt;
        }

        public int getCountBack(String word) {
            TrieNode sufNode = this.sufNode;
            for (int i = word.length() - 1; i >= 0; i--) {
                if (word.charAt(i) == '?') break;
                if (!sufNode.children.containsKey(word.charAt(i))) return 0;
                sufNode = sufNode.children.get(word.charAt(i));
            }
            return sufNode.cnt;
        }
    }

    public static int[] solution(String[] words, String[] queries) {
        List<Integer> answer = new ArrayList<>();
        Trie[] tries = new Trie[100001];

        for (String word : words) {
            int len = word.length();
            if (tries[len]  == null) tries[len] = new Trie();
            tries[len].insert(word);
        }

        for (String query : queries) {
            int len = query.length();
            if (tries[len] == null) answer.add(0);
            else answer.add(tries[len].getCount(query));
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

