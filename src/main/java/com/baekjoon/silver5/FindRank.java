package com.baekjoon.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * @Silver5
 * @TestName: 등수 구하기
 * @URL: https://www.acmicpc.net/problem/1205
 */
public class FindRank {
    static class Music implements Comparable<Music> {
        int score, rank;

        public Music(int score, int rank) {
            this.score = score;
            this.rank = rank;
        }

        @Override
        public int compareTo(Music o) {
            return Integer.compare(score, o.score);
        }

        @Override
        public String toString() {
            return "(" + score + ", " + rank + ") " ;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(stk.nextToken());
        Integer S = Integer.parseInt(stk.nextToken());
        int P = Integer.parseInt(stk.nextToken());

        if (N == 0) {
            System.out.println(1);
            return;
        }

        List<Music> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        stk = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) pq.offer(Integer.parseInt(stk.nextToken()));
        pq.offer(S);

        int rank = 1;
        while (!pq.isEmpty()) {
            int score = pq.poll();
            int same = 1;
            list.add(new Music(score, rank));
            while (!pq.isEmpty() && score == pq.peek()) {
                list.add(new Music(pq.poll(), rank));
                same++;
            }

            rank += same;
        }

        Music result = new Music(S, -1);
        for (int i = 0; i < list.size(); i++) {
            int value = list.get(i).score;
            int nextValue = (N >= i + 1) ? list.get(i + 1).score : -1;
            if (value == nextValue) continue;
            if (S == value && P > i) result.rank = list.get(i).rank;
        }

        System.out.println(result.rank);
    }
}
