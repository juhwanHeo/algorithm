package com.coding.kakao2021.blind;


/*
 * @2021 kakao blind recruitment
 * @TestName: 신규 아이디 추천
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/72410
 */
public class Test1 {

    public static String solution(String new_id) {
        new_id = new_id.toLowerCase()
                .replaceAll("[~!@#$%^&*()=+\\[{\\]}:?,<>/]","")
                .replaceAll("\\.{2,}",".")
                .replaceAll("^[.]|[.]$", "");
        if(new_id.isEmpty()) new_id = "a";
        while(new_id.length() < 3) {
            new_id += new_id.charAt(new_id.length()-1);
        }
        if(new_id.length() > 15) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("[.]$", "");
        }

        System.out.println("new_id: " + new_id);
        return new_id;
    }

    public static void main(String[] args) {
       String new_id1 = "...!@BaT#*..y.abcdefghijklm";
       String result1 = "bat.y.abcdefghi";
       String myRes1 = solution(new_id1);


        String new_id2 = "z-+.^.";
        String myRes2 = solution(new_id2);
    }
}

