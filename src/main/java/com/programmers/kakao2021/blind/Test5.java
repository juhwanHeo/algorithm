package com.programmers.kakao2021.blind;

/*
 * @2021 kakao blind recruitment
 * @TestName: 광고 삽입
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/72414
 * @COMMENT:
 */
public class Test5 {

    public static String solution(String play_time, String adv_time, String[] logs) {
        int playTime = convertTime(play_time);
        int advTime = convertTime(adv_time);
        long[] playCnt = new long[playTime + 1];

        for (String log : logs) {
            String[] split = log.split("-");
            playCnt[convertTime(split[0])]++;
            playCnt[convertTime(split[1])]--;
        }

        /*
        * 전체 배열 순회하며 이전 인덱스 값을 누적함
        * 현재 동영상을 시청하고 있는 수가 저장됨
        * @loop1
        * [0, 0, 1, 0, -1, -1, 0, ...]
        * [0, 0, 1, 1, 0, -1, -1, ...]
        * */
        for (int i = 1; i <= playTime; i++) playCnt[i] += playCnt[i-1];

        /*
         * 한번더 전체 배열 순회하며 이전 인덱스 값을 누적함
         * 현재 시간까지 동영상을 시청한 총 재생 시간이 저장됨
         * @loop1
         * [0,  0,  1,  0, -1,  -1,  0, ...]
         * [0,  0,  1,  1,  0,  -1, -1, ...]
         * @loop2
         * [0,  0,  1,  1,  0, -1, -1, ...]
         * [0,  0,  1,  2,  2,  1,  0, ...]
         * */
        for (int i = 1; i <= playTime; i++) playCnt[i] += playCnt[i-1];

        long maxTime = playCnt[advTime - 1], maxStartTime = 0;
        System.out.println("maxTime: " + maxTime);
        for (int i = 0; i+advTime <= playTime; i++) {
            long tmp =  playCnt[i + advTime] - playCnt[i];

            if (tmp > maxTime) {
                maxTime = tmp;
                maxStartTime = i + 1;
            }
        }
        System.out.println("maxStartTime: " + maxStartTime);
        return returnFormat(maxStartTime);
    }

    private static String returnFormat(long maxStartTime) {
        return String.format("%02d:%02d:%02d",
                maxStartTime / (60 * 60),
                (maxStartTime / 60) % 60,
                maxStartTime % 60);
    }


    private static int convertTime(String sTime) {
        String[] split = sTime.split(":");
        int time =  Integer.parseInt(split[0]) * 60 * 60;
        time += Integer.parseInt(split[1]) * 60;
        time += Integer.parseInt(split[2]);
        return time;
    }

    public static void main(String[] args) {
        String play_time1 = "02:03:55";
        String adv_time1 = "00:14:15";
        String[] logs1 = {
                "01:20:15-01:45:14",
                "00:40:31-01:00:00",
                "00:25:50-00:48:29",
                "01:30:59-01:53:29",
                "01:37:44-02:02:30"
        };
        String result1 = "01:30:59";
        String myRes = solution(play_time1, adv_time1, logs1);
        System.out.println(myRes);
        System.out.println(myRes.equals(result1));

    }

}
