package com.programmers.level2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MazeEscapeTest {

    @Test
    void solution1() {
        String[] maps = {
                "SOOOL",
                "XXXXO",
                "OOOOO",
                "OXXXX",
                "OOOOE"
        };
        int expected = 16;
        int result = MazeEscape.solution(maps);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution2() {
        String[] maps = {
                "LOOXS",
                "OOOOX",
                "OOOOO",
                "OOOOO",
                "EOOOO"
        };
        int expected = -1;
        int result = MazeEscape.solution(maps);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }
}