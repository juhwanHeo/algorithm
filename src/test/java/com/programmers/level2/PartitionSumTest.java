package com.programmers.level2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PartitionSumTest {

    @Test
    void solution1() {
        int[] sequence = {1, 2, 3, 4, 5};
        int k = 7;
        int[] expected = {2, 3};
        int[] result = PartitionSum.solution(sequence, k);

        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    void solution2() {
        int[] sequence = {1, 1, 1, 2, 3, 4, 5};
        int k = 5;
        int[] expected = {6, 6};
        int[] result = PartitionSum.solution(sequence, k);

        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    void solution3() {
        int[] sequence = {2, 2, 2, 2, 2};
        int k = 6;
        int[] expected = {0, 2};
        int[] result = PartitionSum.solution(sequence, k);

        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }
}