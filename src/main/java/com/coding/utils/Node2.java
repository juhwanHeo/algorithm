package com.coding.utils;

public class Node2 {
    public int end, cost, fee;

    public Node2(int end, int cost, int fee) {
        this.end = end;
        this.cost = cost;
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Node2{" +
                "end=" + end +
                ", cost=" + cost +
                ", fee=" + fee +
                '}';
    }
}