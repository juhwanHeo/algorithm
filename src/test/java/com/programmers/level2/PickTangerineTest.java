package com.programmers.level2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PickTangerineTest {

    @Test
    public void solution1() {
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        int expected = 3;
        int result = PickTangerine.solution(k, tangerine);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void solution2() {
        int k = 4;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        int expected = 2;
        int result = PickTangerine.solution(k, tangerine);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void solution3() {
        int k = 2;
        int[] tangerine = {1, 1, 1, 1, 2, 2, 2, 3};
        int expected = 1;
        int result = PickTangerine.solution(k, tangerine);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }
}