package com.programmers.level2;

import java.util.Stack;

/*
 * @level2
 * @TestName: 올바른 괄호
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12909
 */
public class CorrectParenthesis {

    public static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            System.out.println("stack = " + stack);
            if (stack.isEmpty()) stack.push(ch);
            else {
                if (ch == ')') stack.pop();
                else stack.push(ch);
            }
        }
        System.out.println("stack = " + stack);

        return stack.isEmpty();
    }


    public static void main(String[] args) {

//        System.out.println(solution("()()"));
        System.out.println(solution("(())()"));
    }
}
