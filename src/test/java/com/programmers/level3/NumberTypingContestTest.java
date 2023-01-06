package com.programmers.level3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberTypingContestTest {

    @Test
    void solution1() {
        int number = 1756;
        int expected = 10;
        int result = NumberTypingContest.solution(number);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution2() {
        int number = 5123;
        int expected = 8;
        int result = NumberTypingContest.solution(number);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }
}