package com.coding.kakao2018.blind;

import java.util.*;

/*
 * @2018 kakao blind recruitment
 * @TestName: [1차] 프렌즈4블록
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/17679
 */
public class Friends4Block {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        boolean isRemove = true;

        while(isRemove) {
            for (String s : board) {
                System.out.println("s = " + s);
            }
            List<Point> list = new ArrayList<>();
            // 사라질 블록의 첫번째 인덱스 찾기
            for (int i = 0; i < m - 1; i++) {
                for (int k = 0; k < n - 1; k++) {
                    if (board[i].charAt(k) != '1'
                            && board[i].charAt(k) >= 'A' && board[i].charAt(k) <= 'Z'
                            && board[i].charAt(k) == board[i].charAt(k + 1)
                            && board[i].charAt(k) == board[i + 1].charAt(k)
                            && board[i].charAt(k) == board[i + 1].charAt(k + 1)
                    ) {
                        list.add(new Point(k, i));
                    }
                }
            }
            if (list.isEmpty()) isRemove = false;
            else {
                // 사라질 블록 개수 세고 빈블록으로 변환
                for (Point point : list) {
                    if (board[point.y].charAt(point.x) != '1') answer++;
                    if (board[point.y].charAt(point.x + 1) != '1') answer++;
                    if (board[point.y + 1].charAt(point.x) != '1') answer++;
                    if (board[point.y + 1].charAt(point.x + 1) != '1') answer++;

                    StringBuilder sb1 = new StringBuilder(board[point.y]);
                    StringBuilder sb2 = new StringBuilder(board[point.y + 1]);

                    sb1.setCharAt(point.x, '1');
                    sb1.setCharAt(point.x + 1, '1');

                    sb2.setCharAt(point.x, '1');
                    sb2.setCharAt(point.x + 1, '1');

                    board[point.y] = sb1.toString();
                    board[point.y + 1] = sb2.toString();
                }
            }

            // 빈 블록 위로 올리기
            for (int i = 0; i < m; i++) {
                for (int k = 0; k < n; k++) {
                    if (board[i].charAt(k) == '1') {

                        for (int row = i; row > 0; row--) {
                            StringBuilder sb1 = new StringBuilder(board[row]);
                            StringBuilder sb2 = new StringBuilder(board[row - 1]);

                            char ch = sb1.charAt(k);
                            sb1.setCharAt(k, sb2.charAt(k));
                            sb2.setCharAt(k, ch);

                            board[row] = sb1.toString();
                            board[row - 1] = sb2.toString();
                        }
                    }

                }
            }
            System.out.println("list = " + list);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] board1 = {
                "CCBDE",
                "AAADE",
                "AAABF",
                "CCBBF"
        };
        int m1 = 4;
        int n1 = 5;

        String[] board2 = {
                "ABCD",
                "BACE",
                "BCDD",
                "BCDD"
        };
        int m2 = 4;
        int n2 = 4;
        String[] board3 = {
                "AAAAAA",
                "BBAATB",
                "BBAATB",
                "JJJTAA",
                "JJJTAA"
        };
        int m3 = 5;
        int n3 = 6;

//        System.out.println(solution(m1, n1, board1));
//        System.out.println(solution(m2, n2, board2));
//        System.out.println(solution(m3, n3, board3));

        System.out.println("solution() = " + solution(6,2, new String[] {"AA", "AA", "CC", "AA", "AA", "DD"}));
    }
}
