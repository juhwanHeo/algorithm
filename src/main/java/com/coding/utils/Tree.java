package com.coding.utils;

public class Tree {
    public Tree right, left;
    public int data;

    public Tree(int data) {
        this.data = data;
    }

    public void add(int data) {
        if (this.data < data) {
            if (this.right == null) this.right = new Tree(data);
            else this.right.add(data);

        }
        else if (this.data > data) {
            if (this.left == null) this.left = new Tree(data);
            else this.left.add(data);
        }
    }

    @Override
    public String toString() {
        return "Tree{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}