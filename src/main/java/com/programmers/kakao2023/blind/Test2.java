package com.programmers.kakao2023.blind;

import java.util.*;


/*
 * @2023 KAKAO BLIND RECRUITMENT
 * @TestName: 택배 배달과 수거하기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/150369
 */
public class Test2 {

    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int delivery = 0, pickup = 0;

        for (int i = n - 1; i >= 0; i--) {
            delivery += deliveries[i];
            pickup += pickups[i];
            System.out.println(i + ", delivery: " + delivery + ", pickup: " + pickup);

            /*
            * 음수가 될 때 까지 반복
            * 양수가 됬다면 배달, 수거할께 남음
            * */
            while (delivery > 0 || pickup > 0) {
                delivery -= cap;
                pickup -= cap;
                answer += (i + 1) * 2L;
            }
        }
        
        return answer;
    }
}
