package com.programmers.level2;

/*
 * @level2
 * @TestName: 숫자의 표현
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12924
 * @COMMENT 슬라이딩 윈도우
 */
public class NumericalRepresentation {

    public static int solution(int n) {
        if (n < 3) return 1;
        int answer = 1, left = 1, right = 2;
        int sum = left + right;
        while (right < n) {
            System.out.println("left = " + left);
            System.out.println("right = " + right);
            if (sum < n) {
                sum += ++right;
                continue;
            }
            System.out.println("sum = " + sum);
            System.out.println("======================\n");
            if (sum == n) answer++;
            sum -= left++;
        }

        // 1 2 3 6 9 18
        // 주어진 자연수를 연속된 자연수의 합으로 표현하는 방법의 수는
        // 주어진 수의 홀수 약수의 개수와 같다라는 정수론 정리가 있습니다.
//        int answer = 0;
//        for (int i = 1; i <= n; i += 2) {
//            System.out.println("i = " + i);
//            if (n % i == 0) {
//                answer++;
//            }
//        }
        return answer;
    }


    public static void main(String[] args) {

        System.out.println(solution(18));
    }
}
