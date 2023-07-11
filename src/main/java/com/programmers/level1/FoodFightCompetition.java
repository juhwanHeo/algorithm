package com.programmers.level1;

/*
 * @level1
 * @TestName: 푸드 파이트 대회
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/134240
 */
public class FoodFightCompetition {
    static String solution(int[] food) {
        StringBuilder answer = new StringBuilder();

        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i] / 2; j++) {
                answer.append(i);
            }
        }

        String front = answer.toString();
        String back = answer.reverse().toString();

        return front + "0" + back;
    }
}
