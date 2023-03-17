package com.programmers.level1;

/*
 * @level1
 * @TestName: 문자열 나누기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/140108
 */
public class SplitString {
    static int solution(String s) {
        int answer = 1;

        String[] split = s.split("");
        int firstCnt = 1, secondCnt = 0;

        String first = split[0];
        for (int i = 1; i < split.length; i++) {
            if (first.equals(split[i])) {
                firstCnt++;
            }
            else {
                secondCnt++;
            }

            if (firstCnt == secondCnt) {
                if (i == split.length - 1) break;
                first = split[i + 1];
                answer++;
            }
        }

        return answer;
    }
}
