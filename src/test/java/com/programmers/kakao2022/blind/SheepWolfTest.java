package com.programmers.kakao2022.blind;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SheepWolfTest {

    @Test
    public void solutionTest1() {
        int expected = 5;
        int[] info = {
                0, 0, 1,1,1,0,1,0,1,0,1,1
        };

        int[][] edge = {
                {0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}
        };

        int result = SheepWolf.solution(info, edge);
        assertEquals(expected, result);
    }

}