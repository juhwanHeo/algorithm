package com.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @level2
 * @TestName: 시소 짝궁
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/152996
 * @ 이분탐색
 */
public class SeesawPartner {

    private static final int[][] rates = {{1, 1}, {3, 2}, {4, 2}, {4, 3}};

    public static long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);

        // 비율 만큼 반복
        for (int[] rate : rates) {
            for (int i = 0; i < weights.length; i++) {
                int x = weights[i];

                // 비율 계산을 통해 y를 구함
                if (x * rate[0] % rate[1] != 0) continue;
                int y = ((x * rate[0]) / rate[1]);
                // y의 값이 i+1 부터 존재하는지 확인함
                int upper = upperBound(weights, y, i + 1, weights.length);

                // 하한 탐색은 상한 탐색의 위치 이하이므로 탐색 마지막 위치를 upper 해도 됨
                int lower = lowerBound(weights, y, i + 1, upper);

                System.out.println("y: " + y + ", upper: " + upper + ", lower: " +lower);
                // 상한과 하한의 값을 빼서 중복된 값이 몇 개 인지 정답에 더함
                // 만약 y의 값이 범위 내에 존재하지 않으면,
                // 상한과 하한 둘 다 i+1의 위치를 반환하기 때문에 둘의 차이는 0이 될 것임
                answer += (upper - lower);
            }
        }


        return answer;
    }


    // 상한
    private static int upperBound(int[] weights, int findWeight, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;

            if (findWeight < weights[mid]) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    // 하한
    private static int lowerBound(int[] weights, int findWeight, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;

            if (findWeight <= weights[mid]) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
