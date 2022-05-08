package com.programmers.level1;

/*
 * @level1
 * @TestName: 하샤드 수
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12947
 */
public class HashadNumber {

    public static boolean solution(int x) {
        String str = String.valueOf(x);
        String[] split = str.split("");

        int sum = 0;

        for (String s : split) sum += Integer.parseInt(s);

        return x % sum == 0;
    }

    public static void main(String[] args) {

        System.out.println("solution(10) = " + solution(10));

    }
}
