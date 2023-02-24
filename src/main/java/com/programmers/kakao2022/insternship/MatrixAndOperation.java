package com.programmers.kakao2022.insternship;

import java.util.*;

/*
 * @2022 KAKAO Tech Internship
 * @TestName: 행렬과 연산
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/118670
 * @COMMENT: Deque
 */
public class MatrixAndOperation {

    private static Deque<Integer> leftSide;
    private static Deque<Integer> rightSide;
    private static Deque<Deque<Integer>> inside;
    private static final String CODE_ROTATE = "Rotate";
    private static final String CODE_SHIFT_ROW = "ShiftRow";

    public static int[][] solution(int[][] rc, String[] operations) {
        int[][] answer = new int[rc.length][rc[0].length];

        leftSide = new LinkedList<>();
        rightSide = new LinkedList<>();
        inside = new LinkedList<>();
        for (int[] row : rc) {
            inside.addLast(new LinkedList<>());
            for (int k = 0; k < row.length; k++) {
                int value = row[k];
                if (k == 0) leftSide.offer(value);
                else if (k == row.length - 1) rightSide.offer(value);
                else inside.peekLast().offerLast(value);
            }
        }

        print("before");
        for (String operation : operations) {
            if (operation.equals(CODE_ROTATE)) rotate();
            else if (operation.equals(CODE_SHIFT_ROW)) shiftRow();
        }
        System.out.println("==========\n");
        print("after");

        for (int i = 0; i < answer.length; i++) {
            int k = 0;
            answer[i][k++] = leftSide.pollFirst();

            for (int value : inside.pollFirst()) answer[i][k++] = value;

            answer[i][k] = rightSide.pollFirst();
        }

        return answer;
    }

    private static void print(String status) {
        System.out.println(status + " leftSide = " + leftSide);
        System.out.println(status + " rightSide = " + rightSide);
        System.out.println(status + " inside = " + inside);
    }

    private static void rotate() {
        inside.peekFirst().offerFirst(leftSide.pollFirst());
        rightSide.offerFirst(inside.peekFirst().pollLast());
        inside.peekLast().offerLast(rightSide.pollLast());
        leftSide.offerLast(inside.peekLast().pollFirst());
    }
    
    private static void shiftRow() {
        leftSide.offerFirst(leftSide.pollLast());
        inside.offerFirst(inside.pollLast());
        rightSide.offerFirst(rightSide.pollLast());
    }

}
