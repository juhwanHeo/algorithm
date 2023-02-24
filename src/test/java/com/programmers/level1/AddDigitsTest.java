package com.programmers.level1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddDigitsTest {

    @Test
    void solution1() {
        int n = 123;
        int expected = 6;
        int result = AddDigits.solution(n);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }


    @Test
    void solution2() {
        int n = 987;
        int expected = 24;
        int result = AddDigits.solution(n);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

}