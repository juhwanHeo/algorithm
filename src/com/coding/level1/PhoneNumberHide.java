package com.coding.level1;

/*
 * @level1
 * @TestName: 핸드폰 번호 가리기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12948
 */
public class PhoneNumberHide {

    // return phone_number.replaceAll(".(?=.{4})", "*");
    // 정규식이 더 빠름
    static String solution(String phone_number) {
        return phone_number.substring(0, phone_number.length() - 4).replaceAll("[0-9]", "*")
                + phone_number.substring(phone_number.length() - 4);
    }

    public static void main(String[] args) {
        System.out.println(solution("01033334444")); // 8
    }
}
