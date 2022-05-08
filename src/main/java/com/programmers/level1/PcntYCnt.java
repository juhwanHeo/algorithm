package com.programmers.level1;

import java.util.Arrays;

/*
 * @level1
 * @TestName: 문자열 내 p와 y의 개수
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12916
 */
public class PcntYCnt {
    static boolean solution(String s) {
        int[] cnt = new int[2];
        for (String str : s.toLowerCase().split("")) {
            if (str.equals("p")) cnt[0]++;
            else if (str.equals("y")) cnt[1]--;
        }

        return Arrays.stream(cnt).sum() == 0;
    }

    public static void main(String[] args) {
        String str = "pPoooyY";
        System.out.println("solution(10) = " + solution(str)); // true
    }
}
