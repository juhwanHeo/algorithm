package com.programmers.kakao2020.internship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test5Test {

    @Test
    void solution1() {
        int[][] path = {{0, 1}, {0, 3}, {0, 7}, {8, 1}, {3, 6}, {1, 2}, {4, 7}, {7, 5}};
        int[][] order = {{8,5}, {6,7}, {4,1}};
        boolean expected = true;
        boolean result = Test5.solution(9, path, order);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution2() {

        int[][] path = {{8,1},{0,1},{1,2},{0,7},{4,7},{0,3},{7,5},{3,6}};
        int[][] order = {{4,1},{5,2}};
        boolean expected = true;
        boolean result = Test5.solution(9, path, order);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution3() {

        int[][] path = {{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}};
        int[][] order = {{4,1},{8,7},{6,5}};
        boolean expected = false;
        boolean result = Test5.solution(9, path, order);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }
}