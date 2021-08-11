package com.coding.kakao2020.internship;

import java.util.*;

/*
 * @2020 kakao internship
 * @TestName: 보석 쇼핑
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/67258
 * @COMMENT: 효율성 테스트에서 통과하지 못해 질문하기에 있던 jujubebat님의 문제 풀이
 *           * 투 포인터 학습 필요
 */
public class Test3NotEfficiency {
    public static int[] solution(String[] gems) {
        Set<String> setGems = new HashSet<>(Arrays.asList(gems));
        for (int i = setGems.size(); i <= gems.length; i++) {
            int[] answer = findList(gems, setGems, i);
            if(answer != null) return answer;
        }
        return new int[] {-1, -1};
    }

    public static int[] findList(String[] gems, Set<String> setGems ,int cnt) {
        if(gems.length == 1) return new int[] {1, 1};
        if(setGems.size() == 1) return new int[] {1, 1};
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < gems.length-cnt+1; i++) {
            List<String> strList = new ArrayList<>(Arrays.asList(gems).subList(i, cnt+i));
            for(String str : strList) {
                if (map.get(str) != null) {
                    int keyCnt = map.get(str);
                    map.put(str, keyCnt+1);
                }
                else map.put(str, 0);
            }
            System.out.println("strList: " + strList + ", listCnt: " +strList.size());
            if(setGems.stream().allMatch(map::containsKey))
                return new int[] {i + 1, cnt + i};
            map.clear();
        }
        System.out.println("--------------\n");
        return null;
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
