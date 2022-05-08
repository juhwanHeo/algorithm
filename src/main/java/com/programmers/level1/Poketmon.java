package com.programmers.level1;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * @level1
 * @TestName: 포켓몬
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/1845
 */
public class Poketmon {
    static int solution(int[] nums) {
        Set<Integer> hs = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return Math.min(nums.length / 2, hs.size());
    }

    public static void main(String[] args) {
        int[] nums = {3,1,2,3};
        int res1 = 2;
        System.out.println(solution(nums));
    }
}
