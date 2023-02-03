package com.programmers.kakao2021.blind;

import com.coding.utils.Permutation;
import com.coding.utils.PrintUtils;

import java.util.*;

/*
 * @2021 kakao blind recruitment
 * @TestName: 카드 짝 맞추기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/72415
 * @COMMENT: 순열, bfs
 */
public class Test6BFS {

    static class Card {
        int row, col, cost;

        public Card(int row, int col) {
            this(row, col, 0);
        }

        public Card(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "(" + row + ", " + col + ", " + cost + ')';
        }
    }

    static List<List<Card>> points;
    static int[][] map;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static int solution(int[][] board, int r, int c) {
        int answer = Integer.MAX_VALUE;
        points = new ArrayList<>();
        List<List<Card>> points = new ArrayList<>();
        Set<Integer> hs = new HashSet<>();
        for (int i = 0; i <= 6; i++) points.add(new ArrayList<>());
        // 순열 배열 만들기.
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int index = board[i][j];
                if (index > 0) {
                    hs.add(index);
                    points.get(index).add(new Card(i, j, 0));
                }
            }
        }

        int n = hs.size();
        int[] arr = hash2Array(hs);
        int[] output = new int[n];
        List<int[]> result = new ArrayList<>();
        boolean[] visited = new boolean[n];
        Permutation.perm(arr, output, result, visited, 0, n, n);

        map = new int[4][4];
        for (int[] indexList : result) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    map[i][j] = board[i][j];
                }
            }
            Queue<List<Card>> queue = new LinkedList<>();
            for (int index : indexList) queue.offer(points.get(index));

            int cost = gameStart(r, c, queue);
            answer = Math.min(answer, cost);
        }

        return answer;
    }

    private static int gameStart(int r, int c, Queue<List<Card>> indexQueue) {
        int row = r;
        int col = c;
        int cost = 0;

        while (!indexQueue.isEmpty()) {
            List<Card> cards = indexQueue.poll();
            int index = map[cards.get(0).row][cards.get(0).col];

            /*
            * 처음 위치가 순서에 맞는 카드면 바로 bfs
            * 처음 위치가 순서에 맞는 카드가 아니면 가까운 카드를 탐색 후 bfs
            * */
            Card start, end;
            if (map[row][col] == index) {
                int cardRow = cards.get(0).row;
                int cardCol = cards.get(0).col;
                if (row == cardRow && col == cardCol) {
                    start = cards.get(0);
                    end = cards.get(1);
                }
                else {
                    start = cards.get(1);
                    end = cards.get(0);
                }
            }
            else {
                Card current = new Card(row, col);
                int result1 = bfs(current, cards.get(0));
                int result2 = bfs(current, cards.get(1));
                if (result1 >= result2) {
                    cost += result2;
                    start = cards.get(1);
                    end = cards.get(0);
                }
                else {
                    cost += result1;
                    start = cards.get(0);
                    end = cards.get(1);
                }
            }
            /* enter 비용: +2 */
            cost += bfs(start, end) + 2;
            row = end.row;
            col = end.col;

            /* 뒤집기 */
            map[start.row][start.col] = 0;
            map[end.row][end.col] = 0;
        }

        return cost;
    }

    private static int bfs(Card start, Card end) {
        Queue<Card> queue = new LinkedList<>();
        int cost = 0;
        int[][] routes = new int[4][4];
        boolean[][] visited = new boolean[4][4];

        queue.add(start);
        while (!queue.isEmpty()) {
            Card current = queue.poll();

            /* enter !!*/
            if (current.row == end.row && current.col == end.col) {
                cost = current.cost;
                routes[current.row][current.col] = current.cost;
                break;
            }

            for (int[] dir : dirs) {
                int nRow = current.row + dir[0];
                int nCol = current.col + dir[1];
                if (canMove(nRow, nCol, visited)) {
                    routes[nRow][nCol] = current.cost + 1;
                    visited[current.row][current.col] = true;
                    queue.offer(new Card(nRow, nCol, current.cost + 1));
                }
            }

            for (int[] dir : dirs) {
                int nRow = current.row;
                int nCol = current.col;
                while (canMove(nRow + dir[0], nCol + dir[1])) {
                    nRow += dir[0];
                    nCol += dir[1];

                    if (!visited[nRow][nCol] && map[nRow][nCol] != 0) break;
                }

                if (canMove(nRow, nCol, visited)) {
                    routes[nRow][nCol] = current.cost + 1;
                    visited[current.row][current.col] = true;
                    queue.offer(new Card(nRow, nCol, current.cost + 1));
                }
            }
        }

        return cost;
    }

    /*
    * array 범위에 맞는지, 방문을 했는지 체크
    * */
    private static boolean canMove(int movedRow, int movedCol, boolean[][] visited) {
        return canMove(movedRow, movedCol)&& !visited[movedRow][movedCol];
    }

    /*
     * array 범위에 맞는지
     * */
    private static boolean canMove(int movedRow, int movedCol) {
        return movedRow >= 0 && movedRow < map.length
                && movedCol >= 0 && movedCol < map[0].length;
    }

    private static int[] hash2Array(Set<Integer> set) {
        return set.stream()
                .mapToInt(Integer::valueOf)
                .toArray();
    }
}
