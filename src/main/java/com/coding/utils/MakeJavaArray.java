package com.coding.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * make Java Array form
 * */
public class MakeJavaArray {

    /*
     * programmers Array converter </br>
     * @params string
     * @return int[]
     * */
    @Deprecated
    public static int[] replaceIntArray1(String str) {
        String split[] = str.replaceAll("[^0-9\\s\\n]", "").split(" ");
        int[] result = new int[split.length];

        for (int i = 0; i < split.length; i++) result[i] = Integer.parseInt(split[i]);

        System.out.println("---- replaceIntArray1 ----\n");
        return result;
    }

    /*
     * programmers Array converter </br>
     * @params string
     * @return int[][]
     * */
    public static int[][] replaceIntArray2(String arrayString) {
        List<List<Integer>> lists = new ArrayList<>();
        String[] split = arrayString.split("\\[");

        for (String s : split) {
            String[] numbers = s.replaceAll("[^0-9\\s\\n]", "").split(" ");
            if (numbers[0].length() == 0) continue;

            List<Integer> list = new ArrayList<>();
            for (String value : numbers) list.add(Integer.parseInt(value));

            System.out.println(list);
            lists.add(list);
        }

        System.out.println("---- replaceIntArray2 ----\n");
        return convertToArray(lists);
    }

    public static int[][] replaceIntArray2(String status, String arrayString) {
        System.out.println("\n---- " + status + " ----");
        return replaceIntArray2(arrayString);
    }

    private static String replace(String str) {
        String[] split = str.replaceAll("\\[", "{")
                .replaceAll("]", "}")
                .trim()
                .replaceAll("},", "},#")
                .split("#");
        StringBuilder sb = new StringBuilder();
        for (String s : split) sb.append(s).append('\n');

        return sb.toString();
    }

    private static int[][] convertToArray(List<List<Integer>> lists) {
        int[][] result = new int[lists.size()][];
        for (int i = 0; i < lists.size(); i++) result[i] = new int[lists.get(i).size()];
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                result[i][j] = lists.get(i).get(j);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("입력>>");
        String str = sc.nextLine();

        System.out.println(replace(str));
        sc.close();
    }
}
