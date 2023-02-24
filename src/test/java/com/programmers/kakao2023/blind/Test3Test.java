package com.programmers.kakao2023.blind;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Test3Test {

    @Test
    public void solution1() {
        int[][] users = {
                {40, 10000},
                {25, 10000}
        };
        int[] emoticons = {
                7000, 9000
        };
        int[] expected = {1, 5400};
        int[] result = Test3.solution(users, emoticons);
        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    public void solution2() {
        int[][] users = {
                {40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}
        };
        int[] emoticons = {
                1300, 1500, 1600, 4900
        };
        int[] expected = {4, 13860};
        int[] result = Test3.solution(users, emoticons);
        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }
}
