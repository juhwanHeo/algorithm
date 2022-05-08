package com.programmers.level2;

/*
 * @level2
 * @TestName: N개의 최소공배수
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12953
 */
public class MinCommonN {
    public static int solution(int[] arr) {
        if (arr.length == 1) return arr[0];

        int lcm = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int gcd = gcd(lcm, arr[i]);
            lcm = (lcm * arr[i]) / gcd;
        }

        return lcm;
    }

    private static int gcd(int big, int small) {
        return (big % small == 0) ? small : gcd(small, big % small);
    }

    public static void main(String[] args) {
        int[] arr = {
                2, 6, 8, 14
        };

        System.out.println("solution(arr) = " + solution(arr));
    }
}
