package com.programmers.level1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Babbling2Test {

    @Test
    void solution1() {
        String[] babbling = {"aya", "yee", "u", "maa"};
        int result = Babbling2.solution(babbling);
        int expected = 1;
        System.out.println("result = " + result);
        assertEquals(result, expected);
    }

    @Test
    void solution2() {
        String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
        int result = Babbling2.solution(babbling);
        int expected = 2;
        System.out.println("result = " + result);
        assertEquals(result, expected);
    }

    @Test
    void solution3() {
        String[] babbling = {"ayayeye", "ayayeayayeayaaya", "ayayeaya"};
        int result = Babbling2.solution(babbling);
        int expected = 1;
        System.out.println("result = " + result);
        assertEquals(result, expected);
    }
}