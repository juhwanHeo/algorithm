package com.programmers.level2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuadCompressionAfterCountTest {

    @Test
    @DisplayName("Test Case 1")
    public void test1() {
        int[][] arr = {
                {1, 1, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 1},
                {1, 1, 1, 1}
        };

        int[] expected = {4, 9};
        int[] result = QuadCompressionAfterCount.solution(arr);

        String expectedStr = Arrays.toString(expected);
        String resultStr = Arrays.toString(result);

        System.out.println("expectedStr = " + expectedStr);
        System.out.println("resultStr = " + resultStr);

        assertEquals(expectedStr, resultStr);
    }

    @Test
    @DisplayName("Test Case 2")
    public void test2() {
        int[][] arr = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 1, 1, 1}
        };

        int[] expected = {10, 15};
        int[] result = QuadCompressionAfterCount.solution(arr);

        String expectedStr = Arrays.toString(expected);
        String resultStr = Arrays.toString(result);

        System.out.println("expectedStr = " + expectedStr);
        System.out.println("resultStr = " + resultStr);

        assertEquals(expectedStr, resultStr);
    }

}