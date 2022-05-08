package com.programmers.level1;

import java.util.Arrays;

/*
 * @level1
 * @TestName: 이상한 문자 만들기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12930
 */
public class MakingStrangeChar {

    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();
        // zero 길이 문자열도 포함 split(" ",-1) !!
        String[] split = s.split(" ", -1);
        System.out.println("Arrays.toString(split) = " + Arrays.toString(split));

        for (String str : split) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                String data = String.valueOf(str.charAt(i));

                if (i % 2 == 0) sb.append(data.toUpperCase());
                else sb.append(data.toLowerCase());
            }
            answer.append(sb).append(' ');
        }
        return answer.substring(0, answer.length() - 1);
    }

    public static void main(String[] args) {
        String str1 = "try hello world";
        String str2  = "Hello eVeryone";
        System.out.println("solution(str1) = " + solution(str1));
        String result2 = solution(str2);
        System.out.println("result2 = " + result2);
        System.out.println("result2 = " + result2.equals("HeLlO EvErYoNe"));
    }
}
