package com.programmers.kakao2023.blind;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Test4Test {

    @Test
    public void solution1() {
        long[] numbers = {7, 42, 5};
        int[] expected = {1, 1, 0};
        int[] result = Test4.solution(numbers);
        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    public void solution2() {
        long[] numbers = {63, 111, 95};
        int[] expected = {1, 1, 0};
        int[] result = Test4.solution(numbers);
        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

}
