package com.programmers.level1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrioTest {

    @Test
    void solution1() {
        int[] number = {-2, 3, 0, 2, -5};
        int result = Trio.solution(number);
        int expected = 2;
        System.out.println("result = " + result);
        assertEquals(result, expected);
    }

    @Test
    void solution2() {
        int[] number = {-3, -2, -1, 0, 1, 2, 3};
        int result = Trio.solution(number);
        int expected = 5;
        System.out.println("result = " + result);
        assertEquals(result, expected);
    }


    @Test
    void solution3() {
        int[] number = {-1, 1, -1, 1};
        int result = Trio.solution(number);
        int expected = 0;
        System.out.println("result = " + result);
        assertEquals(result, expected);
    }
}