package com.programmers.kakao2019.blind;

import java.util.*;
import java.util.stream.Collectors;

/*
 * @2019 kakao blind recruitment
 * @TestName: 실패율
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/42889
 */
public class Test1 {
    public static int[] solution(int N, int[] stages) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Double> resMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) map.put(i, 0);
        for (int stage : stages) {
            if (N < stage) continue;
            map.put(stage, map.getOrDefault(stage, 0) + 1);
        }

        int size = stages.length;
        for (Integer key : map.keySet()) {
            int cnt = map.get(key);
            if(cnt == 0) resMap.put(key, 0.0); // 0/0 체크
            else resMap.put(key, (double) cnt / size);
            size -= cnt;
        }

        List<Map.Entry<Integer, Double>> entries = resMap.entrySet().stream()
                                                .sorted(Map.Entry.comparingByKey())
                                                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                                                .collect(Collectors.toList());

        for (Map.Entry<Integer, Double> entry : entries) {
            list.add(entry.getKey());
        }

        return list.stream()
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    public static void main(String[] args) {
       int n1 = 5;
       int[] stages1 = {2, 1, 2, 6, 2, 4, 3, 3};
       int[] res1 = {3, 4, 2, 1, 5};

       int n2 = 4;
       int[] stages2 = {4, 4, 4, 4, 4};
       int[] res2 = {4, 1, 2, 3};

       int[] myRes1 = solution(n1, stages1);
       System.out.println("myRes1: " + Arrays.toString(myRes1));
       System.out.println("myRes1: " + Arrays.equals(myRes1, res1));


        int[] myRes2 = solution(n2, stages2);
        System.out.println("myRes2: " + Arrays.toString(myRes2));
        System.out.println("myRes2: " + Arrays.equals(myRes2, res2));
    }
}

