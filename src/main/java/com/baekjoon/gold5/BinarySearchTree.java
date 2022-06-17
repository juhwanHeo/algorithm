package com.baekjoon.gold5;

import com.coding.utils.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * @Gold5
 * @TestName: 이진 검색 트리
 * @URL: https://www.acmicpc.net/problem/5639
 */
public class BinarySearchTree {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String value = br.readLine();
        Tree tree = new Tree(Integer.parseInt(value));
        while(true) {
            value = br.readLine();
            if (value == null || value.isEmpty()) break;

            tree.add(Integer.parseInt(value));
        }

        postOrder(tree);
    }

    public static void postOrder(Tree tree) {
        if (tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.println(tree.data);
        }
    }

}
