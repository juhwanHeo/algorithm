package com.coding.kakak2018.blind;

import java.util.PriorityQueue;

/*
 * @2018 kakao blind recruitment
 * @TestName: [1차] 셔틀버스
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/17678
 */
public class ShuttleBus {

    public static String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (String s : timetable) {
            int convert = convertStringToTime(s);
            pq.offer(convert);
        }

        int currentTime =  convertStringToTime("09:00");
        int lastTime = 0;
        int people = 0;
        for (int i = 0; i < n; i++) {
            people = 0;

            while (!pq.isEmpty()) {
                int userTime = pq.peek();
                if (userTime <= currentTime && people < m) {
                    pq.poll();
                    people++;
                }
                else break;
                lastTime = userTime - 60;
            }
            currentTime += t * 60;
        }

        if (people < m) lastTime = currentTime - (t * 60);

        return convertTimeToString(lastTime);
    }

    private static String convertTimeToString(int time) {
        System.out.println("fun Time: " + time);
        int hour = time / (60 * 60);
        int minute = time % (60 * 60) / 60;

        return (hour < 10 ? "0" + hour : hour) +
                ":" +
                (minute < 10 ? "0" + minute : minute);
    }
    
    private static int convertStringToTime(String sTime) {
        String[] split = sTime.split(":");
        int time =  Integer.parseInt(split[0]) * 60 * 60;
        time += Integer.parseInt(split[1]) * 60;
        return time;
    }



    public static void main(String[] args) {
        int n1 = 1;
        int t1 = 1;
        int m1 = 5;

        int n2 = 2;
        int t2 = 10;
        int m2 = 2;


        int n3 = 2;
        int t3 = 1;
        int m3 = 2;

        int n5 = 1;
        int t5 = 1;
        int m5 = 1;
        String[] timetable1 = {
                "08:00", "08:01", "08:02", "08:03" // "09:00"
        };
        String[] timetable2 = {
                "09:10", "09:09", "08:00" // "09:09"
        };
        String[] timetable3 = {
                "09:00", "09:00", "09:00", "09:00" // "08:59"
        };

        String[] timetable5 = {
                "23:59" // "09:00"
        };

//        System.out.println(solution(n1, t1, m1, timetable1));
//        System.out.println(solution(n2, t2, m2, timetable2));
//        System.out.println(solution(n3, t3, m3, timetable3));
//        System.out.println(solution(n3, t3, m3, timetable3));
        System.out.println(solution(n5, t5, m5, timetable5));

    }
}
