package com.study.test;

/*
 * dp
 * */
public class FibonacciDP {

    public static long[] dp;
    public static long fibonacciRecursive(int n) {
        if (n <= 1) return n;
        else if (dp[n] != 0) return dp[n];
        else return dp[n] = fibonacciRecursive(n - 2) + fibonacciRecursive(n - 1);
    }

    public static long fibonacciRepeat(int n) {
        dp = new long[n + 1];

        dp[1]= 1;
        for (int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        return dp[n];
    }

    private static long makeOne(int n) {
        dp = new long[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
        }
        return dp[n];
    }

    public static void main(String[] args) {

//        dp = new long[30];
//        long result = fibonacciRecursive(10);
//        long result = fibonacciRepeat(10);

        long result = makeOne(100);
        System.out.println("result = " + result);
    }
}
