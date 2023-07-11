package com.programmers.weekly;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task5Test {

    @Test
    void solution1() {
        String word = "AAAAE";

        int expected = 6;
        int result = Task5.solution(word);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution2() {
        String word = "AAAE";

        int expected = 10;
        int result = Task5.solution(word);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution3() {
        String word = "I";

        int expected = 1563;
        int result = Task5.solution(word);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution4() {
        String word = "EIO";

        int expected = 1189;
        int result = Task5.solution(word);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution5() {
        String word = "UUUUU";

        int expected = 3905;
        int result = Task5.solution(word);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }
}