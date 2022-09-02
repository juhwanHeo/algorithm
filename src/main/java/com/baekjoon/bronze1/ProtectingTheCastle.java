package com.baekjoon.bronze1;

import com.coding.utils.PrintUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * @bronze1
 * @TestName: 성 지키기
 * @URL: https://www.acmicpc.net/problem/1236
 */
public class ProtectingTheCastle {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int rowCnt = N, colCnt = M;
        char[][] map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j);
            }
        }

        // row
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'X') {
                    rowCnt--;
                    break;
                }
            }
        }



        // col
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[j][i] == 'X') {
                    colCnt--;
                    break;
                }
            }
        }

        PrintUtils.printArray(map);

        System.out.println(Math.max(rowCnt, colCnt));
    }
}
