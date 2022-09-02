package com.study.test;

import java.util.ArrayList;
import java.util.List;

/*
 * @DFS
 * @TestName: 주원이가 부탁한 알고리즘
 * @URL: 미지원
 * @COMMENT DFS로 해결
 */
class DFS_JUWON {

    static boolean isChild = false;

    private static class Node {
        Integer id;
        Integer up_id;
        List<Node> child;

        public Node(Integer id, Integer up_id) {
            this.id = id;
            this.up_id = up_id;
            child = new ArrayList<>();
        }

        @Override
        public String toString() {
            return "{" +
                    "id:" + id +
                    ", up_id:" + up_id +
                    ", child:" + child +
                    "}";
        }
    }

    public static void dfs(Node node, Node newNode) {
        if (node.id.intValue() == newNode.up_id.intValue()) {
            node.child.add(newNode);
            isChild = true;
            return;
        }

        isChild = false;
        for (Node childNode : node.child) {
            dfs(childNode, newNode);
        }

    }

    public static void main(String[] args) {
        Integer[][] ids = {
                { 1000, null },
                { 1100, 1000 },
                { 1110, 1100 },
                { 1120, 1100 },
                { 1200, 1000 },
                { 1210, 1200 },
                { 1220, 1200 },
                { 1230, 1200 },
                { 1300, 1000 },
                {1, 0},
                {2, 1},
                {3, 2}

        };

        List<Node> nodeList = new ArrayList<>();

        for (Integer[] id : ids) {
            Node newNode = new Node(id[0], id[1]);

            for (Node node : nodeList) dfs(node, newNode);

            if (!isChild) nodeList.add(newNode);
        }

        for (Node node : nodeList) {
            System.out.println(node);
        }
    }
}
