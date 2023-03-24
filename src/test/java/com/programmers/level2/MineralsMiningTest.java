package com.programmers.level2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MineralsMiningTest {

    @Test
    void solution1() {
        int[] picks = {1, 3, 2};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};

        int result = MineralsMining.solution(picks, minerals);
        int expected = 12;

        System.out.println("result: " + result);
        assertEquals(result, expected);
    }

    @Test
    void solution2() {
        int[] picks = {0, 1, 1};
        String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};

        int result = MineralsMining.solution(picks, minerals);
        int expected = 50;

        System.out.println("result: " + result);
        assertEquals(result, expected);
    }

}