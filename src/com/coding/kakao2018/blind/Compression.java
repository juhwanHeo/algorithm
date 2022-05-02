package com.coding.kakao2018.blind;

import java.util.*;

/*
 * @2018 kakao blind recruitment
 * @TestName: [3차] 압축
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/17684
 */
public class Compression {

    public static int[] solution(String msg) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> dict = new HashMap<>();

        for (int i = 0; i < 26; i++) dict.put(String.valueOf((char) (i + 65)), i + 1);

        int newWordCnt = 0;
        StringBuilder sb = new StringBuilder(msg);

        while (sb.length() != 0 ) {
            boolean isNewWord = false;
            String w = "";
            int index = 0;
            for (int i = 0; i <  sb.length(); i++) {
                w = sb.substring(0, i + 1);
                if (!dict.containsKey(w)) {
                    newWordCnt++;
                    isNewWord = true;
                    index = i;
                    break;
                }
            }
            if (isNewWord) {
                result.add(dict.get(sb.substring(0, index)));
                dict.put(w, newWordCnt + 26);
                sb.delete(0, index);
            }
            else {
                int idx = dict.get(w);
                result.add(idx);
                sb.delete(0, w.length());
            }
        }

        return result.stream()
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    

    public static void main(String[] args) {
        String msg1 = "KAKAO";
        String msg2 = "TOBEORNOTTOBEORTOBEORNOT";

        // 11 1 27 15
        System.out.println(Arrays.toString(solution(msg1)));
        System.out.println(Arrays.toString(solution(msg2)));

    }
}
