package com.coding.utils;

import java.util.ArrayList;
import java.util.List;

/*
 * make Java Array form
 * */
public class MakeGraph {

    public static List<List<Integer>> makeAdjTwoWay(int[][] edges, int n) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];

            adj.get(start).add(end);
            adj.get(end).add(start);
        }

        return adj;

    }

    public static List<List<Integer>> makeAdjOneWay(int[][] edges, int n) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];

            adj.get(start).add(end);
        }

        return adj;

    }
}
