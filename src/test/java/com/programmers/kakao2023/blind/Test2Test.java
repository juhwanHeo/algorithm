package com.programmers.kakao2023.blind;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Test2Test {

    @Test
    public void solution1() {
        int n = 6;
        int expected = 0;
        int result = Test2.solution();
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

}
