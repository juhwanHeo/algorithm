package com.programmers.level2;

import com.coding.utils.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @level2
 * @TestName: 점 찍기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/140107
 */
public class MakeDot {

    public static long solution(int k, int d) {
        long answer = 0;

        for (int i = 0; i <= d; i += k) {
            int y = (int) Math.sqrt(d * d - i * i);
            System.out.println(y);
            answer += Math.floor(y / k) + 1;
        }

        return answer;
    }
}
