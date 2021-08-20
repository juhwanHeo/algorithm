package com.coding.level1;

/*
 * @level1
 * @TestName: 가운데 글자 가져오기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12903
 */
public class MiddleString {
    static String solution(String s) {
        int mid = s.length() / 2;
        if (s.length() % 2 == 0) return s.substring(mid - 1 , mid + 1);
        else return String.valueOf(s.charAt(mid));
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String res1 = "c";
        System.out.println(solution(s1));
    }
}
