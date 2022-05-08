package com.programmers.level1;

/*
 * @level1
 * @TestName: 자릿수 더하기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12931
 */
public class AddDigits {
    static int solution(int n) {
        int answer = 0;

        for (char c : String.valueOf(n).toCharArray()) {
            answer += Integer.parseInt(c + "");
        }

        return answer;
    }

    public static void main(String[] args) {
        int n1 = 123;
        System.out.println(solution(123));
    }
}
