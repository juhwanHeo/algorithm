package com.programmers.level1;

import java.util.*;

/*
 * @level1
 * @TestName: 추억 점수
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/176963
 */
public class MemoryScore {
    static int[] solution(String[] name, int[] yearning, String[][] photo) {
        List<Integer> result = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) map.put(name[i], yearning[i]);

        for (String[] peoples : photo) {
            int score = 0;
            for (String people : peoples) score += map.getOrDefault(people, 0);


            result.add(score);
        }
        return result.stream()
                .mapToInt(Integer::valueOf)
                .toArray();
    }
}
