package com.coding.kakao2021.summer;

import java.util.Stack;
/*
 * @2021 kakao summber internship
 * @TestName: 표 편집
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/81303
 */
public class Test3 {
    public static String solution(int n, int k, String[] cmd) {
        int select = k;
        int curLen = n;
        Stack<Integer> backup = new Stack<>();
        for(String str : cmd) {
            // D 아래로 이동
            if(str.charAt(0) == 'D') {
                select += Integer.parseInt(str.substring(2));
            }
            // U 위로 이동
            else if(str.charAt(0) == 'U') {
                select -= Integer.parseInt(str.substring(2));
            }
            // C 삭제
            else if(str.equals("C")) {
                backup.push(select);
                select = (select == curLen - 1) ? select - 1 : select;
                curLen -= 1;
            }
            // Z 복구 =
            else if(str.equals("Z")) {
                int backupIndex = backup.pop();
                select = (select >= backupIndex) ? select + 1 : select;
                curLen += 1;
            }
        }

        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < curLen; i++) answer.append("O");

        while(!backup.isEmpty()) {
            int backupIndex = backup.pop();
            answer.insert(backupIndex, "X");
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        // "OOOOXOOO"
        String[] test1 = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};
        String answer1 = solution(8, 2, test1);

        // "OOXOXOOO"
        String[] test2 = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};
        String answer2 = solution(8, 2, test2);

        System.out.println("answer1 my: "+ answer1);
        System.out.println("answer1 my.length: "+ answer1.length());
        System.out.println("answer1 answer: OOOOXOOO");
        System.out.println("answer1 equals: "+ answer1.equals("OOOOXOOO"));

        System.out.println("--------------------");
        System.out.println("answer2: "+ answer2);
        System.out.println("answer2 my.length: "+ answer2.length());
        System.out.println("answer2 answer: OOXOXOOO");
        System.out.println("answer2 equals: "+ answer2.equals("OOXOXOOO"));

    }
}
