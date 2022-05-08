package com.programmers.level1;

/*
 * @level1
 * @TestName: 나머지가 1이 되는 수 찾기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/87389
 */
public class RestNum {
    static int solution(int n) {
        int answer = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            if (n % i == 1) {
                answer = i;
                break;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        int n = 10;
        System.out.println(solution(n));
    }
}
