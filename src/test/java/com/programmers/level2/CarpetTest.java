package com.programmers.level2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CarpetTest {

    @Test
    void solution1() {
        int brown = 10;
        int yellow = 2;

        int[] result = Carpet.solution(brown, yellow);
        int[] expected = {4, 3};

        System.out.println("result: " + Arrays.toString(result));
        assertArrayEquals(result, expected);
    }

    @Test
    void solution2() {
        int brown = 8;
        int yellow = 1;

        int[] result = Carpet.solution(brown, yellow);
        int[] expected = {3, 3};

        System.out.println("result: " + Arrays.toString(result));
        assertArrayEquals(result, expected);
    }

    @Test
    void solution3() {
        int brown = 24;
        int yellow = 24;

        int[] result = Carpet.solution(brown, yellow);
        int[] expected = {8, 6};

        System.out.println("result: " + Arrays.toString(result));
        assertArrayEquals(result, expected);
    }
}