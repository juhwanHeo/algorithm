package com.programmers.level2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterceptorMissileTest {

    @Test
    void test1() {
        int[][] targets = {
                {4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}
        };
        int expected = 3;
        int result = InterceptorMissile.solution(targets);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }



    //[[0, 4], [1, 2], [1, 3], [3, 4]] => 2
    @Test
    void test2() {
        int[][] targets = {
                {0, 4}, {1, 2}, {1, 3}, {3, 4}
        };
        int expected = 2;
        int result = InterceptorMissile.solution(targets);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }
    //[[0, 4], [0, 1], [2, 3]] => 2
    @Test
    void test3() {
        int[][] targets = {
                {0, 4}, {0, 1}, {2, 3}
        };
        int expected = 2;
        int result = InterceptorMissile.solution(targets);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void test4() {
        int[][] targets = {
                {4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 5}
        };
        int expected = 2;
        int result = InterceptorMissile.solution(targets);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }
}