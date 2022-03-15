package com.coding.level2;

import java.util.*;

/*
 * @level2
 * @TestName: 영어 끝말잇기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12981
 */
public class EnglishWordChain {
    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        LinkedList<String> list = new LinkedList<>();

        int num = 0;
        int seq = 0;
        for (int i = 0; i < words.length; i++) {
            if (list.contains(words[i]))  {
                num = (i % n) + 1 ;
                seq = (int) Math.ceil((i + 1) / (double) n);
                break;
            }
            if (!list.isEmpty() && list.getLast().charAt(list.getLast().length() - 1) != words[i].charAt(0)) {
                num = (i % n) + 1 ;
                seq = (int) Math.ceil((i + 1) / (double) n);
                break;
            }
            list.add(words[i]);
            System.out.println(i + ", seq = " + seq);
        }

        answer[0] = num;
        answer[1] = seq;
        return answer;
    }


    public static void main(String[] args) {
        int n1 = 3;
        int n2 = 2;
        String[] words = {
            // [3,3]
              "tank", "kick", "know"
            , "wheel", "land", "dream"
            , "mother", "robot", "tank"
        };
        String[] words2 = {
                // [1, 3]
                "hello", "one", "even", "never", "now", "world", "draw"
        };

        System.out.println(Arrays.toString(solution(n1, words)));
        System.out.println(Arrays.toString(solution(n2, words2)));
    }
}
