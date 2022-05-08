package com.programmers.level2;

/*
 * @level2
 * @TestName: JadenCase 문자열 만들기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12951
 */
public class JadenCase {


    public static String solution(String s) {
        String[] split = s.split(" ", -1);
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (String str : split) {
            String first = str.length() > 0 ? str.substring(0, 1) : "";
            String second = str.length() > 1 ? str.substring(1) : "";

            sb.append(first.toUpperCase()).append(second.toLowerCase());
            if (index++ != split.length - 1) sb.append(" ");
        }

        return sb.toString();
    }


    public static void main(String[] args) {

        System.out.println(solution("3people unFollowed me"));
    }
}
