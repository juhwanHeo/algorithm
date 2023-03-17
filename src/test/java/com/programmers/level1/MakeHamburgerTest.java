package com.programmers.level1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MakeHamburgerTest {

    @Test
    void solution1() {
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        int result = MakeHamburger.solution(ingredient);
        int expected = 2;
        System.out.println("result = " + result);
        assertEquals(result, expected);
    }


    @Test
    void solution2() {
        int[] ingredient = {1, 3, 2, 1, 2, 1, 3, 1, 2};
        int result = MakeHamburger.solution(ingredient);
        int expected = 0;
        System.out.println("result = " + result);
        assertEquals(result, expected);
    }
}