package com.programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @level3
 * @TestName: 줄 서는 방법
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12936
 * @COMMENT: 메모리 초과 및 시간초과
 */
public class LineUpMethod {

    static boolean[] visited;

    public static int[] solution(int n, long k) {
        int[] answer = new int[n];
//        int[] arr = new int[n];
//        int[] output = new int[n];
//        visited = new boolean[n];

//        for (int i = 0; i < arr.length; i++) arr[i] = i + 1;
//        perm(arr, output, list, k, 0, n, n);
//        List<List<Integer>> list = new ArrayList<>();

//        for (int i = n; i > 0; i--) {
//            System.out.println((n - i) % dp[n]);
//        }


//        for (int i = 0; i < n; i++) {
//            System.out.println("factorial: " + ((k - i) % dp[n - 1]));
//        }


//        return list.get((int) k - 1).stream()
//                .mapToInt(Integer::valueOf)
//                .toArray();
        List<Integer> list = new ArrayList<>();
        long[] dp = factorial(20);
        System.out.println(Arrays.toString(dp));

        for (int i = 1; i <= n; i++) list.add(i);


        System.out.println(list);
        // k가 1부터 시작하므로
        long start = k - 1; //k가 한 블럭의 마지막일 경우 다른 블럭으로 잡힘
        for (int i = 1; i < n; i++) {
            int idx = (int) (start / dp[n - i]);
            answer[i - 1] = list.get(idx);
            list.remove(idx);
            start %= (dp[n - i]);
            System.out.println(Arrays.toString(answer));
        }

        answer[n - 1] = list.get(0);
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    static long[] factorial(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] * i;
        }

        return dp;
    }

    static void perm(int[] arr, int[] output, List<List<Integer>> list, long limit, int depth, int n, int r) {
        if (depth == r) {
            List<Integer> result = new ArrayList<>();

            for (int i = 0; i < r; i++) result.add(output[i]);
            list.add(result);
            return;
        }

        if (list.size() == limit) return;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, list, limit, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }
}
