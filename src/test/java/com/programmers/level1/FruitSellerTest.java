package com.programmers.level1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FruitSellerTest {

    @Test
    void solution1() {
        int k = 3;
        int m = 4;
        int[] score = {1, 2, 3, 1, 2, 3, 1};
        int result = FruitSeller.solution(k, m, score);
        int expected = 8;

        System.out.println("result = " + result);
        assertEquals(result, expected);
    }

    @Test
    void solution2() {
        int k = 4;
        int m = 3;
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        int result = FruitSeller.solution(k, m, score);
        int expected = 33;

        System.out.println("result = " + result);
        assertEquals(result, expected);
    }
}