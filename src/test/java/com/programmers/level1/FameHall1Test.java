package com.programmers.level1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FameHall1Test {

    @Test
    void solution1() {
        int k = 3;
        int[] score = {10, 100, 20, 150, 1, 100, 200};
        int[] result = FameHall1.solution(k, score);
        int[] expected = {10, 10, 10, 20, 20, 100, 100};

        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(result, expected);
    }

    @Test
    void solution2() {
        int k = 4;
        int[] score = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};
        int[] result = FameHall1.solution(k, score);
        int[] expected = {0, 0, 0, 0, 20, 40, 70, 70, 150, 300};

        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(result, expected);
    }
}