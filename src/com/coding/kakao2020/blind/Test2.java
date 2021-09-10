package com.coding.kakao2020.blind;

import java.util.*;

/*
 * @2020 kakao blind
 * @TestName: 괄호 변환
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/60058
 */
public class Test2 {
    public static String solution(String p) {
        return conversion(p);
    }


    private static String conversion(String p) {
        if (p.isEmpty()) return "";
        int index = getBalanceIndex(p);
        String u = p.substring(0, index);
        String v = p.substring(index);
        // 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
        // 3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
        if (isCorrect(u)) return u + conversion(v);
        else {
            // 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
            // 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
            // 4-3. ')'를 다시 붙입니다.
            StringBuilder sv = new StringBuilder("(" + conversion(v) + ")");
            // 4-4. u의 첫 번째와 마지막 문자를 제거하고,
            // 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
            StringBuilder su = new StringBuilder(u);
            su.deleteCharAt(0);
            su.deleteCharAt(su.length() - 1);
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < su.toString().length(); i++) {
                if(su.toString().charAt(i) == '(') res.append(")");
                else res.append("(");
            }
            // 생성된 문자열을 반환합니다.
            return sv.append(res).toString();
        }
    }

    private static boolean isCorrect(String p) {
        int cnt = 0;
        for (char c : p.toCharArray()) {
            if (c == '(') cnt++;
            else cnt--;

            if (cnt < 0) return false;
        }
        return true;
    }

    private static int getBalanceIndex(String p) {
        int cnt = 0;
        int index = 0;
        for (char c : p.toCharArray()) {
            if (c == '(') cnt++;
            else cnt--;
            if (cnt == 0) return index + 1;
            index++;
        }
        return index;
    }

    public static void main(String[] args) {
        String p1 = "(()())()";
        String res1 = "(()())()";
        System.out.println(solution(p1).equals(res1));

        String p2 = ")(";
        String res2 = "()";
        System.out.println(solution(p2).equals(res2));

        String p3 = "()))((()";
        String res3 = "()(())()";
        String myRes3 = solution(p3);
        System.out.println(myRes3);
        System.out.println(myRes3.equals(res3));



    }
}

