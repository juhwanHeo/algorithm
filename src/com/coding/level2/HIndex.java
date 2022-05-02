package com.coding.level2;

import java.util.Arrays;

/*
 * @level2
 * @TestName: HIndex
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/42747
 */
public class HIndex {

    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        System.out.println(Arrays.toString(citations));

        for (int i = 0; i <= citations.length; i++) {
            int index = i;
            long min = Arrays.stream(citations)
                    .filter(value -> value <= index)
                    .count();

            long max = Arrays.stream(citations)
                    .filter(value -> value >= index)
                    .count();

            System.out.println("i = " + i);
            System.out.println("max = " + max);
            System.out.println("min = " + min);
            System.out.println("===================\n");
            if (i <= max && i >= min) answer= Math.max(answer, i);
            else break;
        }
        
        return answer;
    }

    public static void main(String[] args) {
        int[] citations = {
//                3, 0, 6, 1, 5  //3
                10, 10, 10, 10, 10 // 5
        };

        System.out.println(solution(citations));
    }

}
