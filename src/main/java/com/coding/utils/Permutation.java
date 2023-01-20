package com.coding.utils;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {


    private static int[] print(int[] arr, int r) {
        int[] reulst = new int[r];
        for (int i = 0; i < r; i++) reulst[i] = arr[i];
        return reulst;
    }

    private static<T> List<T> print(T[] arr, int r) {
        return new ArrayList<>(Arrays.asList(arr).subList(0, r));
    }

    public static<T> void perm(T[] arr, T[] output, List<List<T>> result, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            result.add(print(output, r));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i]; // 이 줄은 없어도 됨
                perm(arr, output, result, visited, depth + 1, n, r);
//                output[depth] = 0; // 이 줄은 없어도 됨
                visited[i] = false;

            }
        }
    }

    public static void perm(int[] arr, int[] output, List<int[]> result, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            result.add(print(output, r));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i]; // 이 줄은 없어도 됨
                perm(arr, output, result, visited, depth + 1, n, r);
//                output[depth] = 0; // 이 줄은 없어도 됨
                visited[i] = false;

            }
        }
    }
}
