package com.programmers.level1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ParkWalkTest {

    @Test
    void solution1() {

        String[] park = {
                "SOO",
                "OOO",
                "OOO"
        };
        String[] routes = {
                "E 2", "S 2", "W 1"
        };

        int[] result = ParkWalk.solution(park, routes);
        int[] expected = {2, 1};

        System.out.println("result: " + Arrays.toString(result));
        assertArrayEquals(result, expected);
    }

    @Test
    void solution2() {

        String[] park = {
                "SOO",
                "OXX",
                "OOO"
        };
        String[] routes = {
                "E 2", "S 2", "W 1"
        };

        int[] result = ParkWalk.solution(park, routes);
        int[] expected = {0, 1};

        System.out.println("result: " + Arrays.toString(result));
        assertArrayEquals(result, expected);
    }


    @Test
    void solution3() {

        String[] park = {
                "OSO","OOO","OXO","OOO"
        };
        String[] routes = {
                "E 2","S 3","W 1"
        };

        int[] result = ParkWalk.solution(park, routes);
        int[] expected = {0, 0};

        System.out.println("result: " + Arrays.toString(result));
        assertArrayEquals(result, expected);
    }
}