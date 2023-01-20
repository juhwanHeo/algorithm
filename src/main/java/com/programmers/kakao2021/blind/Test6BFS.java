package com.programmers.kakao2021.blind;

import com.coding.utils.Permutation;

import java.util.*;

/*
 * @2021 kakao blind recruitment
 * @TestName: 카드 짝 맞추기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/72415
 * @COMMENT: 푸는 중
 */
public class Test6BFS {

    static class Card {
        int index, row, col;

        public Card(int row, int col) {
            this(row, col, -1);
        }

        public Card(int row, int col, int index) {
            this.row = row;
            this.col = col;
            this.index = index;
        }

        @Override
        public String toString() {
            return index +
                    ": (" + row +
                    ", " + col +
                    ')';
        }
    }

    static List<List<Card>> points;
    static int[][] map;
    static int answer = Integer.MAX_VALUE;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static int solution(int[][] board, int r, int c) {
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
                    points.get(index).add(new Card(i, j, index));
                }
            }
        }

        map = board;
        int n = hs.size();
        int[] arr = hash2Array(hs);
        int[] output = new int[n];
        List<int[]> result = new ArrayList<>();
        boolean[] visited = new boolean[n];
        Permutation.perm(arr, output, result, visited, 0, n, n);
        System.out.println(points);
        for (int[] indexList : result) {
            Queue<List<Card>> queue = new LinkedList<>();
            for (int index : indexList) {
                queue.offer(points.get(index));
            }

//            int cost = gameStart(r, c, queue, deepCopyBoard(board));
//            answer = Math.min(answer, cost);
        }

        return answer;
    }

    /* 2 -> 3 -> 1 */
    private static int gameStart(int r, int c, Queue<List<Card>> indexQueue) {
        int row = r;
        int col = c;
        int cost = 0;


        boolean[][] visited = new boolean[map.length][map[0].length];
        while (!indexQueue.isEmpty()) {
            if (answer < cost) return Integer.MAX_VALUE;
            List<Card> cards = indexQueue.poll();
            int index = cards.get(0).index;
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
                int result1 = bfs(current, cards.get(0), visited);
                int result2 = bfs(current, cards.get(1), visited);
                if (result1 >= result2) {
                    cost += result1;
                    start = cards.get(0);
                    end = cards.get(1);
                }
                else {
                    cost += result1;
                    start = cards.get(1);
                    end = cards.get(2);
                }
            }
            cost += bfs(start, end, visited);
        }

        return cost;
    }

    private static int bfs(Card start, Card end, boolean[][] visited) {
        int cost = 0;
        Queue<Card> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Card current = queue.poll();
            /* enter !!*/
            if (map[current.row][current.col] == end.index) {
                cost++;
                visited[current.row][current.col] = true;
                break;
            }

            for (int[] dir : dirs) {
                int nRow = current.row + dir[0];
                int nCol = current.col + dir[1];
                boolean test = map[nRow][nCol] != 0 && !visited[nRow][nCol];
                while (canMove(nRow, nCol, visited)) {

                }
            }

            cost++;
        }

        return cost;
    }


    /*
    * array 범위에 맞는지, 방문을 했는지 체크
    * */
    private static boolean canMove(int movedRow, int movedCol, boolean[][] visited) {
        return movedRow >= 0 && movedRow < map.length
                && movedCol >= 0 && movedCol < map[0].length
                && !visited[movedRow][movedCol];
    }


    private static int[] hash2Array(Set<Integer> set) {
        return set.stream()
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    private static int[][] deepCopyBoard(int[][] board) {
        int[][] result = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                result[i][j] = board[i][j];
            }
        }

        return result;
    }

    private static boolean isControlKey() {
        return false;
    }
}
