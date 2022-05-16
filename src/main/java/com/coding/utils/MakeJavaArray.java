package com.coding.utils;

import java.util.Scanner;

/*
 * make Java Array form
 * */
public class MakeJavaArray {

    private static void replace(String str) {
        String[] split = str.replaceAll("\\[", "{")
                .replaceAll("]", "}")
                .trim()
                .replaceAll("},", "},#")
                .split("#");

        for (String s : split) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("입력>>");
        String str = sc.nextLine();

        replace(str);
        sc.close();
    }
}
