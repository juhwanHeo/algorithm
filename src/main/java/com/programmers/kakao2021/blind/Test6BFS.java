package com.programmers.kakao2021.blind;

import java.util.*;

/*
 * @2021 kakao blind recruitment
 * @TestName: 카드 짝 맞추기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/72415
 * @COMMENT: 푸는 중
 */
public class Test6BFS {


    static class Card {
        int index;
        int x;
        int y;

        public Card(int index, int x, int y) {
            this.index = index;
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Card{" +
                    "index=" + index +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static int solution(int[][] board, int r, int c) {
        List<List<Card>> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) list.add(new ArrayList<>());

        Set<Integer> hs = new HashSet<>();
//        Arrays.stream(board)
//                .flatMapToInt(Arrays::stream)
//                .filter(val-> val > 0)
//                .forEach(hs::add);
        // 순열 배열 만들기.
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int index = board[i][j];
                if (index > 0) {
                    hs.add(index);
                    list.get(index).add(new Card(index, i, j));
                }
            }
        }
        System.out.println("set: " + hs);

        System.out.println(list);



//        int[] visitCase = hs.stream()
//                .mapToInt(i->i)
//                .toArray();
//
//        int n = 3;
//        int[] arr = {1, 2, 3};
//        int[] output = new int[n];
//        boolean[] visited = new boolean[n];
//        perm(arr, output, visited, 0, n, 3);
//        System.out.println(Arrays.toString(visitCase));

        /* 2 -> 3 -> 1 */

        bfs(r, c);
        return 0;
    }

    private static boolean isDiagonal() {
        return false;
    }


    private static void bfs(int r, int c) {


    }


    // 배열 출력
    static void print(int[] arr, int r) {
        for (int i = 0; i < r; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            print(output, r);
            return;
        }

        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r);
                output[depth] = 0; // 이 줄은 없어도 됨
                visited[i] = false;;
            }
        }
    }
}
