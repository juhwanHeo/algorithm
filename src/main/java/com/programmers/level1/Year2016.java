package com.programmers.level1;

/*
 * @level1
 * @TestName: 2016년
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12901
 */
public class Year2016 {
    static String solution(int a, int b) {
        String answer = "";
        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int i = 0; i < a - 1; i++) b += month[i];

        switch (b % 7) {
            case 3: answer = "SUN"; break;
            case 4: answer = "MON"; break;
            case 5: answer = "TUE"; break;
            case 6: answer = "WED"; break;
            case 0: answer = "THU"; break;
            case 1: answer = "FRI"; break;
            case 2: answer = "SAT"; break;
        }

        return answer;
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 24;
        System.out.println(solution(a, b));
    }
}
