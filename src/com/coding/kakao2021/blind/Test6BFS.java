package com.coding.kakao2021.blind;

import java.util.*;

/*
 * @2021 kakao blind recruitment
 * @TestName: 카드 짝 맞추기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/72415
 * @COMMENT: 푸는 중
 */
class Card {
    int index;
    int x;
    int y;

    public Card(int index, int x, int y) {
        this.index = index;
        this.x = x;
        this.y = y;
    }
}
public class Test6BFS {

    public static int solution(int[][] board, int r, int c) {
        // 순열 배열 만들기.
        Set<Integer> hs = new HashSet<>();
        Arrays.stream(board)
                .flatMapToInt(Arrays::stream)
                .filter(val-> val > 0)
                .forEach(hs::add);
        System.out.println("set: " + hs);


        int[] visitCase = hs.stream()
                .mapToInt(i->i)
                .toArray();

        System.out.println(Arrays.toString(visitCase));
        return 0;
    }


    private static void bfs() {

    }

    public static void main(String[] args) {
        int[][] board1 = {
                {1,0,0,3},
                {2,0,0,0},
                {0,0,0,2},
                {3,0,1,0}
        };
        int r1 = 1, c1 = 0, result1 = 14;
        int myRes = solution(board1, r1, c1);
        System.out.println("myRes: " + myRes);
    }

}
