package com.programmers.level1;

import java.util.Stack;

/*
 * @level1
 * @TestName: 햄버거 만들기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/133502
 */
public class MakeHamburger {
    static int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i : ingredient) {
            stack.push(i);
            System.out.println(stack);
            if (stack.size() >= 4) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int num3 = stack.pop();
                int num4 = stack.pop();
                if (num1 == 1 && num2 == 3 && num3 == 2 && num4 == 1) answer++;
                else {
                    stack.push(num4);
                    stack.push(num3);
                    stack.push(num2);
                    stack.push(num1);
                }
            }
        }

        return answer;
    }

}
