package com.coding.kakao2021.summer;

/*
 * @2021 kakao summber internship
 * @TestName: 숫자 문자열과 영단어
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/81301
 */
public class Test1 {
    public static void main(String[] args) {
        String s = "";
        s.replaceAll("zero", "0")
            .replaceAll("one", "1")
            .replaceAll("two", "2")
            .replaceAll("three","3")
            .replaceAll("four", "4")
            .replaceAll("five", "5")
            .replaceAll("six", "6")
            .replaceAll("seven", "7")
            .replaceAll("eight", "8")
            .replaceAll("nine", "9");
    }
}

