package com.coding.level1;

/*
 * @level1
 * @TestName: 음양 더하기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/76501
 */
public class YinAndYangPlus {
    static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i]) answer += absolutes[i];
            else answer -= absolutes[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] absolutes = {
                4,7,12
        };
        boolean[] sings = {
                true, false, true
        };
        System.out.println(solution(absolutes, sings));
    }
}
