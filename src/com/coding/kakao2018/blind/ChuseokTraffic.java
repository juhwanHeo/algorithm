package com.coding.kakao2018.blind;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/*
 * @2018 kakao blind recruitment
 * @TestName: [1차] 추석 트래픽
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/17676
 */
public class ChuseokTraffic {


    static class Log{
        int startTime;
        int endTime;
        int processTime;

        public Log(int startTime, int endTime, int processTime) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.processTime = processTime;
        }

        @Override
        public String toString() {
            return "Log{" +
                    "startTime=" + startTime +
                    ", endTime=" + endTime +
                    ", processTime=" + processTime +
                    "}\n";
        }


        public boolean containTIme(Log o) {
            return endTime > o.startTime;
        }
    }

    public static int solution(String[] lines) {
        int answer = 1;
        List<Log> list = new ArrayList<>();
        for (String line : lines) {
            String[] split = line.split(" ");
            String hour = split[1];
            String process = split[2];

            int processTime = processTime(process);
            int time = convertStringToTime(hour);

            /*
            * time - processTime + 1
            * + 1 은 0.001초
            * 시간 시간은 0.001초 뒤에 시작함
            */
            list.add(new Log(time - processTime + 1, time + 1000, processTime));

        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).containTIme(list.get(j))) answer++;
            }
            max = Math.max(max, answer);
            answer = 1;

        }
        return max;
    }

    private static int processTime(String processTime) {
        double time = Double.parseDouble(processTime.replaceAll("s", ""));
        return (int) (time * 1000);
    }


    private static int convertStringToTime(String hour) {
        String[] split = hour.split(":");
        int time = Integer.parseInt(split[0]) * 60 * 60;
        time += Integer.parseInt(split[1]) * 60;
        String[] second = split[2].split("\\.");
        time += Integer.parseInt(second[0]);
        time *= 1000;
        time += Integer.parseInt(second[1]);

        return time;
    }


    public static void main(String[] args) throws ParseException {
        String[] lines = {
//                "2016-09-15 01:00:04.001 2.0s",
//                "2016-09-15 01:00:07.000 2s"
//
//                "2016-09-15 01:00:04.002 2.0s",
//                "2016-09-15 01:00:07.000 2s"
//
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"
        };

        System.out.println(solution(lines));
    }
}
