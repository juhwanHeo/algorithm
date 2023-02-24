package com.programmers.level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @level1
 * @TestName: 가장 가까운 같은 글자
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/142086
 */
public class TheNearestIdenticalLetter {

    static int[] solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        String[] split = s.split("");
        for (int i = 0; i < split.length; i++) {
            String ch = split[i];
            int result = map.getOrDefault(ch, -1);
            map.put(ch, i);
            list.add( (result == -1) ? result : i - result);
        }

        return list.stream()
                .mapToInt(Integer::valueOf)
                .toArray();
    }
}
