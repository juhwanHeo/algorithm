package com.programmers.level1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SmallerSubstringTest {

    @Test
    public void solution1() {
        String t = "3141592";
        String p = "271";
        int expected = 2;
        int result = SmallerSubstring.solution(t, p);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void solution2() {
        String t = "500220839878";
        String p = "7";
        int expected = 8;
        int result = SmallerSubstring.solution(t, p);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void solution3() {
        String t = "10203";
        String p = "15";
        int expected = 3;
        int result = SmallerSubstring.solution(t, p);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }
}