package com.programmers.level2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MakeDotTest {

    /*
    * (0, 0), (0, 2), (0, 4),
    * (2, 0), (2, 2),
    * (4, 0)
     * */
    @Test
    void solution1() {
        int k = 2;
        int d = 4;
        int expected = 6;
        long result = MakeDot.solution(k, d);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }


    /*
    *
    *
    * (d * d)
    * */
    @Test
    void solution2() {
        int k = 1;
        int d = 5;
        int expected = 25;
        long result = MakeDot.solution(k, d);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }
}