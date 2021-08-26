package com.coding.level1;

import java.util.Arrays;

/*
 * @level1
 * @TestName: 시저 암호
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12926
 */
public class CaesarCipher {
    static String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == ' ')  {
                answer.append(" ");
                continue;
            }
            int val = c + n;
            if (c >= 65 && c <= 90) if (val > 90) val -= 26;
            if (c >= 97 && c <= 122) if (val > 122) val -= 26;
            answer.append(Character.toChars(val));
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        String s1 = "AaZz";
        int n = 25;
        System.out.println(solution(s1, n));
    }
}
