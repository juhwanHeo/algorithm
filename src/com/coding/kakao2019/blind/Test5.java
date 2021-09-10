package com.coding.kakao2019.blind;

import java.util.*;

/*
 * @2019 kakao blind recruitment
 * @TestName: 길 찾기 게임
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/42892
 */
public class Test5 {

    static class Node {
        Point data;
        Node root;
        Node left;
        Node right;

        @Override
        public String toString() {
            return data + " ";
        }
    }
    static class Point {
        int val;
        int x;
        int y;

        Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "val=" + val +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static int[][] solution(int[][] nodeinfo) {
        List<Point> list = new ArrayList<>();
        List<Integer> preorderList = new ArrayList<>();
        List<Integer> postorderList = new ArrayList<>();
        Node root = null;
        for (int i = 0; i < nodeinfo.length; i++) {
            list.add(new Point(nodeinfo[i][0], nodeinfo[i][1], i+1));
        }
        list.sort((p1, p2) -> p2.y - p1.y);

        for (Point point : list) {
            Node newNode = new Node();
            newNode.data = point;
            if (root == null) {
                root = newNode;
            }
            else {
                // 탐색
                Node curNode = root;
                while(true) {
                    // left
                    if (curNode.data.x > newNode.data.x) {
                        if (curNode.left == null) {
                            curNode.left = newNode;
                            newNode.root = curNode;
                            break;
                        }
                        else curNode = curNode.left;
                    }
                    // right
                    else {
                        if(curNode.right == null) {
                            curNode.right = newNode;
                            newNode.root = curNode;
                            break;
                        }
                        else curNode = curNode.right;
                    }

                }

            }
        }

        preorder(root, preorderList);
        postorder(root, postorderList);
        return new int[][]{
                preorderList.stream().mapToInt(Integer::valueOf).toArray(),
                postorderList.stream().mapToInt(Integer::valueOf).toArray(),
        };
    }

    // D L R
    private static void preorder(Node node, List<Integer> list) {
        if (node != null) {
            list.add(node.data.val);
            preorder(node.left, list);
            preorder(node.right, list);
        }
    }

    // L R D
    private static void postorder(Node node, List<Integer> list) {
        if(node != null) {
            postorder(node.left, list);
            postorder(node.right, list);
            list.add(node.data.val);
        }
    }

    // L D R
    // 그냥 구현
    private static void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.println(node.data.val);
            inorder(node.right);
        }
    }

    public static void main(String[] args) {
        int[][] relation1 = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        int[][] res1 = {{7,4,6,9,1,8,5,2,3},{9,6,5,8,1,4,3,2,7}};
        int[][] myRes1 = solution(relation1);

        System.out.println("myRes1: "+Arrays.deepToString(myRes1));
        System.out.println(Arrays.deepEquals(res1, myRes1));

    }
}

