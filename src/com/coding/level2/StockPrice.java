package com.coding.level2;

import java.util.Arrays;
import java.util.Stack;

/*
 * @level2
 * @TestName: 주식 가격
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/42584
 */
public class StockPrice {

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && (prices[i] < prices[stack.peek()])) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        System.out.println(stack);

        System.out.println("-----\n");
        while (!stack.isEmpty()) {
            System.out.println("stack = " + stack);
            System.out.println("answer = " + Arrays.toString(answer));
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }

        return answer;
    }


    public static void main(String[] args) {
        int[] prices = {
                1, 2, 3, 2, 3 // 4, 3, 1, 1, 0
//                1, 2, 2, 2, 3 // 4, 3, 2, 1, 0
        };

        System.out.println(Arrays.toString(solution(prices)));
    }
}
