package com.baekjoon.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * @Silver5
 * @TestName: D-Day
 * @URL: https://www.acmicpc.net/problem/1308
 */
public class D_Day {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int year = Integer.parseInt(stk.nextToken());
        int month = Integer.parseInt(stk.nextToken());
        int day = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine(), " ");
        int nextYear = Integer.parseInt(stk.nextToken());
        int nextMonth = Integer.parseInt(stk.nextToken());
        int nextDay = Integer.parseInt(stk.nextToken());

        int allDay = yearAndMonthToDay(year, month, day);
        int allNextDay = yearAndMonthToDay(nextYear, nextMonth, nextDay);
        int lastDay = allNextDay - allDay;

        System.out.println(allDay);
        System.out.println(allNextDay);

        System.out.println(yearAndMonthToDay(0, month, day));
        System.out.println(yearAndMonthToDay(0, nextMonth, nextDay));

        System.out.println("nextYear - year = " + (nextYear - year));
        if (nextYear - year > 1000) System.out.println("gg");
        else if (nextYear - year == 1000 && yearAndMonthToDay(0, month, day) <= yearAndMonthToDay(0, nextMonth, nextDay)) System.out.println("gg");
        else System.out.println("D-" + lastDay);
    }

    private static int yearAndMonthToDay(int year, int month, int day) {
        int result = 0;
        int[] monthArr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int i = 0; i < year; i++) result += isLeap(i) ? 366 : 365;

        if (isLeap(year)) monthArr[1] = 29;
        for (int i = 0; i < month - 1; i++) result += monthArr[i];

        return result + day;
    }

    private static boolean isLeap(int year) {
        if (year % 4 == 0) return true;
        if (year % 100 == 0) return false;
        if (year % 400 == 0) return true;
        return false;
    }
}
