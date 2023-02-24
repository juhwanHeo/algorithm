package com.programmers.kakao2023.blind;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Test6Test {

    @Test
    public void solution1() {
        int n = 3;
        int m = 4;
        int x = 2;
        int y = 3;
        int r = 3;
        int c = 1;
        int k = 5;
        String expected = "dllrl";
        String result = Test6.solution(n, m, x, y, r, c, k);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void solution2() {
        int n = 2;
        int m = 2;
        int x = 1;
        int y = 1;
        int r = 2;
        int c = 2;
        int k = 2;
        String expected = "dr";
        String result = Test6.solution(n, m, x, y, r, c, k);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void solution3() {
        int n = 3;
        int m = 3;
        int x = 1;
        int y = 2;
        int r = 3;
        int c = 3;
        int k = 4;
        String expected = "impossible";
        String result = Test6.solution(n, m, x, y, r, c, k);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

}
