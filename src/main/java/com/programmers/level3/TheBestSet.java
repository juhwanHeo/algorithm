package com.programmers.level3;

import java.util.Arrays;

/*
 * @level3
 * @TestName: 최고의 집합
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12938?language=java
 */
public class TheBestSet {
    public static int[] solution(int n, int s) {
        if (s < n) return new int[] {-1};
        int[] answer = new int[n];

//        answer = Arrays.stream(answer)
//                .map(val -> val = s / n)
//                .toArray();

        for (int i = 0; i < n; i++) answer[i] = s / n;

        for (int i = 0; i < s % n; i++) answer[i]++;

        Arrays.sort(answer);
        return answer;

//        return Arrays.stream(answer).sorted().toArray();
    }


    public static void main(String[] args) {
        int n1 = 2;
        int s = 9;
//        int s = 1;

        System.out.println(Arrays.toString(solution(n1, s)));


    }
}
