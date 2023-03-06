package com.programmers.level1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CleanUpDesktopTest {

    @Test
    void solution1() {
        String[] wallpaper = {
                ".#...",
                "..#..",
                "...#."
        };
        int[] expected = {0, 1, 3, 4};
        int[] result = CleanUpDesktop.solution(wallpaper);
        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    void solution2() {
        String[] wallpaper = {
                "..........", ".....#....", "......##..", "...##.....", "....#....."
        };
        int[] expected = {1, 3, 5, 8};
        int[] result = CleanUpDesktop.solution(wallpaper);
        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    void solution3() {
        String[] wallpaper = {
                ".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."
        };
        int[] expected = {0, 0, 7, 9};
        int[] result = CleanUpDesktop.solution(wallpaper);
        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    void solution4() {
        String[] wallpaper = {
                "..", "#."
        };
        int[] expected = {1, 0, 2, 1};
        int[] result = CleanUpDesktop.solution(wallpaper);
        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }
}