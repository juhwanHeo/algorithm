package com.coding.utils;

import java.util.Arrays;

public class PrintUtils {

    public static void printArray1(int[] array1) {
        System.out.println(Arrays.toString(array1));
        System.out.println("=====================\n");
    }

    public static void printArray1(long[] array1) {
        System.out.println(Arrays.toString(array1));
        System.out.println("=====================\n");
    }

    public static void printArray2(int[][] array2) {
        for (int[] array1 : array2) {
            System.out.println(Arrays.toString(array1));
        }

        System.out.println("=====================\n");
    }

    public static void printArray2(char[][] array2) {
        for (char[] array1 : array2) {
            System.out.println(Arrays.toString(array1));
        }

        System.out.println("=====================\n");
    }

    public static void printArray3(int[][][] array3) {
        for (int[][] array2 : array3) {
            System.out.println(Arrays.deepToString(array2));
        }

        System.out.println("=====================\n");
    }
}
