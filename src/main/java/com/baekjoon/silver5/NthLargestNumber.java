package com.baekjoon.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
 * @Silver5
 * @TestName: N번째 큰 수
 * @URL: https://www.acmicpc.net/problem/9625
 */
public class NthLargestNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int[] arr = new int[10];
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 10; j++) {
                arr[j] = Integer.parseInt(stk.nextToken());
            }

            Arrays.sort(arr);

//            PrintUtils.printArray(arr);
//            System.out.println(arr[arr.length - 3]);
            list.add(arr[arr.length - 3]);
        }

        StringBuilder sb = new StringBuilder();
        list.forEach(e -> sb.append(e).append('\n'));

        System.out.println(sb);
    }
}
