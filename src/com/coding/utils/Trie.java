package com.coding.utils;

import java.util.HashMap;
import java.util.Map;

/*
 * @COMMENT: Trie 구조 잘 설명 되어 있는 사이트
 * https://hongjuzzang.github.io/solution/code_p17685/
 * https://codingnojam.tistory.com/40
 */
public class Trie {
    Map<Character, Trie> children;
    int cnt;
    boolean isEnd;

    public Trie() {
        this.children = new HashMap<>();
        this.cnt = 0;
        this.isEnd = false;
    }

    public void insert(Trie node, String str) {
        for(int i=0; i<str.length(); i++) {
            node = node.children.computeIfAbsent(str.charAt(i), key -> new Trie());
            node.cnt++;
        }
        node.isEnd = true;
    }

    public int search(Trie node, String str) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            node = node.children.get(str.charAt(i));
            count++;

            if (node.cnt == 1) break;
        }

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