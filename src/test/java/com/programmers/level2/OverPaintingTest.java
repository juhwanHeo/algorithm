package com.programmers.level2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OverPaintingTest {

    @Test
    void solution1() {
        int n = 8;
        int m = 4;
        int[] section = {2, 3, 6};
        int expected = 2;
        int result = OverPainting.solution(n, m, section);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution2() {
        int n = 5;
        int m = 4;
        int[] section = {1, 3};
        int expected = 1;
        int result = OverPainting.solution(n, m, section);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution3() {
        int n = 4;
        int m = 1;
        int[] section = {1, 2, 3, 4};
        int expected = 4;
        int result = OverPainting.solution(n, m, section);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }
}