package com.coding.level2;

/*
 * @level2
 * @TestName: 124 나라의 숫자
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12899
 */
public class OneTwoFourCountry {

    public static String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[] {4, 1, 2};

        while (n > 0) {
            System.out.println(n);
            sb.insert(0, arr[n % 3]);
            n = (n - 1) / 3;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(4));
        System.out.println("----------");
        System.out.println(solution(10));
        System.out.println("----------");
        System.out.println(solution(101));
        System.out.println("----------");
        System.out.println(solution(102));
        System.out.println("----------");

//        System.out.println(solution(500000000));
    }
}
