package com.baekjoon.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
 * @Silver5
 * @TestName: 막대기
 * @URL: https://www.acmicpc.net/problem/1094
 */
public class Stick {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int stick = 64;
        pq.offer(stick);
        int sum = stick;
        while (sum > X) {
            int min = pq.poll();

            int div = min >> 1;
            pq.offer(div);
            pq.offer(div);

            if (X <= sum - div) {
                sum -= pq.poll();
            }
        }
        System.out.println(pq.size());
    }
}
