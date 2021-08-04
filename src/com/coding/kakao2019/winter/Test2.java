package com.coding.kakao2019.winter;

import java.util.*;

public class Test2 {

    public static int[] solution(String s) {
        List<Integer> list = new ArrayList<>();
        String[] strs = s.replaceAll("[{}]", " ").trim().split(" ,");
        System.out.println(Arrays.toString(strs));
        Arrays.sort(strs, (s1, s2) -> (s1.length() - s2.length()));
        System.out.println(Arrays.toString(strs));
        for(String str : strs) {
            for(String sp : str.split(",")) {
                int val = Integer.parseInt(sp.trim());
                if(list.contains(val)) continue;
                list.add(val);
            }

        }
        return list.stream()
                .filter(Objects::nonNull) // val -> val != null
                .mapToInt(Integer::intValue)
                .toArray();
    }


    public static void main(String[] args) {
        String s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        int[] myRes1 = solution(s1);
        int[] res = {2, 1, 3, 4};


        System.out.println("answer1 my: "+ Arrays.toString(myRes1));
        System.out.println("answer1 answer: " + Arrays.toString(res));
        System.out.println("answer1 equals: " + (myRes1 == res));
        System.out.println("------------------\n");

    }
}

