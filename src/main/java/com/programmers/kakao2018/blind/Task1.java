package com.programmers.kakao2018.blind;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @2018 kakao blind recruitment
 * @TestName: [1차] 비밀지도
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/17681
 */
public class Task1 {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        List<String> answer = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        StringBuilder deciFormat = new StringBuilder();

        int max = (int) Math.pow(2, n);
        for (int i = 0; i < n; i++ ) deciFormat.append("0");
        DecimalFormat df = new DecimalFormat(deciFormat.toString());
        for (int i = 0; i < arr1.length; i++) list.add(arr1[i] | arr2[i]);

        list.stream()
                .map(val-> val >= max ? max-1 : val)
                .map(Integer::toBinaryString)
                .map(Long::parseLong) // Interger::parseInt --> 테케 2,6 런타임에러 발생
                .map(df::format)
                .map(val-> val.replaceAll("1", "#")
                        .replaceAll("0", " "))
                .forEach(answer::add);

        return answer.stream()
                .map(String::valueOf)
                .toArray(String[]::new);
    }

    public static void main(String[] args) {
        int n1 = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        String[] res = {"#####","# # #", "### #", "# ##", "#####"};
        String[] myRes = solution(n1, arr1, arr2);
        System.out.println("myRes: "+Arrays.toString(myRes));

    }
}
