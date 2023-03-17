package com.programmers.level1;

import java.util.Arrays;

/*
 * @level1
 * @TestName: 자릿수 더하기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12931
 */
public class KnightlyWeapon {
    static int count = 0;
    static int solution(int number, int limit, int power) {
        int answer = 0;

//        for (int i = 1; i < number; i++) {
//            int divisor = divisorCount(i + 1);
//            answer += (divisor <= limit) ? divisor : power;
//        }
//        answer++;

        int[] array = divisorArray(number);
        for (int i = 0; i < array.length; i++) {
            answer += (array[i] <= limit) ? array[i] : power;
        }
        System.out.println("number: " + number + ", count: " + count);
        System.out.println(Arrays.toString(array));
        return answer;
    }

    // 1_166_787
    static int[] divisorArray(int number) {
        int[] array = new int[number + 1];
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number / i; j++) {
                array[i * j]++;
                System.out.print((i * j) + ", ");
                count ++;
            }
            System.out.println();
        }

        return array;
    }

    // 21_032_193
    static int divisorCount(int number) {
        int cnt = 0;
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                cnt++;
                if (i * i < number) {
                    cnt++;
                }

            }

            count++;
        }
        return cnt;
    }
}
