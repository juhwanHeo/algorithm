package com.programmers.level2;

import java.util.Stack;

/*
 * @level2
 * @TestName: 짝지어 제거하기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12973
 */
public class RemovePair {


    public static int solution(String s) {
        if (s.length() % 2 == 1) return 0;

//        Stack<String> stack = new Stack<>();
//
//        for (String str : s.split("")) {
//            if (!stack.isEmpty() && stack.peek().equals(str)) stack.pop();
//            else stack.push(str);
//        }
//        System.out.println(stack);


        byte[] bytes = s.getBytes();

        Stack<Byte> stack = new Stack<>();

        for (byte b : bytes) {
            if (!stack.isEmpty() && stack.peek().equals(b)) stack.pop();
            else stack.push(b);
        }
        System.out.println(stack);

        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        String s1 = "baabaasdfwefes";
        String s2 = "baabaa";
        String s3= "cdcd";

        System.out.println("solution() = " + solution(s1));
        System.out.println("solution() = " + solution(s2));
        System.out.println("solution() = " + solution(s3));

    }
}
