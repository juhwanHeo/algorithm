package com.coding.kakak2018.blind;


import java.util.*;

/*
 * @2018 kakao blind recruitment
 * @TestName: [3차] 자동완성
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/17685
 * @COMMENT: 잘 설명 되어 있는 사이트 : https://hongjuzzang.github.io/solution/code_p17685/
 */
public class AutoComplete {

    static class Trie {
        Map<Character, Trie> children;
        int cnt;

        Trie() {
            this.children = new HashMap<>();
            this.cnt = 0;
        }

        void insert(Trie node, String str) {
            for(int i=0; i<str.length(); i++) {
                node = node.children.computeIfAbsent(str.charAt(i), key -> new Trie());
                node.cnt++;
            }
        }

        int search(Trie node, String str) {
            int count = 0;

            for (int i = 0; i < str.length(); i++) {
                System.out.println("node.children = " + node.children);
                System.out.println("str.charAt(i) = " + str.charAt(i));

                node = node.children.get(str.charAt(i));
                System.out.println("node.cnt = " + node.cnt);

                count++;
                if (node.cnt == 1) break;
            }

            System.out.println("================\n");

            return count;
        }


        @Override
        public String toString() {
            return "Trie{" +
                    "children=" + children +
                    "count=" + cnt +
                    '}';
        }
    }

    public static int solution(String[] words) {
        int answer = 0;

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(trie, word);
        }

        for (String word : words) {
            answer += trie.search(trie, word);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] words = {
                "go","gone","guild"
        };

        System.out.println("solution(words) = " + solution(words));
    }
}
