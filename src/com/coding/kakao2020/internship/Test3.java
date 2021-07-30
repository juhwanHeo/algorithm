package com.coding.kakao2020.internship;

import java.util.*;

public class Test3 {
    /*
    * 효율성 테스트에서 통과하지 못해
    * 질문하기에 있던 jujubebat님의 문제 풀이
    */
    public static int[] solution(String[] gems) {
        Set<String> setGems = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> map = new HashMap<>();
        int[] answer = new int[2];
        int min = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int kind = setGems.size();

        while (true) {
            if(map.size() >= kind){
                map.put(gems[start], map.get(gems[start]) - 1);
                if(map.get(gems[start]) == 0)
                    map.remove(gems[start]);
                start++;
            }
            else if (end == gems.length) break;
            else {
                if (map.get(gems[end]) != null)
                    map.put(gems[end], map.get(gems[end]) + 1);
                else map.put(gems[end], 1);
                end++;
            }

            if(map.size() == kind) {
                if(Math.abs(end - start) < min) {
                    min = Math.abs(end - start);
                    answer[0] = start + 1;
                    answer[1] = end;
                }
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        String[] test1 = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        int[] answer1 = solution(test1);
        int[] res1 = {3, 7};

        String[] test2 = {"AA", "AB", "AC", "AA", "AC"};
        int[] answer2 = solution(test2);
        int[] res2 = {1, 3};


        String[] test3 = {"XYZ", "XYZ", "XYZ"};
        int[] answer3 = solution(test3);
        int[] res3 = {1, 1};

        String[] test4 = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
        int[] answer4 = solution(test4);
        int[] res4 = {1, 5};

        // [3, 7]
        System.out.println("answer1 my: " + Arrays.toString(answer1));
        System.out.println("answer1: " + Arrays.toString(res1));

        System.out.println("answer2 my: " + Arrays.toString(answer2));
        System.out.println("answer2: " + Arrays.toString(res2));

        System.out.println("answer3 my: " + Arrays.toString(answer3));
        System.out.println("answer3: " + Arrays.toString(res3));

        System.out.println("answer4 my: " + Arrays.toString(answer4));
        System.out.println("answer4: " + Arrays.toString(res4));

    }
}
