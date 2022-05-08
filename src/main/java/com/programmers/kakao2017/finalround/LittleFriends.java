package com.programmers.kakao2017.finalround;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 * @2017 카카오코드 본선
 * @TestName: 리틀 프렌즈 사천성
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/1836
 */
public class LittleFriends {

    static class Point{
        int y, x;
        char c;

        public Point(int y, int x, char c) {
            this.y = y;
            this.x = x;
            this.c = c;
        }
    }
    static List<Point> list;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static char[][] map;
    static boolean[][] visit;
    static int row, col;

    public static String solution(int m, int n, String[] board) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        list = new ArrayList<>();
        map = new char[101][101];
        row = m;
        col = n;

        for(int i = 1; i <= m; i++)
            for(int j = 1; j <= col; j++) {
                map[i][j] = board[i - 1].charAt(j - 1);

                if(map[i][j] >= 'A' && map[i][j] <= 'Z') {
                    list.add(new Point(i, j, map[i][j]));
                    cnt++;
                }
            }

        list.sort(Comparator.comparingInt(a -> a.c));
        visit = new boolean[m + 1][col + 1];

        while(true){
            boolean flag = false;

            for(int i = 0; i < list.size(); i++){
                Point point = list.get(i);

                if(point.c < 'A' || point.c > 'Z') continue;

                if(!visit[point.y][point.x]){

                    if(dfs(point.c, point.y, point.x, -1, -1)){
                        flag = true;
                        cnt -= 2;
                        sb.append(point.c);
                        map[point.y][point.x] = '.';
                        list.remove(point.y);
                        break;
                    }
                }
            }
            if(!flag) break;
        }

        return (cnt == 0)? sb.toString() : "IMPOSSIBLE";
    }

    private static boolean dfs(char c, int y, int x, int dir, int rotate){
        if(dir != -1 && map[y][x] == c) {
            System.out.println(">>> 지워진 타일 : " + map[y][x]);
            map[y][x] = '.';
            return true;
        }

        boolean result = false;
        visit[y][x] = true;

        for(int i = 0; i < 4; i++){
            int movedY = y + dirs[i][0];
            int movedX = x + dirs[i][1];

            if(movedY < 1 || movedX < 1 || movedY > row || movedX > col || visit[movedY][movedX]) continue;
            if(map[movedY][movedX] != c && map[movedY][movedX] != '.') continue;

            //이미 한번 꺾었을 때
            if(rotate >= 1) {
                if (i == dir) result |= dfs(c, movedY, movedX, i, rotate);
            }
            //아직 꺾지 않았을 때
            else result |= dfs(c, movedY, movedX, i, (i == dir)? rotate : rotate + 1);
        }

        visit[y][x] = false;
        return result;
    }

    public static void main(String[] args) {
        int m1 = 3;
        int n1 = 3;
        String[] board1 = {
                "DBA",
                "C*A",
                "CDB"
                // ABCD
        };
        String[] board2 = {
                "AB",
                "BA"
                // RYAN
        };

        System.out.println("solution(m1, n1, board1) = " + solution(m1, n1, board1));
        System.out.println("solution() = " + solution(2, 2, board2));

    }
}
/*
// 처음 푼 풀이
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

static int startRow;
    static int startCol;
    static PriorityQueue<String> pq;
    public String solution(int m, int n, String[] board) {
        StringBuilder answer = new StringBuilder();
        List<List<String>> boardList = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            boardList.add(new ArrayList<>());
            for (int k = 0; k < n; k++) {
                boardList.get(i).add(String.valueOf(board[i].charAt(k)));
            }
        }

        pq = new PriorityQueue<>();
        do {
            for (int i = 0; i < m; i++) {
                for (int k = 0; k < n; k++) {
                    startRow = i;
                    startCol = k;
                    dfs(boardList, boardList.get(i).get(k), i , k, 0);
                }
            }

            if (pq.isEmpty()) return "IMPOSSIBLE";
            else {
                String remove = pq.poll();
                answer.append(remove);
                for (List<String> list : boardList) {
                    for (int k = 0; k < boardList.get(0).size(); k++) {
                        if (list.get(k).equals(remove)) {
                            list.set(k, ".");
                        }
                    }
                }
            }
        } while (!pq.isEmpty());

        return answer.toString();
    }


    private void dfs(List<List<String>> board, String ch, int row, int col, int depth) {
        if(depth == (board.size() * board.get(0).size() - 1)) {
            return;
        }
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] direction : directions) {
            int movedRow = row + direction[0];
            int movedCol = col + direction[1];

            if(movedRow == startRow && movedCol == startCol) continue;

            if (canMove(board, movedRow, movedCol)) {
                if (ch.equals(board.get(movedRow).get(movedCol))
                        && ! pq.contains(ch)
                        && ! board.get(movedRow).get(movedCol).equals(".")
                ) {
                    pq.offer(ch);
                }
                else return;
                dfs(board, ch, movedRow ,movedCol, depth + 1);
            }
        }
    }

    private boolean canMove(List<List<String>> board, int movedRow, int movedCol) {
        return movedRow >= 0 && movedRow < board.size() && movedCol >=0
                && movedCol < board.get(0).size()
                && !board.get(movedRow).get(movedCol).equals("*");
    }
*/
