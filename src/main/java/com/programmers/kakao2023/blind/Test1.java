package com.programmers.kakao2023.blind;

import java.util.*;

/*
 * @2023 KAKAO BLIND RECRUITMENT
 * @TestName: 개인정보 수집 유효기간
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/150370
 */
public class Test1 {

    public static int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        int todayValue = getMonth(today);
        for (String term : terms) {
            String[] split = term.split(" ");
            map.put(split[0], Integer.parseInt(split[1]));
        }

        int index = 1;
        for (String privacy : privacies) {
            String[] split = privacy.split(" ");
            String date = split[0];
            String type = split[1];
            int termDay = getMonth(date);
            int diff = (todayValue - termDay) / 28;
            if (map.get(type) <= diff) list.add(index);

            index++;
        }

        return list.stream()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private static int getMonth(String date) {
        String[] split = date.split("\\.");
        int year = Integer.parseInt(split[0]) * 12 * 28;
        int month = Integer.parseInt(split[1]) * 28;
        int day = Integer.parseInt(split[2]);
        return year + month + day;
    }
}