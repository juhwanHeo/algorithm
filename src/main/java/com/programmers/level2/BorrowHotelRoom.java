package com.programmers.level2;

import com.coding.utils.PrintUtils;

/*
 * @level2
 * @TestName: 호텔 대실
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/155651
 * @COMMENT: 누적합
 */
public class BorrowHotelRoom {
    static int MAX_TIME = 60 * 25;
    public static int solution(String[][] book_time) {
        int answer = Integer.MIN_VALUE;
        int[] time = new int[MAX_TIME];

        for (String[] strings : book_time) {
            int startTime = convertTime(strings[0]);
            int endTime = convertTime(strings[1]) + 10;

            time[startTime] += 1;
            time[endTime] -= 1;
        }

        for (int i = 1; i < time.length; i++) {
            time[i] += time[i - 1];
            answer = Math.max(answer, time[i]);
        }

        PrintUtils.printArray(time);
        return answer;
    }

    static int convertTime(String bookTime) {
        String[] split = bookTime.split(":");
        int hour = Integer.parseInt(split[0]) * 60;
        int minute = Integer.parseInt(split[1]);
        return hour + minute;
    }
}
