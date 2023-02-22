package com.programmers.level2;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * @level2
 * @TestName: 뒤에 있는 큰 수 찾기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/154539
 */
public class FindTheBigNumbers {

    static class Number implements Comparable<Number> {
        int number, index;

        public Number(int index, int number) {
            this.number = number;
            this.index = index;
        }

        @Override
        public int compareTo(Number o) {
            return Integer.compare(number, o.number);
        }

        @Override
        public String toString() {
            return "(index: " + index +
                    ", number: " + number + ")";
        }
    }
    public static int[] solution(int[] numbers) {
        PriorityQueue<Number> pq = new PriorityQueue<>();
        int[] output = new int[numbers.length];

        for (int index = 0; index < numbers.length; index++) {
            int value = numbers[index];

            while (!pq.isEmpty() && pq.peek().number < value) {
                output[pq.poll().index] = value;
            }

            pq.add(new Number(index, value));

            System.out.println(pq);
        }

        while (!pq.isEmpty()) {
            output[pq.poll().index] = -1;
        }

        return output;
    }



    public int[] solution2(int[] numbers) {
        int[] output = new int[numbers.length];
        Arrays.fill(output, -1);

        dfs(numbers, output, 0);
        return output;
    }

    static void dfs(int[] numbers, int[] output, int depth) {
        if (numbers.length - 1 == depth) return;
        for (int i = depth; i < numbers.length; i++) {
            if (numbers[depth] < numbers[i]) {
                output[depth] = numbers[i];
                break;
            }
        }

        dfs(numbers, output, depth + 1);
    }
}
