package com.coding.level2;

/*
 * @level2
 * @TestName: 피보나치 수
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12945
 */
public class FibonacciNumber {
    static int solution(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        if (n < 2) return fibo(n);
        return fibo(n) % 1234567;
    }
    static int fiboRecursion(int n) {
        if(n <= 1) return n;
        else return (fiboRecursion(n - 2)  + fiboRecursion(n - 1)) % 1234567;
    }

    static int fibo(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 1;

        for (int i = 3; i <= n; i++) {
            nums[i] = (nums[i - 1] + nums[i - 2]) % 1234567;
        }

        return nums[n] ;
    }

    public static void main(String[] args) {
        System.out.println(solution(5));
    }
}
