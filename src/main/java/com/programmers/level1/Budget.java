package com.programmers.level1;

import java.util.Arrays;

/*
 * @level1
 * @TestName: 예산
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12982
 */
public class Budget {
    static int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;

        Arrays.sort(d);

        for (int i : d) {
            sum += i;
            if (sum > budget) return answer;
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] array = {
//                1, 2, 3, 4
                1,3,2,5,4
        };

        System.out.println(solution(array, 9));
    }
}
