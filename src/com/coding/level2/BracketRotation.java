package com.coding.level2;

import java.util.Stack;

/*
 * @level2
 * @TestName: 괄호 회전하기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/76502
 */
public class BracketRotation {

    public static int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            s = rotation(s, i);

            System.out.println("s = " + s);
            if (isOk(s)) answer++;
            System.out.println("---------------------\n");
        }

        return answer;
    }

    private static String rotation(String s, int count) {
        if (count == 0) return s;
        return s.substring(1) + s.charAt(0);
    }

    private static boolean isOk(String s) {
        System.out.println("isOk s = " + s);
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            }
            else {
                char ch = stack.peek();
                if (ch == '(' && s.charAt(i) == ')') stack.pop();
                else if (ch == '[' && s.charAt(i) == ']') stack.pop();
                else if (ch == '{' && s.charAt(i) == '}') stack.pop();
                else stack.push(s.charAt(i));
            }
        }
        System.out.println("stack = " + stack);
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String s1 = "[](){}";
        String s2 = "}]()[{";

        System.out.println(solution(s1));
//        System.out.println(solution(s2));
    }
}
