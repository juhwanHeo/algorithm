package com.coding.utils;

public class Node implements Comparable<Node>{
    public int end, cost;

    public Node(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Node{" +
                "end=" + end +
                ", cost=" + cost +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(cost, o.cost);
    }
}