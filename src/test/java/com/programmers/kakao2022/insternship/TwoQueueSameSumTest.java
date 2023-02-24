package com.programmers.kakao2022.insternship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoQueueSameSumTest {

    @Test
    void solution1() {
        int[] q1 = {3, 2, 7, 2};
        int[] q2 = {4, 6, 5, 1};
        int expected = 2;
        long result = TwoQueueSameSum.solution(q1, q2);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution2() {
        int[] q1 = {1, 2, 1, 2};
        int[] q2 = {1, 10, 1, 2};
        int expected = 7;
        long result = TwoQueueSameSum.solution(q1, q2);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution3() {
        int[] q1 = {1, 1};
        int[] q2 = {1, 5};
        int expected = -1;
        long result = TwoQueueSameSum.solution(q1, q2);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }
    @Test
    void solution4() {
        int[] q1 = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 10 };
        int[] q2 = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        int expected = -1;
        long result = TwoQueueSameSum.solution(q1, q2);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }
    @Test
    void solution5() {
        // [1, 2, 4] [3, 2, 4]
        int[] q1 = { 1, 2, 4 };
        int[] q2 = { 3, 2, 4 };
        int expected = -1;
        long result = TwoQueueSameSum.solution(q1, q2);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }
}