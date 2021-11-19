package com.coding.level2;

/*
 * @level2
 * @TestName: 예상 대진표
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12985
 */
public class AnticipatedMatch {

    public static int solution(int n, int a, int b) {
        int answer = 1;
        int right = Math.max(a, b);
        int left = Math.min(a, b);

        while ((left % 2 == 0) || (right - left != 1)) {
            left = (left + 1) / 2;
            right = (right + 1) / 2;
            answer++;
        }

        return answer;
        // bit 연산
        // (a-1) XOR (b-1)값을 이진수 문자열로 변환한 길이를 세는 거니까. 예를들어 3과 7이면 11 XOR 111이고 값은 100이 되니까 문자열 길이가 바로 3라운드
        // return Integer.toBinaryString((a-1)^(b-1)).length();
    }


    public static void main(String[] args) {
        int N = 8;
        int A = 4;
        int B = 7;

        System.out.println(solution(N, A, B));
    }
}
