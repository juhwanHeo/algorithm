package com.programmers.kakao2021.blind;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test6BFSTest {

    @Test
    void solution1() {
        int[][] routes = {
                {1, 0, 0, 3},
                {2, 0, 0, 0},
                {0, 0, 0, 2},
                {3, 0, 1, 0}
        };
        int r = 1;
        int c = 0;
        int expected = 14;
        long result = Test6BFS.solution(routes, r, c);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution2() {
        int[][] routes = {
                {3, 0, 0, 2},
                {0, 0, 1, 0},
                {0, 1, 0, 0},
                {2, 0, 0, 3}
        };
        int r = 0;
        int c = 1;
        int expected = 16;
        long result = Test6BFS.solution(routes, r, c);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }
}