package com.programmers.level2;

import java.util.Arrays;

/*
 * @level2
 * @TestName: 덧칠하기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/161989
 */
public class OverPainting {

    public static int solution(int n, int m, int[] section) {
        int answer = 0;
        int[] dp = new int[n + 2];
//        int[] dp = new int[100_001];

        for (int i : section) {
            if (dp[i] == 1) continue;
            int next = Math.min(i + m, n + 1);
            dp[i] += 1;
            dp[next] -= 1;

            for (int j = i + 1 ; j <= next; j++) {
                dp[j] += dp[j - 1];
            }
            System.out.println(Arrays.toString(dp));
            answer++;
        }

//        System.out.println(Arrays.toString(dp));
        return answer;
    }
}
