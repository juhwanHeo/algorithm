package com.programmers.level1;

/*
 * @level1
 * @TestName: 둘만의 암호
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/155652
 */
public class OurOwnCode {
    static String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();

        System.out.println("s = " + s);
        System.out.println("skip = " + skip);


        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            int idx = 1;
            char sch = ch;
            while (idx <= index) {
                sch =  (sch == 'z') ? 'a' : (char) (((int) sch) + 1);
                System.out.println("ch: " + ch + "(" + ((int) ch) + ")" + ", sch: " + sch + "(" + ((int) sch) + ")" + ", idx: " + idx);
                if (skip.contains(String.valueOf(sch))) continue;
                idx++;
            }

            System.out.println("============\n");
            sb.append(sch);
        }


        return sb.toString();
    }

}
