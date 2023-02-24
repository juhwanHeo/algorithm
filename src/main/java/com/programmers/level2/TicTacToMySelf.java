package com.programmers.level2;

/*
 * @level2
 * @TestName: 혼자서 하는 틱택토
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/160585
 */
public class TicTacToMySelf {
    public static int solution(String[] board) {
        int countO = 0, countX = 0;
        for (String s : board) {
            for (int j = 0; j < board[0].length(); j++) {
                if (s.charAt(j) == 'O') countO++;
                else if (s.charAt(j) == 'X') countX++;
            }
        }

        int diff = countO - countX;

        /* 선공을 X가 함 */
        if (diff <= -1) return 0;
        /* 2개 이상 차이가 남*/
        if (diff >= 2) return 0;

        /* 선공이 3개 이하면 성공 */
        if (countO < 3) return 1;

        /*  diff: 0 or 1 */
        boolean isWinO = isEnd(board, 'O');
        boolean isWinX = isEnd(board, 'X');


        // 개수가 같은 경우
        // O는 무조권 지거나 비김
        // X는 이기거나 비김
        if (diff == 0) {
            return isWinO ? 0 : 1;
        }

        // 개수가 다른 경우
        // X가 이기면 0
        // 둘 다 이기면 0
        // O가 이기면 1
        // 비기면 1
        else {
            if (!isWinO && !isWinX) return 1;
            return isWinO && !isWinX ? 1 : 0;
        }
    }

    static boolean isEnd(String[] board, char win) {
        // col
        for (String s : board) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == win) count++;
            }
            if (count == 3) return true;
        }
        // row
        for (int i = 0; i < board.length; i++) {
            int count = 0;
            for (int j = 0; j < board[i].length(); j++) {
                if (board[j].charAt(i) == win) count++;
            }
            if (count == 3) return true;
        }

        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(i) == win) count++;
        }
        if (count == 3) return true;

        // 0, 2 1, 1, 2, 0
        count = 0;
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(2 - i) == win) count++;
        }

        return count == 3;
    }
}
