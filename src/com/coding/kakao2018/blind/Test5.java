package com.coding.kakao2018.blind;

import java.util.ArrayList;
import java.util.List;

/*
 * @2018 kakao blind recruitment
 * @TestName: [3차] n진수 게임
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/17687
 */
public class Test5 {
    // n - 진법
    // t - 미리 구할 숫자 개수
    // m - 게임 참여 인원
    // p - 나의 순서
    public static String solution(int n, int t, int m, int p) {
        StringBuilder str = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < m * t; i++) str.append(Integer.toUnsignedString(i, n).toUpperCase());
        for (int i = 0; i < t; i++) {
            int index = (p-1) + i * m;
            answer.append(str.toString().charAt(index));
        }
        return answer.toString();
    }

    public static void main(String[] args) {

        String myRes1 = solution(2, 4, 2, 1);
        String res1 = "0111";
        System.out.println("myRes1: " + myRes1);

        String myRes2 = solution(16, 16, 2, 1);
        String res2 = "02468ACE11111111";
        System.out.println("myRes2: " + myRes2);

        String myRes3 = solution(16, 16, 2, 2);
        String res3 = "13579BDF01234567";
        System.out.println("myRes3: " + myRes3);

    }
}
