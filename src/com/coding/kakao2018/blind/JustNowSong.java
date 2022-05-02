package com.coding.kakao2018.blind;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @2018 kakao blind recruitment
 * @TestName: [3차] 방금그곡
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/17683
 */
public class JustNowSong {
    static class Music implements Comparable<Music> {
        int index;
        int playTime;
        String title;

        public Music(int index, int playTime, String title) {
            this.index = index;
            this.playTime = playTime;
            this.title = title;
        }

        @Override
        public String toString() {
            return "Music{" +
                    "index=" + index +
                    ", playTime=" + playTime +
                    ", title='" + title + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Music o) {
            if (this.playTime != o.playTime) return Integer.compare(o.playTime, this.playTime);
            return Integer.compare(this.index, o.index);
        }
    }

    public static String solution(String m, String[] musicinfos) {
        List<Music> list = new ArrayList<>();
        List<String> mList = convertList(m);

        System.out.println("mList = " + mList);
        int index = 0;
        for (String musicinfo : musicinfos) {
            String[] split = musicinfo.split(",");
            String startTime = split[0];
            String endTime = split[1];
            String title = split[2];
            String code = split[3];
            int playTime = convertTime(endTime) - convertTime(startTime);
            List<String> playList = new ArrayList<>();
            List<String> codeList = convertList(code);

            for (int i = 0; i < playTime; i++) {
                int idx = i % codeList.size();
                playList.add(codeList.get(idx));
            }

            System.out.println("title = " + title);
            System.out.println("codeList = " + codeList);
            System.out.println("playList = " + playList);
            if (playList.size() < mList.size()) continue;

            int correct = 0;
            boolean isCorrect = false;
            for (String play : playList) {
//                int idx = i % mList.size();
//                System.out.println("play = " + play);
//                System.out.println("mList.get(correct) = " + mList.get(correct));
//                System.out.println("correct = " + correct);
//                System.out.println("------------------------------");
                if (play.equals(mList.get(correct))) {
                    correct++;
                    if (mList.size() == correct) {
                        isCorrect = true;
                        break;
                    }
                } else {
                    correct = 0;
                    if (play.equals(mList.get(correct))) correct++;
                }

            }

            if (isCorrect) {
                list.add(new Music(index++, playTime, title));
            }

            System.out.println("==============\n");
        }

        System.out.println("list = " + list);
        Collections.sort(list);
        return !list.isEmpty() ? list.get(0).title : "(None)";
    }

    private static List<String> convertList(String str) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder(str);
        while (sb.length() != 0) {
            if (sb.length() >= 2 && sb.charAt(1) == '#') {
                String sub = sb.substring(0, 2);
                sb.delete(0, 2);
                list.add(sub);
            } else {
                String sub = sb.substring(0, 1);
                sb.delete(0, 1);
                list.add(sub);
            }
        }
        return list;
    }

    private static int convertTime(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    public static String solution2(String m, String[] musicinfos) {
        List<Music> list = new ArrayList<>();
        String answer = removeSarp(m);

        int index = 0;
        for (String musicinfo : musicinfos) {
            String[] split = musicinfo.split(",");
            String startTime = split[0];
            String endTime = split[1];
            String title = split[2];
            String code = removeSarp(split[3]);
            int playTime = convertTime(endTime) - convertTime(startTime);
            StringBuilder sb = new StringBuilder(code);
            StringBuilder play = new StringBuilder();

            for (int i = 0; i < playTime; i++) {
                int idx = i % sb.length();
                play.append(code.charAt(idx));

            }

            if (play.toString().contains(answer)) {
                list.add(new Music(index++, playTime, title));
            }
        }


        Collections.sort(list);
        return !list.isEmpty() ? list.get(0).title : "(None)";
    }

    private static String removeSarp(String str) {
        return str.replaceAll("C#", "H")
                .replaceAll("D#", "I")
                .replaceAll("F#", "J")
                .replaceAll("G#", "K")
                .replaceAll("A#", "L");
    }
    

    public static void main(String[] args) {
        String m1 = "ABCDEFG";
        String m2 = "CC#BCC#BCC#BCC#B";
        String m3 = "ABC";
        String m4 = "CCB";
        String m5 = "DF";
        String m6 = "A#";
        String[] musicinfos = {
                // 1
//                "12:00,12:14,HELLO,CDEFGAB"
//                , "13:00,13:05,WORLD,ABCDEF"

                // 2
//                "03:00,03:30,FOO,CC#B"
//                ,"04:00,04:08,BAR,CC#BCC#BCC#B"

                // 3
//                "12:00,12:14,HELLO,C#DEFGAB"
//                , "13:00,13:05,WORLD,ABCDEF"

                // 4
//                "03:00,03:10,FOO,CCB#CCB"
//                , "04:00,04:08,BAR,ABC"

                // 5
//                "6:20,6:50,TEST,DDF"

                // 6 HAPPY
                "13:00,13:02,HAPPY,G#A#"

        };

//        System.out.println("solution(m1, musicinfos) = " + solution(m1, musicinfos));
//        System.out.println("solution(m2, musicinfos) = " + solution(m2, musicinfos));
//        System.out.println("solution(m3, musicinfos) = " + solution(m3, musicinfos));
//        System.out.println("solution(m4, musicinfos) = " + solution(m4, musicinfos));
//        System.out.println("solution(m5, musicinfos) = " + solution(m5, musicinfos));
        System.out.println("solution(m6, musicinfos) = " + solution(m6, musicinfos));
        System.out.println("solution2(m6, musicinfos) = " + solution2(m6, musicinfos));


    }
}
