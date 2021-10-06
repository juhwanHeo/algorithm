package com.coding.level2;

import java.util.*;

/*
 * @level2
 * @TestName: 큰 수 만들기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/42883
 */
public class BigNumMake {
    static boolean[] visited;

    public static String solution(String number, int k) {
        System.out.println("\n---------------");
        StringBuilder sb = new StringBuilder(number);

        int idx = 0;
        while (k > 0) {
            System.out.println(sb);
            if (sb.length() - 1 == idx) return sb.substring(0, sb.length() - k);
            idx++;
            if (sb.charAt(idx - 1) - '0' < sb.charAt(idx) - '0') {
                sb.delete(idx - 1, idx);
                idx = 0;
                k--;
            }
        }

//        Set<String> hs = new HashSet<>();
//        visited = new boolean[number.length()];
//        comb(number.split(""), hs, 0, number.length(), number.length() - k);
//        System.out.println(hs);
        return sb.toString();

    }

    static String getComb(String[] arr, int n) {
        String str = "";
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                str += arr[i];
            }
        }

        return str;
    }

    static void comb(String[] arr, Set<String> hs, int depth, int n, int r) {
        if(r == 0) {
            hs.add(getComb(arr, n));
            return;
        }
        if(depth == n) return;

        visited[depth] = true;
        comb(arr, hs,depth + 1, n,r - 1);

        visited[depth] = false;
        comb(arr, hs,depth + 1, n, r);
    }

    public static void main(String[] args) {
        String str1 = "1924";
        String str2 = "1231234";
        String str3 = "1000";
        int k1 = 2;
        int k2 = 3;
        int k3 = 1;
        String res1 = "94";
        String res2 = "3234";


        System.out.println(solution(str1, k1));
        System.out.println(solution(str2, k2));
        System.out.println(solution(str3, k3));
        System.out.println(solution("987654321", 8));

    }
}
