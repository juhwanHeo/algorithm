package com.programmers.level1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RoughKeyboardTest {

    @Test
    void solution1() {
        String[] keymap = {
                "ABACD", "BCEFD"
        };

        String[] target = {
                "ABCD","AABB"
        };

        int[] expected = {
                9, 4
        };

        int[] result = RoughKeyboard.solution(keymap, target);

        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    void solution2() {
        String[] keymap = {
                "AA"
        };

        String[] target = {
                "B"
        };

        int[] expected = {
                -1
        };

        int[] result = RoughKeyboard.solution(keymap, target);

        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    void solution3() {
        String[] keymap = {
                "AGZ", "BSSS"
        };

        String[] target = {
                "ASA","BGZ"
        };

        int[] expected = {
                4, 6
        };

        int[] result = RoughKeyboard.solution(keymap, target);

        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }
}