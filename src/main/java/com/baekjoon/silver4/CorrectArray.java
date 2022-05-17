package com.baekjoon.silver4;

import com.coding.utils.PrintUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * @Silver4
 * @TestName: 올바른 배열
 * @URL: https://www.acmicpc.net/problem/1337
 */
public class CorrectArray {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N];

        for (int i = 0; i < N; i++) array[i] = Integer.parseInt(br.readLine());

        Arrays.sort(array);
        PrintUtils.printArray1(array);

        int left = 0, max = 0, right = 1;
        int cnt = 1;


        while (right != array.length) {
            System.out.println("array[left] = " + array[left]);
            System.out.println("array[right] = " + array[right]);
            if (array[right] - array[left] < 5 && array[right] - array[left] > 0) {
                System.out.println("if !!");
                cnt++;
                right++;
            }
            else {
                System.out.println("else !!");
                cnt = 1;
                left++;
                right = left + 1;
            }
            System.out.println("===============\n");

            max = Math.max(max, cnt);
        }

        if (array.length == 1) System.out.println(4);
        else if (max >= 5) System.out.println("0");
        else System.out.println(5 - max);
    }
}

