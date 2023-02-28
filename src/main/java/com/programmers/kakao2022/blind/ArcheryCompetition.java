package com.programmers.kakao2022.blind;

import com.coding.utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/*
 * @2022 KAKAO BLIND RECRUITMENT
 * @TestName: 양궁 대회
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/92342
 */
public class ArcheryCompetition {

    static List<int[]> result;
    static int maxDiff;
    static int[] ryan;
    static int[] apeach;
    public static int[] solution(int n, int[] info) {
        result = new ArrayList<>();
        ryan = new int[info.length];
        apeach = info;
        maxDiff = Integer.MIN_VALUE;
        dfs(n, 0, 0);
        if (maxDiff == Integer.MIN_VALUE) return new int[] {-1};

        result.sort((l1, l2) -> {
            for (int i = 10; i > 0; i--) {
                if (l1[i] != l2[i]) return Integer.compare(l2[i], l1[i]);
            }
            return 0;
        });

        return result.get(0);
    }


    static void dfs(int n, int depth, int start) {
        PrintUtils.printArray(ryan);
        if (n == depth) {
            int ryanSum = 0;
            int apacheSum = 0;

            for (int i = 0; i < 10; i++) {
                if (apeach[i] == 0 && ryan[i] == 0) continue;
                if (apeach[i] >= ryan[i]) apacheSum += (10 - i);
                else ryanSum += (10 - i);
            }

            if (ryanSum > apacheSum) {
                int diff = ryanSum - apacheSum;
                if (maxDiff < diff) {
                    maxDiff = diff;
                    result.clear();;
                    result.add(ryan.clone());
                }
                else if (maxDiff == diff) {
                    result.add(ryan.clone());
                }
            }

            return;
        }

        for (int i = start; i < 11; i++) {
            ryan[i]++;
            dfs(n, depth + 1, i);
            ryan[i]--;
        }
    }
}
