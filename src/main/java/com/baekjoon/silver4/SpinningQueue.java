package com.baekjoon.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * @Silver4
 * @TestName: 회전하는 큐
 * @URL: https://www.acmicpc.net/problem/1021
 */
public class SpinningQueue {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        List<Integer> list = new ArrayList<>();
        stk = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) list.add(Integer.parseInt(stk.nextToken()));

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) queue.offer(i + 1);

        int cnt = 0;
        while (!list.isEmpty()) {
            int findIndex = queue.indexOf(list.get(0));
            int diffRight = queue.size() - findIndex;
            int front = queue.peek();

            if (front == list.get(0)) {
                queue.poll();
                list.remove(0);
            }
            else {
                if (findIndex < diffRight) {
                    queue.poll();
                    queue.addLast(front);

                } else {
                    int last = queue.pollLast();
                    queue.addFirst(last);
                }
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}

