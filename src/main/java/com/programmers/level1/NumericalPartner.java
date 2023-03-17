package com.programmers.level1;

import java.util.Arrays;
import java.util.Comparator;

/*
 * @level1
 * @TestName: 숫자 짝꿍
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/131128
 * @COMMENT: 투 포인터
 */
public class NumericalPartner {
    static String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();

        String[] xSplit = X.split("");
        String[] ySplit = Y.split("");

        Arrays.sort(xSplit, Comparator.reverseOrder());
        Arrays.sort(ySplit, Comparator.reverseOrder());

        System.out.println(Arrays.toString(xSplit));
        System.out.println(Arrays.toString(ySplit));

        int left = 0, right = 0;

        while (left != xSplit.length && right != ySplit.length) {
            int compare = xSplit[left].compareTo(ySplit[right]);
            System.out.println(xSplit[left] + ", " + ySplit[right] + ", " + compare);
            if (compare > 0) {
                left++;
            } else if (compare < 0) {
                right++;
            }
            else {
                answer.append(xSplit[left]);
                left++;
                right++;
            }
        }

        if (answer.length() == 0) return "-1";
        if (answer.toString().charAt(0) == '0') return "0";
        return answer.toString();
    }
}
