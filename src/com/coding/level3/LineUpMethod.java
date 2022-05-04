package com.coding.level3;

import java.util.*;

/*
 * @level3
 * @TestName: 줄 서는 방법
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12936
 * @COMMENT: 메모리 초과 및 시간초과
 */
public class LineUpMethod {
    static boolean[] visited;
    static int[] solution(int n, long k) {
        int[] arr = new int[n];
        int[] output = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < arr.length; i++) arr[i] = i + 1;
        List<List<Integer>> list = new ArrayList<>();
        perm(arr, output, list,0, n, 3);

        System.out.println("list = " + list);


        return list.get((int) k - 1).stream()
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    static void perm(int[] arr, int[] output, List<List<Integer>> list, int depth, int n, int r) {
        if (depth == r) {
            List<Integer> result = new ArrayList<>();

            for (int i = 0; i < r; i++) result.add(output[i]);
            list.add(result);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output,list, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10, 5)));
    }
}
