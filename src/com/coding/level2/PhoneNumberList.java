package com.coding.level2;

import java.util.*;

/*
 * @level2
 * @TestName: 전화번호 목록
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/42577
 */
public class PhoneNumberList {

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        Map<String, Integer> map = new HashMap<>();
        for (String number : phone_book) {
            map.put(number, 0);
        }

        for (String key : phone_book) {
            for (int i = 0; i < key.length(); i++) {
                if (map.containsKey(key.substring(0, i))) return false;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] phoneNumbers = {
//                "119", "97674223", "1195524421"
                "123","456","789"
        };

        System.out.println(solution(phoneNumbers));
    }
}
