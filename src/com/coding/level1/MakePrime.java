package com.coding.level1;

import java.util.*;

/*
 * @level1
 * @TestName: 소수 만들기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12977
 */
public class MakePrime {
    static List<Integer> list;
    static boolean[] visited;

    static int solution(int[] nums) {
        list = new ArrayList<>();
        visited = new boolean[nums.length];

        comb(nums, 0, nums.length, 3);

        System.out.println(list);
        list.stream()
                .filter(MakePrime::isPrime)
                .forEach(System.out::println);

        return (int) list.stream()
                .filter(MakePrime::isPrime)
                .count();
    }

    private static boolean isPrime(int val) {
        if (val < 2) return false;
        if (val == 2) return true;

        for (int i = 2; i <= Math.sqrt(val); i++) {
            if (val % i == 0) return false;
        }
        return true;
    }

    private static int getComb(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) sum += arr[i];
        }
        return sum;
    }

    private static void comb(int[] arr, int depth, int n, int r) {
        if (r == 0) {
            list.add(getComb(arr, n));
            return;
        }

        if (depth == n) return;

        visited[depth] = true;
        comb(arr,depth + 1, n, r - 1);
        visited[depth] = false;
        comb(arr,depth + 1, n ,r);
    }

    public static void main(String[] args) {
        int[] array = {
//                1, 2, 3, 4
                1,2,7,6,4
        };

        System.out.println(solution(array));
    }
}
