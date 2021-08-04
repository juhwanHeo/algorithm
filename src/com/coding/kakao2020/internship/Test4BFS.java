package com.coding.kakao2020.internship;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
class Node{
    int x;
    int y;
    int depth;
    int monoy;

    Node(int x, int y, int depth){
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}

public class Test4BFS {
    static boolean[] visited;
    static int[][] dp;  //{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}

    /*
    * 우, 상, 하, 좌 로 할 때 정답
    * BFS로도 구현 해보기
    */
    static int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    /*
    * '질문하기'에 김현준님 코드 참고
    */
    public static int solution(int[][] board) {
        dp = new int[board.length][board[0].length];
        for (int[] d : dp)
            Arrays.fill(d, Integer.MAX_VALUE);

        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void check(int[][] board) {
        dp[0][0] = 0;
    }

    static void bfs(int start, int end) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start, end, 1));
//        visited[]
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int[] direction : directions) {
                int movedRow = node.y + direction[0];
                int movedCol = node.x + direction[1];

//                if (canMove(board, movedRow, movedCol)) {
//                    int nCost;
//                    if(isCurved(curRow, curCol, movedRow, movedCol))
//                        nCost = 600;
//                    else nCost = 100;
//                    visited[movedRow][movedCol] = true;
//                    dfs(board, row, col, movedRow, movedCol, dp[row][col] + nCost);
//                    visited[movedRow][movedCol] = false;
//                }

            }
        }
    }

    public static boolean isCurved(int curRow, int curCol, int movedRow, int movedCol) {
        return Math.abs(curRow - movedRow) > 0 && Math.abs(curCol - movedCol) > 0;
    }

//    public static boolean canMove(int[][] board, int movedRow, int movedCol) {
//        return movedRow >= 0 && movedRow < board.length
//                && movedCol >= 0 && movedCol < board[0].length
//                && !visited[movedRow][movedCol]
//                && board[movedRow][movedCol] != 1;
//    }

    public static void main(String[] args) {
        int[][] test1 = {
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };
        int answer1 = solution(test1);
        int res1 = 900;

        int[][] test2 = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
        int answer2 = solution(test2);
        int res2 = 3800;


        int[][] test3 = {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
        int answer3 = solution(test3);
        int res3 = 2100;

        int[][] test4 = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};
        int answer4 = solution(test4);
        int res4 = 3200;

        System.out.println("answer1 my: " + answer1);
        System.out.println("answer1: " + res1);

        System.out.println("answer2 my: " + answer2);
        System.out.println("answer2: " + res2);

        System.out.println("answer3 my: " + answer3);
        System.out.println("answer3: " + res3);

        System.out.println("answer4 my: " + answer4);
        System.out.println("answer4: " + res4);

    }
}
