package com.programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @level2
 * @TestName: 귤고르기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/138476
 */
public class PickTangerine {

    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        int count = k;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        for (Map.Entry<Integer, Integer> entry : entryList) {
            if (count <= 0) break;
            count -= entry.getValue();
            answer++;
        }
        
        return answer;
    }
}
