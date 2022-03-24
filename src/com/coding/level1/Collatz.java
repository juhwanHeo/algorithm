package com.coding.level1;

/*
 * @level1
 * @TestName: 콜라츠 추측
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12943
 */
public class Collatz {
    static int solution(long num) {
        int answer = 0;

        while (num != 1) {
            System.out.println("num = " + num);
            if (num % 2 == 0) num =  num / 2;
            else num = num * 3 + 1;

            if (answer++ ==  500) return -1;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n1 = 6;
//        System.out.println(solution(n1)); // 8
//        System.out.println(solution(16)); // 8
        System.out.println(solution(626331)); // 8
    }
}
