package com.programmers.level3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LineUpMethodTest {

    @Test
    void solution1() {
        int n = 3;
        int k = 5;
        int[] result = LineUpMethod.solution(n, k);
        int[] expected = {3, 1, 2};

        System.out.println("result: " + Arrays.toString(result));
        assertArrayEquals(result, expected);
    }


    @Test
    void solution2() {
        int n = 3;
        int k = 1;
        int[] result = LineUpMethod.solution(n, k);
        int[] expected = {1, 2, 3};

        System.out.println("result: " + Arrays.toString(result));
        assertArrayEquals(result, expected);
    }

    @Test
    void solution3() {
        int n = 4;
        long k = 6;
        int[] result = LineUpMethod.solution(n, k);
        int[] expected = {1, 4, 3, 2};
        System.out.println("result: " + Arrays.toString(result));
        assertArrayEquals(result, expected);
    }


    @Test
    void test() {
        System.out.println(LineUpMethod.factorial(20));
    }

}