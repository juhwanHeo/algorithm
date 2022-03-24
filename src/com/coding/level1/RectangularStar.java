package com.coding.level1;

import java.util.Scanner;

/*
 * @level1
 * @TestName: 직사각형 별찍기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12969
 */
public class RectangularStar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < a; i++) sb.append("*");

        for (int i = 0; i < b; i++) System.out.println(sb);



    }
}
