package com.programmers.level2;

import java.util.Arrays;

/*
 * @level2
 * @TestName: 이진 변환 반복하기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/70129
 */
// String 의 replaceAll 로 풀이 가능
public class RepeatBinaryTransfer {


    public static int[] solution(String s) {
        int[] answer = new int[2];
        int repeatCnt = 0;
        int removeZeroCnt = 0;

        while(!s.equals("1")) {
            String[] array = s.split("");
            Arrays.sort(array);

            String join = String.join("", array);
            int oneIndex = join.indexOf('1');

            s = Integer.toUnsignedString(join.substring(oneIndex).length(), 2);
            repeatCnt++;
            removeZeroCnt += oneIndex;
        }


        System.out.println(repeatCnt);
        System.out.println(removeZeroCnt);
        answer[0] = repeatCnt;
        answer[1] = removeZeroCnt;
        return answer;
    }


    public static void main(String[] args) {

        String s1 = "110010101001"; // 3, 8

        System.out.println("result: " + Arrays.toString(solution(s1)));
    }
}
