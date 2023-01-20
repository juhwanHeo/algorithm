package com.coding.utils;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PermutationTest {

    static class Card {
        int index;
        int x;
        int y;

        public Card(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }

        @Override
        public String toString() {
            return index +
                    ": (" + x +
                    ", " + y +
                    ')';
        }
    }

    /*
     * 1: (0, 0), 1: (3, 2),
     * 2: (1, 0), 2: (2, 3)
     * 3: (0, 3), 3: (3, 0)
     *
     * */
    private List<List<Card>> init() {

        List<List<Card>> points = new ArrayList<>();
        for (int i = 0; i <= 6; i++) points.add(new ArrayList<>());
        int[][] routes = {
                {1, 0, 0, 3},
                {2, 0, 0, 0},
                {0, 0, 0, 2},
                {3, 0, 1, 0}
        };

        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                int index = routes[i][j];
                if (index > 0) {
                    points.get(index).add(new Card(i, j, index));
                }
            }
        }

        return points;
    }

    @Test
    void solution1() {
        int n = 3;
        int r = 3;
        int[] arr = {1, 2, 3};
        int[] output = new int[n];
        List<int[]> result = new ArrayList<>();
        boolean[] visited = new boolean[n];
        Permutation.perm(arr, output, result, visited, 0, n, r);


        List<List<Card>> cardList = init();
        Queue<List<Card>> queue = new LinkedList<>();
        System.out.println(cardList);
        for (int[] indexList : result) {
//            System.out.println(Arrays.toString(indexList));
            for (int index : indexList) {
                queue.offer(cardList.get(index));
            }
            System.out.println(queue);
            queue.clear();
        }

//        System.out.println("result: " + Arrays.toString(result));
//        assertEquals(expected, result);
    }

}