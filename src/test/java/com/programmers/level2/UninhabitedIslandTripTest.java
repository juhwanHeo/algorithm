package com.programmers.level2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UninhabitedIslandTripTest {

    @Test
    void solution1() {
        String[] maps = {
                "X591X",
                "X1X5X",
                "X231X",
                "1XXX1"
        };
        int[] expected = { 1, 1, 27 };
        int[] result = UninhabitedIslandTrip.solution(maps);
        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    void solution2() {
        String[] maps = {
                "XXX","XXX","XXX"
        };
        int[] expected = { -1 };
        int[] result = UninhabitedIslandTrip.solution(maps);
        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }
}