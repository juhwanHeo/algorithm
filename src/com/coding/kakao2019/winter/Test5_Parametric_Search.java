package com.coding.kakao2019.winter;

import java.util.*;

/*
 * @2019 kakao winter internship
 * @TestName: 징검다리 건너기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/64062
 * @COMMENT: 정확성은 해결 했지만 효율성 해결이 안되서
 *           https://bcp0109.tistory.com/189?category=885291 참고
 *           https://www.crocus.co.kr/1000 공부하기
 */
public class Test5_Parametric_Search {
    static int solution(int[] stones, int k) {
//        int max = Integer.MIN_VALUE;
//        int min = Integer.MAX_VALUE;
//        for (int stone : stones) {
//            max = Math.max(max, stone);
//            min = Math.min(min, stone);
//        }
        int max = Arrays.stream(stones)
                .max()
                .orElse(Integer.MIN_VALUE);
        int min = Arrays.stream(stones)
                .min()
                .orElse(Integer.MAX_VALUE);

        return binarySearch(stones, k, min, max);
    }

    private static int binarySearch(int[] stones, int limit, int min, int max) {
        if(min == max) return min;
        while(min < max) {
            int mid = min + (max - min) / 2;
            System.out.println("[binarySearch] min: " + min);
            System.out.println("[binarySearch] max: " + max);
            System.out.println("[binarySearch] mid: " + mid);
            System.out.println("---------------\n");
            if(canCross(stones, limit, mid)) min = mid + 1;
            else max = mid;
        }

        System.out.println("[binarySearch] end min: " + min);
        System.out.println("[binarySearch] end max: " + max);
        return min - 1;
    }

    private static boolean canCross(int[] stones, int limit, int friends) {
        int pass = 0;
        for(int stone : stones) {
            if(stone - friends < 0) pass++;
            else pass = 0;
            if(pass == limit) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] stones1 = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k1 = 3;
        int answer1 = 3;
        int myRes1 = solution(stones1, k1);
        System.out.println("answer1: " + answer1);
        System.out.println("myRes1: " + myRes1);

    }
}

