package com.programmers.level1;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/*
 * @level1
 * @TestName: 두 개 뽑아서 더하기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/68644
 */
public class TwoNumPlus {
    static boolean[] visited;
    static int[] solution(int[] numbers) {
        Set<Integer> ts = new TreeSet<>();
        visited = new boolean[numbers.length];
        comb(numbers, 0, ts, numbers.length, 2);

        return ts.stream()
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    static int getComb(int[] arr, int n) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) res += arr[i];
        }

        return res;
    }

    // 조합 구하기
    static void comb(int[] arr, int depth, Set<Integer> set, int n, int r) {
        if(r == 0) {
            set.add(getComb(arr, n));
            return;
        }

        if(depth == n) return;

        visited[depth] = true;
        comb(arr, depth + 1, set, n,r - 1);
        visited[depth] = false;
        comb(arr, depth + 1, set, n, r);
    }

    public static void main(String[] args) {
        int[] nums = {2,1,3,4,1};
        int[] res1 = {2,3,4,5,6,7};
        System.out.println(Arrays.toString(solution(nums)));
    }
}
