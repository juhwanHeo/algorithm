package com.baekjoon.gold3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DownHillRoadTest {

    /*
    * 4 5
50 45 37 32 30
35 50 40 20 25
30 30 25 17 28
27 24 22 15 10
    * */
    @Test
    public void solutionTest1() {
        int N = 4;
        int M = 5;
        int[][] maps = {
                {50, 45, 37, 32, 30},
                {35, 50, 40, 20, 25},
                {30, 30, 25, 17, 28},
                {27, 24, 22, 15, 10},
        };
        int expected = 3;

        int result = DownHillRoad.solution(N, M, maps);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

}