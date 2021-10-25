package com.coding.weekly;

import java.util.*;

/*
 * @Weekly 12
 * @TestName: 피로도
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/87946
 */
public class Task12 {

    static boolean[] visited;
    static int[] output;
    static Set<List<Integer>> hs;
    public static int solution(int k, int[][] dungeons) {
        hs = new HashSet<>();
        visited = new boolean[dungeons.length];
        output = new int[dungeons.length];
        int[] arr = new int[dungeons.length];

        for (int i = 0; i < dungeons.length; i++) {
            arr[i] = i;
        }

        perm(arr, 0, arr.length, arr.length);


        int answer = -1;
        for (List<Integer> idxList : hs) {
            int cnt = 0;
            int kBackup = k;

            for (Integer idx : idxList) {
                int minK = dungeons[idx][0];
                int useK = dungeons[idx][1];
                if (kBackup >= minK) {
                    kBackup -= useK;
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);

        }

        System.out.println(hs);
        return answer;
    }

    static void perm(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            hs.add(getPerm(output, r));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, depth + 1, n , r);
                visited[i] = false;
            }
        }
    }

    static List<Integer> getPerm(int[] arr, int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) list.add(arr[i]);

        return list;
    }


    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {
            {80,20},{50,40},{30,10}
        };

        System.out.println("solution(k, dungeons) = " + solution(k, dungeons));
    }
}
