package com.programmers.level2;

import com.programmers.level3.LineUpMethod;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LongJumpTest {

    @Test
    void solution1() {
        int n = 4;
        long result = LongJump.solution(n);
        long expected = 5;

        System.out.println("result: " + result);
        assertEquals(result, expected);
    }


    @Test
    void solution2() {
        int n = 3;
        long result = LongJump.solution(n);
        long expected = 3;

        System.out.println("result: " + result);
        assertEquals(result, expected);
    }


    @Test
    void solution3() {
        int n = 2000;
        long result = LongJump.solution(n);
        long expected = 694725;

        System.out.println("result: " + result);
        assertEquals(result, expected);
    }


    @Test
    void solution4() {
        int n = 1;
        long result = LongJump.solution(n);
        long expected = 1;

        System.out.println("result: " + result);
        assertEquals(result, expected);
    }




}