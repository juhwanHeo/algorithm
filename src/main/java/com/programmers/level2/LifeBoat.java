package com.programmers.level2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
 * @level2
 * @TestName: 구명보트
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/42885
 */
public class LifeBoat {

    public static int solution(int[] people, int limit) {
        int answer = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        Arrays.sort(people);
        for (int person : people) deque.add(person);

        while (!deque.isEmpty()) {
            int removeVal = deque.removeLast();
            if (!deque.isEmpty() && limit >= removeVal + deque.getFirst())
                deque.removeFirst();
            answer++;
        }

        return answer;
    }


    public static void main(String[] args) {
        int[] people = {
                70, 50, 80, 50
        };

        System.out.println(solution(people, 100));
    }
}
