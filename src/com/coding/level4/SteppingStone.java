package com.coding.level4;

import java.util.*;

public class SteppingStone {

    public static long solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        long answer = 0;
        long left = 0;
        long right = distance;

        System.out.println("rocks = " + Arrays.toString(rocks));
        while(left <= right) {
            long mid = (left + right) / 2;
            int prev = 0;
            int removeCnt = 0;

            System.out.println("mid = " + mid);
            for (int rock : rocks) {
                if (rock - prev < mid) {
                    removeCnt++;
                    if (removeCnt > n) break;
                }
                else prev = rock;
            }

            System.out.println("prev = " + prev);
            System.out.println("removeCnt = " + removeCnt);
            System.out.println("-----------------------------\n");
            if (removeCnt > n) right = mid - 1;
            else {
                left = mid + 1;
                answer = mid;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int distance1 = 25;
        int[] rocks1 = {
                2, 14, 11, 21, 17
        };
        int n1 = 2;

        System.out.println("solution(distance1, rocks1, n1) = " + solution(distance1, rocks1, n1));

    }
}
