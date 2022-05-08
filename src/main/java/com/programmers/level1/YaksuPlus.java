package com.programmers.level1;

/*
 * @level1
 * @TestName: 약수 더하기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/77884
 */
public class YaksuPlus {
    static int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            answer += (getYaksuCnt(i) % 2 == 0) ?  i : -1 * i;
        }

        return answer;
    }

    private static int getYaksuCnt(int num) {
        int cnt = 0;

        for (int i = 1; i <= num; i++) {
            if (num % i  == 0) cnt ++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        int left = 13;
        int right = 17;
        System.out.println(solution(left, right));
    }
}
