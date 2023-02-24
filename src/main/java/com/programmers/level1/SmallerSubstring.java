package com.programmers.level1;

/*
 * @level1
 * @TestName: 크기가 작은 부분 문자열
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/147355
 */
public class SmallerSubstring {
    static int solution(String t, String p) {
        int answer = 0;

        for (int i = 0; i <= t.length() - p.length(); i++) {
            String substring = t.substring(i, p.length() + i);
            if (Long.parseLong(substring) <= Long.parseLong(p)) answer++;
        }

        return answer;
    }

}
