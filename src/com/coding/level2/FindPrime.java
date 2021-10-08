package com.coding.level2;

import java.util.*;

/*
 * @level2
 * @TestName: 소수 찾기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/42839
 */
public class FindPrime {
    static boolean[] visited;
    static int solution(String numbers) {
        Set<Integer> hs = new HashSet<>();
        int[] output = new int[numbers.length()];

        for (int i = 0; i <= numbers.length(); i++) {
            visited = new boolean[numbers.length()];
            perm(numbers.split(""), output, hs, 0, numbers.length(), i);
            System.out.println(hs);

        }
        return (int) hs.stream()
                .filter(FindPrime::isPrime)
                .count();
    }

    static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i  == 0) return false;
        }
        return true;
    }

    static void perm(String[] arr, int[] output, Set<Integer> set, int depth, int n, int r) {
        if (depth == r) {
            set.add(getPerm(output, r));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = Integer.parseInt(arr[i]);
                perm(arr, output, set, depth + 1, n , r);
                visited[i] = false;
            }
        }
    }

    static int getPerm(int[] arr, int n) {
        StringBuilder sb = new StringBuilder("0");
        for (int i = 0; i < n; i++) sb.append(arr[i]);

        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        String nums1 = "17"; //3

        System.out.println(solution(nums1));

    }
}

