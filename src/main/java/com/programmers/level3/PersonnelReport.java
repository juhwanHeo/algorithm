package com.programmers.level3;

import com.coding.utils.PrintUtils;

import java.util.Arrays;

/*
 * @level3
 * @TestName: 인사고과
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/152995
 */
public class PersonnelReport {
    public static int solution(int[][] scores) {
        int[] wanHo = scores[0];

        // 근무태도점수 내림차순정렬. 근무태도 동점인 경우 동료평가점수 오름차순
        Arrays.sort(scores, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        int answer = 1, maxScore = 0, wanHoSum = wanHo[0] + wanHo[1];


        PrintUtils.printArray(scores);
        for (int[] score : scores) {
            // 내 앞에 동료평가점수가 나보다 높은사람이 한명이라도 있으면 탈락
            // 근무태도 동점자의 경우 동료평가 오름차순 하였으므로 고려하지 않아도 됨
            if (score[1] < maxScore) {
                // 탈락대상
                if (Arrays.equals(score, wanHo)) return -1;
            } else {
                // 인센대상
                maxScore = score[1];
                if (score[0] + score[1] > wanHoSum) answer++;
            }
            System.out.println("maxScore: " + maxScore + ", answer: " + answer);

        }
        return answer;
    }
}
