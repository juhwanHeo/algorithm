package com.coding.utils;

import java.util.Arrays;

public class PrintUtils {

    public static void printArray(int[] array1) {
        System.out.println(Arrays.toString(array1));
        System.out.println("=====================\n");
    }

    public static void printArray(boolean[] array1) {
        System.out.println(Arrays.toString(array1));
        System.out.println("=====================\n");
    }

    public static void printArray(long[] array1) {
        System.out.println(Arrays.toString(array1));
        System.out.println("=====================\n");
    }

    public static void printArray(int[][] array2) {
        for (int[] array1 : array2) {
            System.out.println(Arrays.toString(array1));
        }

        System.out.println("=====================\n");
    }

    public static void printArray(char[][] array2) {
        for (char[] array1 : array2) {
            System.out.println(Arrays.toString(array1));
        }

        System.out.println("=====================\n");
    }

    public static void printArray(int[][][] array3) {
        for (int[][] array2 : array3) {
            System.out.println(Arrays.deepToString(array2));
        }

        System.out.println("=====================\n");
    }
}
