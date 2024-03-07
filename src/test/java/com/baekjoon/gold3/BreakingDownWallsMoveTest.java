package com.baekjoon.gold3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BreakingDownWallsMoveTest {

    @Test
    public void solutionTest1() {
        int N = 6;
        int M = 4;
        int[][] maps = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 1, 1, 1},
                {0, 0, 0, 0}
        };
        int expected = 15;

        int result = BreakingDownWallsMove.solution(N, M, maps);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }


    @Test
    public void solutionTest2() {
        int N = 4;
        int M = 4;
        int[][] maps = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 0}
        };
        int expected = -1;

        int result = BreakingDownWallsMove.solution(N, M, maps);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void solutionTest3() {
        int N = 6;
        int M = 5;
        int[][] maps = {
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 1, 0},
        };
        int expected = 18;

        int result = BreakingDownWallsMove.solution(N, M, maps);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void solutionTest4() {
        int N = 1;
        int M = 1;
        int[][] maps = {
                {0},
        };
        int expected = 1;

        int result = BreakingDownWallsMove.solution(N, M, maps);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }
}