package com.programmers.level2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertingNumbersTest {

    @Test
    void solution1() {
        int x = 10;
        int y = 40;
        int n = 5;
        int expected = 2;
        int result = ConvertingNumbers.solution(x, y, n);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution2() {
        int x = 10;
        int y = 40;
        int n = 30;
        int expected = 1;
        int result = ConvertingNumbers.solution(x, y, n);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution3() {
        int x = 2;
        int y = 5;
        int n = 4;
        int expected = -1;
        int result = ConvertingNumbers.solution(x, y, n);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }
}