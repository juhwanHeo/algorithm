package com.programmers.level2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnticipatedMatchTest {

    @Test
    void solution() {

        int N = 8;
        int A = 4;
        int B = 7;

        int expected = 3;
        int result = AnticipatedMatch.solution(N, A, B);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }
}