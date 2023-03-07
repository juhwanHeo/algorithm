package com.programmers.level3;

import java.util.*;

/*
 * @level3
 * @TestName: 연속 펄스 부분 수열의 합
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/161988
 * @COMMENT: 부분합
 */
public class SumConsecutivePulse {

    public static long solution(int[] sequence) {
        long[] mdp = new long[sequence.length + 1];
        long[] pdp = new long[sequence.length + 1];


        for (int i = 0; i < sequence.length; i++) {
            mdp[i] =  i % 2 == 0 ? sequence[i] * -1 : sequence[i];
            pdp[i] =  i % 2 == 1 ? sequence[i] * -1 : sequence[i];
        }

        return Math.max(partialSum(mdp), partialSum(pdp));
    }

    /*
    * 최대 연속 부분합 - dp O(n)
    * https://shoark7.github.io/programming/algorithm/4-ways-to-get-subarray-consecutive-sum
    * */
    static long partialSum(long[] array) {
        long result = 0;
        long[] dp = new long[array.length];

        dp[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(0, dp[i - 1]) + array[i];
            result = Math.max(result, dp[i]);
            System.out.println(Arrays.toString(dp));
        }

        System.out.println(Arrays.toString(array));
        System.out.println("result = " + result);
        return result;
    }
}
