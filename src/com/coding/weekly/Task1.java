package com.coding.weekly;

/*
 * @Weekly 1
 * @TestName: 부족한 금액 계산하기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/82612
 */
public class Task1 {
    public static long solution(int price, int money, int count) {
        long answer = 0;
        for (int i = 0; i < count; i++) {
            answer += (long) price * (i + 1);
        }

        if(money - answer > 0) return 0;
        else return Math.abs(money - answer);
    }

    public static void main(String[] args) {
        int price = 3;
        int money = 20;
        int count = 4;
        int res = 10;

        long myRes = solution(price, money, count);
        long myRes2 = solution(100, 1600, 5);
        System.out.println("res: " + res);
        System.out.println("myRes: " + myRes);
    }
}
