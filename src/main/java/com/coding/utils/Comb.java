package com.coding.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Comb {

    private static String getComb(List<?> list, boolean[] visited, int n) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                str.append(list.get(i));
            }
        }

        return Arrays.stream(str.toString().split(""))
                .sorted()
                .collect(Collectors.joining());
    }

    public static void comb(List<?> list, List<String> output, boolean[] visited, int depth,  int n, int r) {
        if(r == 0) {
            output.add(getComb(list, visited, n));
            return;
        }
        if(depth == n) return;
        visited[depth] = true;
        comb(list, output, visited,depth + 1, n,r - 1);
        visited[depth] = false;
        comb(list, output, visited,depth + 1, n, r);
    }


    public static void duplicateComb(List<Integer> input, int[] output,  int index, int depth, int n, int r) {
        if(depth == r){
            print(output);
            return;
        }
        if(index == n) return;

        output[depth] = input.get(index);
        duplicateComb(input, output, index, depth + 1, n, r);
        duplicateComb(input, output, index + 1, depth, n, r);
    }


    public static int max = Integer.MIN_VALUE;
    public static int[] answer;
    public static int cnt = 0;
    private static void print(int[] output) {
        for (int i : output) {
            System.out.print(i + "");
        }
        System.out.println();
    }
}
