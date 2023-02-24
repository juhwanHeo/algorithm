package com.programmers.level1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TheNearestIdenticalLetterTest {

    @Test
    public void solution1() {
        String s = "banana";
        int[] expected = {-1, -1, -1, 2, 2, 2};
        int[] result = TheNearestIdenticalLetter.solution(s);
        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    public void solution2() {
        String s = "foobar";
        int[] expected = {-1, -1, 1, -1, -1, -1};
        int[] result = TheNearestIdenticalLetter.solution(s);
        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }
}