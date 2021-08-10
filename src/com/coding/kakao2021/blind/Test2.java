package com.coding.kakao2021.blind;

import java.util.*;
import java.util.stream.Collectors;

/*
 * @2021 kakao blind recruitment
 * @TestName: 메뉴 리뉴얼
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/72411
*  @COMMENT: comb 함수 재귀함수로 구현시 통과
*/
public class Test2 {
    static boolean[] visited;
    public static String[] solution(String[] orders, int[] course) {
        Map<String, Integer> map = new HashMap<>();
        List<String> answer = new ArrayList<>();
        // 모든 조합 구함
        for(int i : course) {
            for(String order : orders) {
                visited = new boolean[order.length()];
                comb(order.toCharArray(),0, map, order.length(), i);
            }
            if(map.isEmpty()) continue;
            for (String order : orders) {
                // order 오름차순 정렬
                String str = Arrays.stream(order.split(""))
                        .sorted()
                        .collect(Collectors.joining());
                for(String key : map.keySet()) {
                    if(isOk(key, str)) {
                        map.put(key, map.getOrDefault(key, 0) + 1);
                    }
                }
            }
            int maxVal = Collections.max(map.values()) ;
            map.entrySet()
                    .stream()
                    .filter((m) -> m.getValue() >= 2)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                    .forEach((key, value) -> {
                        if(value == maxVal) answer.add(key);
                    });
            map.clear();
        }

        return answer.stream()
                .sorted()
                .map(String::valueOf)
                .toArray(String[]::new);
    }

    private static boolean isOk(String key, String str) {
        if(str.contains(key)) return true;
        String chars = "[A-Z]*";
        for (char c : key.toCharArray()) {
            chars += c + "[A-Z]*";
        }
        return str.matches(chars);
    }

    // 배열 출력
    static String getComb(char[] arr, int n) {
        String str = "";
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                str += arr[i];
            }
        }

        return Arrays.stream(str.split(""))
                .sorted()
                .collect(Collectors.joining());
    }

    static void comb(char[] arr, int depth, Map<String, Integer> map, int n, int r) {
        if(r == 0) {
            map.put(getComb(arr, n), 0);
            return;
        }
        if(depth == n) return;
        visited[depth] = true;
        comb(arr, depth + 1, map, n,r - 1);
        visited[depth] = false;
        comb(arr, depth + 1, map, n, r);
    }
    // 시간 초과
//    static void comb(char[] arr, int depth, Map<String, Integer> map, int n, int r) {
//        if(r == 0) {
//            map.put(getComb(arr, n), 0);
//            return;
//        }
//        if(depth == n) return;
//        for(int i = 0; i< arr.length; i ++) {
//            if(visited[i]) continue;
//            visited[i] = true;
//            comb(arr, depth + 1, map, n,r - 1);
//            visited[i] = false;
//        }
//    }

    public static void main(String[] args) {
        String[] orders1 = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course1 = {2,3,4};
        String[] myRes1 = solution(orders1, course1);
        System.out.println("myRes1: " + Arrays.toString(myRes1));

        String[] orders2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course2 = {2,3,5};
        String[] myRes2 = solution(orders2, course2);
        System.out.println("myRes2: " + Arrays.toString(myRes2));

        String[] orders3 = {"XYZ", "XWY", "WXA"};
        int[] course3 = {2,3,4};
        String[] myRes3 = solution(orders3, course3);
        System.out.println("myRes3: " + Arrays.toString(myRes3));

    }
}
