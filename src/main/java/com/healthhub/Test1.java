package com.healthhub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
문제:
장기판에서 포가 먹을 수 있는 알의 수를 구하여라 바둑판은 8<=N<= 100 이다 .
이동이 가능한포는 X 로 표기된다 .
이동이 불가능한 다른 포는 Y 로 표기된다 일반 알은 H 로 표기되며 , 빈칸은 L 로 표기된다.
포 X 는 다른 포 Y 를 넘을 수 없으며 , 한 알을 넘어야 다른 알을 먹을 수 있다.
빈칸은 넘어간다 테스트케이스는 10 개가 주어지며 , 모두 통과해야 PASS 이고 , 일부 혹은 전부 오답일 경우 FAIL 이다.

입력:
3
8
L L H L L L L L
L L H L L L L L
L L Y L L L L L
H H X L L L H H
L L L L L L L L
L L Y L L L L L
L L Y L L L L L
L L L L L L L L
8
L L H L L L L L
L L H H L L L L
L L Y H L L L L
H H L L L L H H
H H L X H Y H L
L L Y H L L L L
L L Y H L L L L
L L L Y L L L L
8
L L H L L L L L
L L H H L L L L
L H Y X L Y H Y
H H L L L L H H
H L L H H Y H L
L L Y H L L L L
L L Y H L L L L
L L L Y L L L L

result:
#1 2
#2 3
#3 1

후기:
문제 설명이 빈약함.
해당 X의 위치에서 [상,하], [좌,우] 총 두가지로만 움직일 수 있다는 설명이 없어

처음에 완탐으로 풀었는데 답이 안맞아서 당황.
그래서 isRow 파라메터를 받아서
[상, 하], [좌, 우] 로만 움직일 수 있게 수정

visited 를 1차원으로 선언해서 풀어도 될듯

* */
public class Test1 {
    static int answer;
    private static char[][] map;
    private static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            answer = 0;
            int N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            visited = new boolean[N][N];

            for (int j = 0; j < N; j++) {
                StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < N; k++) {
                    map[j][k] = stk.nextToken().charAt(0);
                }
            }

            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    if (map[row][col] == 'X' && !visited[row][col]) {
                        dfs(row, col, true);
                        visited[row][col] = false;
                        dfs(row, col, false);

                    }
                }
            }
            list.add(answer);
        }

        System.out.println("\n----- result -----");
        for (int i = 0; i < T; i++) {
            System.out.println("#" + (i + 1) + " " + list.get(i));
        }
    }

    /*
     * 이동 가능: X
     * 이동 불가: Y
     * 일반 알 : H
     * 빈칸   : L
     * */
    private static void dfs(int row, int col, boolean isRow) {
        if (visited[row][col] || map[row][col] == 'Y') return;
        visited[row][col] = true;
        if (map[row][col] == 'H') {
            answer++;
            return;
        }

        int[][] dirs;
        if (isRow) dirs = new int[][]{{-1, 0}, {1, 0}};
        else dirs = new int[][]{{0, -1}, {0, 1}};

        for (int[] dir : dirs) {
            int movedRow = row + dir[0];
            int movedCol = col + dir[1];
            if (isMoved(movedRow, movedCol)) {

                /*
                * 다음 위치가 L 이면
                * 한칸 이동
                * */
                if (map[movedRow][movedCol] == 'L') dfs(movedRow, movedCol, isRow);
                /*
                * 다음 위치가 H 이면
                * (2칸 이동 할 수 있는지 판단 후) 2칸 이동
                * */
                else if (map[movedRow][movedCol] == 'H') {
                    movedRow += dir[0];
                    movedCol += dir[1];
//                    System.out.println("test : " + movedRow + ", " + movedCol);
                    if (isMoved(movedRow, movedCol)) dfs(movedRow, movedCol, isRow);
                }
            }
        }
    }

    private static boolean isMoved(int movedRow, int movedCol) {
        return movedRow >= 0 && movedCol >= 0
                && movedRow < map.length && movedCol < map[0].length
                && !visited[movedRow][movedCol]
                && map[movedRow][movedCol] != 'Y'
                ;
    }
}
