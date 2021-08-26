package com.coding.level1;

import java.util.Arrays;

/*
 * @level1
 * @TestName: 서울에서 김서방 찾기

 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12919
 */
public class FindKimSeoBang {
    static String solution(String[] seoul) {
//        int index = 0;
//        for (String s : seoul) {
//            if (s.equals("Kim")) break;
//            index++;
//        }

        int index = Arrays.asList(seoul).indexOf("Kim");
        return "김서방은 " + index + "에 있다";
    }

    public static void main(String[] args) {
        String[] seoul1 = {"Jane", "Kim"};
        System.out.println(solution(seoul1));
    }
}
