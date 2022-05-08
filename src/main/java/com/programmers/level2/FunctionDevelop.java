package com.programmers.level2;

import java.util.*;

/*
 * @level2
 * @TestName: 기능 개발
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/42586
 */
public class FunctionDevelop {
    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < progresses.length; i++) {
            int day = (int) Math.ceil(((double) 100 - progresses[i]) / speeds[i]);
            queue.offer(day);
        }

        while(!queue.isEmpty()) {
            int day = queue.poll();
            map.put(day, map.getOrDefault(day, 0) + 1);
            while (!queue.isEmpty()) {
                int after = queue.peek();
                if (day > after) {
                    map.put(day, map.getOrDefault(day, 0) + 1);
                    queue.poll();
                }
                else break;
            }
        }

        System.out.println(map);
        List<Integer> list = new ArrayList<>();
        int[] keys = map.keySet().stream().sorted()
                .mapToInt(Integer::intValue)
                .toArray();
        for (Integer key : keys)
            list.add(map.get(key));

        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        int[] progresses = {
//                93, 30, 55
                95, 90, 99, 99, 80, 99
        };
        int[] speeds = {
//                1, 30 ,5
                1, 1, 1, 1, 1, 1
        };

        int[] res = {
//                2, 1
                1,3,2
        };
        System.out.println(Arrays.toString(solution(progresses, speeds)));

    }
}
