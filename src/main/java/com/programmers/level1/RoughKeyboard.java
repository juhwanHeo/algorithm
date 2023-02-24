package com.programmers.level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @level1
 * @TestName: 대충 만든 자판
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/160586
 */
public class RoughKeyboard {
    static int[] solution(String[] keymap, String[] targets) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();


        for (String keys : keymap) {
            for (int i = 0; i < keys.length(); i++) {
                String key = String.valueOf(keys.charAt(i));
                int value = map.getOrDefault(key, Integer.MAX_VALUE);
                map.put(key, Math.min(value, i + 1));
            }
        }
        for (String target : targets) {
            int count = 0;
            for (int i = 0; i < target.length(); i++) {
                String key = String.valueOf(target.charAt(i));
                int value = map.getOrDefault(key, -1);

                if (value == -1) {
                    count = value;
                    break;
                }
                count += value;

            }
            list.add(count);
        }

        return list.stream()
                .mapToInt(Integer::valueOf)
                .toArray();
    }
}
