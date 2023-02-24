package com.programmers.level2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FindTheBigNumbersTest {

    @Test
    void solution1() {
        int[] numbers = {
                2, 3, 3, 5
        };
        int[] expected = {
                3, 5, 5, -1
        };
        int[] result = FindTheBigNumbers.solution(numbers);

        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    void solution2() {
        int[] numbers = {
                9, 1, 5, 3, 6, 2
        };
        int[] expected = {
                -1, 5, 6, 6, -1, -1
        };
        int[] result = FindTheBigNumbers.solution(numbers);

        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }
}