package com.baekjoon.silver4;

import com.coding.utils.PrintUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * @Silver4
 * @TestName: 킹
 * @URL: https://www.acmicpc.net/problem/1063
 */
public class King {

    static int kingRow;
    static int kingCol;
    static int stoneRow;
    static int stoneCol;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        map = new int[8][8];
        String king = stk.nextToken();
        String stone = stk.nextToken();
        int N = Integer.parseInt(stk.nextToken());

        String[] kingSplit = king.split("");
        String[] stoneSplit = stone.split("");

        kingRow = Integer.parseInt(kingSplit[1]) - 1;
        kingCol = getIntCol(kingSplit[0]);
        map[kingRow][kingCol] = 1;

        stoneRow = Integer.parseInt(stoneSplit[1]) - 1;
        stoneCol = getIntCol(stoneSplit[0]);
        map[stoneRow][stoneCol] = 2;

        for (int i = 0; i < N; i++) {

            // map 출력문
            PrintUtils.printArray2(map);
            String cmd = br.readLine();
            move(cmd);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(getPosition(kingRow, kingCol))
                .append("\n")
                .append(getPosition(stoneRow, stoneCol));

        System.out.println(sb);

    }

    private static void move(String cmd) {
        int movedKingdRow = kingRow;
        int movedKingCol = kingCol;
        int movedStoneRow = stoneRow;
        int movedStoneCol = stoneCol;
        switch (cmd) {
            case "R":
                movedKingCol += 1;
                movedStoneCol += 1;
                break;
            case "L":
                movedKingCol -= 1;
                movedStoneCol -= 1;
                break;
            case "B":
                movedKingdRow -= 1;
                movedStoneRow -= 1;
                break;
            case "T":
                movedKingdRow += 1;
                movedStoneRow += 1;
                break;
            case "RT":
                movedKingdRow += 1;
                movedKingCol += 1;
                movedStoneRow += 1;
                movedStoneCol += 1;
                break;
            case "LT":
                movedKingdRow += 1;
                movedKingCol -= 1;
                movedStoneRow += 1;
                movedStoneCol -= 1;
                break;
            case "RB":
                movedKingdRow -= 1;
                movedKingCol += 1;
                movedStoneRow -= 1;
                movedStoneCol += 1;
                break;
            case "LB":
                movedKingdRow -= 1;
                movedKingCol -= 1;
                movedStoneRow -= 1;
                movedStoneCol -= 1;
                break;
        }

        if (canMove(movedKingdRow, movedKingCol)) {
            if (isOverlap(movedKingdRow, movedKingCol, stoneRow, stoneCol)) {
                if (canMove(movedStoneRow, movedStoneCol)) {
                    map[kingRow][kingCol] = 0;
                    map[movedKingdRow][movedKingCol] = 1;

                    map[stoneRow][stoneCol] = 0;
                    map[movedStoneRow][movedStoneCol] = 2;

                    kingRow = movedKingdRow;
                    kingCol = movedKingCol;

                    stoneRow = movedStoneRow;
                    stoneCol= movedStoneCol;
                }
            }
            else {
                map[kingRow][kingCol] = 0;
                map[movedKingdRow][movedKingCol] = 1;

                kingRow = movedKingdRow;
                kingCol = movedKingCol;
            }
        }
    }

    private static boolean isOverlap(int kingRow, int kingCol, int stoneRow, int stoneCol) {
        return kingRow == stoneRow && kingCol == stoneCol;
    }

    private static boolean canMove(int movedRow, int movedCol) {
        return movedRow >= 0 && movedRow < map.length
                && movedCol >= 0 && movedCol < map[0].length;
    }

    private static int getIntCol(String ch) {
        return ch.charAt(0) - 65;
    }

    private static String getPosition(int row, int col) {
        char colCh = (char) (col + 65);
        return String.valueOf(colCh) + (row + 1);
    }

}

