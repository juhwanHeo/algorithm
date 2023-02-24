package com.programmers.kakao2023.blind;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Test2Test {

    @Test
    public void solution1() {
        int cap = 4;
        int n = 5;
        int[] deliveries = {
                1, 0, 3, 1, 2
        };

        int[] pickups = {
                0, 3, 0, 4, 0
        };

        int expected = 16;
        long result = Test2.solution(cap, n , deliveries, pickups);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void solution2() {
        int cap = 2;
        int n = 7;
        int[] deliveries = {
                1, 0, 2, 0, 1, 0, 2
        };

        int[] pickups = {
                0, 2, 0, 1, 0, 2, 0
        };

        int expected = 30;
        long result = Test2.solution(cap, n , deliveries, pickups);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void solution3() {
        int cap = 2;
        int n = 2;
        int[] deliveries = {
                0, 6
        };

        int[] pickups = {
                0, 0
        };

        int expected = 12;
        long result = Test2.solution(cap, n , deliveries, pickups);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }
}
