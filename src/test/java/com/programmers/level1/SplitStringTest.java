package com.programmers.level1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SplitStringTest {

    @Test
    void solution1() {
        String s = "banana";
        int result = SplitString.solution(s);
        int expected = 3;

        System.out.println("result = " + result);
        assertEquals(result, expected);
    }

    @Test
    void solution2() {
        String s = "abracadabra";
        int result = SplitString.solution(s);
        int expected = 6;

        System.out.println("result = " + result);
        assertEquals(result, expected);
    }

    @Test
    void solution3() {
        String s = "aaabbaccccabba";
        int result = SplitString.solution(s);
        int expected = 3;

        System.out.println("result = " + result);
        assertEquals(result, expected);
    }
}