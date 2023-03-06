package com.programmers.level2;

import java.util.*;

/*
 * @level2
 * @TestName: 시소 짝궁
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/152996
 */
public class SeesawPartner {


    static Map<Double, Integer> map;
    public static long solution(int[] weights) {
        long answer = 0;
        map = new HashMap<>();
        Arrays.sort(weights);

        for (int weight : weights) {
            answer += helper(weight);
            System.out.println(answer + ", " + map);
        }

        return answer;
    }

    static long helper(int weight) {
        long result = 0;

        double d1 = weight * 1.0;
        double d2 = (weight * 2.0) / 3.0;
        double d3 = (weight * 1.0) / 2.0;
        double d4 = (weight * 3.0) / 4.0;

        result += map.getOrDefault(d1, 0);
        result += map.getOrDefault(d2, 0);
        result += map.getOrDefault(d3, 0);
        result += map.getOrDefault(d4, 0);

        map.put(d1, map.getOrDefault(d1, 0) + 1);
        return result;
    }
}
