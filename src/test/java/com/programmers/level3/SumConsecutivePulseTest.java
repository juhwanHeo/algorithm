package com.programmers.level3;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class SumConsecutivePulseTest {

    @Test
    void solution1() {
        int[] sequence = {2, 3, -6, 1, 3, -1, 2, 4};
        long expected = 10;
        long result  = SumConsecutivePulse.solution(sequence);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution2() {
        int[] sequence = {10, -4, 3, 1, 5, 6, -35, 12, 21, -1};
        long expected = 53;
        long result  = SumConsecutivePulse.solution(sequence);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution3() {
        int[] sequence = {2, 1, -4, 3, 4, -4, 6, 5, -5, 1};
        long expected = 14;
        long result  = SumConsecutivePulse.solution(sequence);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }
}