package com.coding.level1;

/*
 * @level1
 * @TestName: 수박수박수박수박수박수?
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12922
 */
public class Suparksuparksu {
    static String solution(int n) {
        StringBuilder answer = new StringBuilder();

//        String answer = "";
        for (int i = 0; i < n; i++) {
//           answer += i % 2 == 0 ? "수" : "박";
           answer.append(i % 2 == 0 ? "수" : "박");

        }
        return answer.toString(); // 0.95ms
    }

    public static void main(String[] args) {
        int n1 = 3;
        System.out.println(solution(n1)); // 수박수
    }
}
