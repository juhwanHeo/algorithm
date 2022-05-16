package com.baekjoon.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * @bronze1
 * @TestName: 설탕 배달
 * @URL: https://www.acmicpc.net/problem/2839
 */
public class SugarDelivery {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        while (true) {
            if (N % 5 == 0){
                cnt += N / 5;
                break;
            }
            else if (N < 0) {
                cnt = -1;
                break;
            }
            N -= 3;
            cnt ++;
        }

        System.out.println(cnt);
    }
}
