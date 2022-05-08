package com.programmers.kakao2019.winter;

import java.util.Arrays;
import java.util.Stack;

/*
 * @2019 kakao winter internship
 * @TestName: 크레인 인형뽑기 게임
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/64061
 */
public class Test1 {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        /*
        * moves의 모든 요소들에게 -1을 하는데
        * moves의 length = n
        * O(n)만큼 걸림
        * stream 연습하기용
        * */
        moves = Arrays.stream(moves)
                 .map(m -> m -= 1)
                 .toArray();

        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            for(int i = 0 ; i < board.length; i++) {
                int val = board[i][move];
                if(val == 0) continue;
                if(!stack.isEmpty() && stack.peek() == val) {
                    answer += 2;
                    stack.pop();
                }
                else stack.push(val);

                board[i][move] = 0;
                break;
            }
        }
        
        return answer;
    }


    public static void main(String[] args) {
        int[][] board1 = {
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}
        };
        int[] move1 = {1, 5, 3, 5, 1, 2, 1, 4};
        int myRes1 = solution(board1, move1);
        int res = 4;


        System.out.println("numbers1: " + Arrays.deepToString(board1));
        System.out.println("answer1 my: "+ myRes1);
        System.out.println("answer1 answer: " + res);
        System.out.println("answer1 equals: " + (myRes1 == res));
        System.out.println("------------------\n");

    }
}

