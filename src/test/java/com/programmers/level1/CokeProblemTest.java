package com.programmers.level1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CokeProblemTest {

    // 10 + 5 + 2 + 1 + 1 = 19
    @Test
    void solution1() {
        int a = 2;
        int b = 1;
        int n = 20;
        int result = CokeProblem.solution(a, b, n);
        int expected = 19;
        System.out.println("result = " + result);
        assertEquals(result, expected);
    }

    @Test
    void solution2() {
        int a = 3;
        int b = 1;
        int n = 20;
        int result = CokeProblem.solution(a, b, n);
        int expected = 9;
        System.out.println("result = " + result);
        assertEquals(result, expected);
    }
}