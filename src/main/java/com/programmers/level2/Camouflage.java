package com.programmers.level2;

import java.util.*;
import java.util.stream.Collectors;

/*
 * @level2
 * @TestName: 위장
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/42578?language=java
 */
public class Camouflage {

    public static int solution(String[][] clothes) {
        Map<String, List<String>> map = new HashMap<>();
        for (String[] clothe : clothes) {
            List<String> list = map.getOrDefault(clothe[1], new ArrayList<>());
            list.add(clothe[0]);
            map.put(clothe[1], list);
        }

        int answer = clothes.length;
        if (map.size() > 1) {
            int comb = 1;
            for (String key : map.keySet()) {
                answer += map.get(key).size();
                comb *= map.get(key).size() + 1;
                System.out.println("comb = " + comb);
            }

            answer = comb - 1;
        }
        System.out.println("answer = " + answer);
        System.out.println("map = " + map);

        int i = Arrays.stream(clothes)
                .collect(Collectors.groupingBy(p -> p[1], Collectors.mapping(p -> p[0], Collectors.counting())))
                .values().stream()
                .reduce(1L, (x, y) -> x * (y + 1)).intValue() - 1;


        return i;
    }


    public static void main(String[] args) {
        String[][] clothes = {

//                {"yellowhat", "headgear"},
//                {"bluesunglasses", "eyewear"},
//                {"green_turban", "headgear"}

                {"crowmask", "face"},
                {"bluesunglasses", "face"},
                {"smoky_makeup", "face"}
        };

        System.out.println("solution(clothes) = " + solution(clothes));

    }
}
