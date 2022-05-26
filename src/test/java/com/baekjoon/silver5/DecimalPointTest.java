package com.baekjoon.silver5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecimalPointTest {

    @Test
    public void getPointTest1() {
        int A = 1;
        int B = 1;
        int N = 1;
        int expected = 0;

        int result = DecimalPoint.getPoint(A, B, N);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void getPointTest2() {
        int A = 2;
        int B = 3;
        int N = 1;
        int expected = 6;

        int result = DecimalPoint.getPoint(A, B, N);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void getPointTest3() {
        int A = 5;
        int B = 2;
        int N = 1;
        int expected = 5;

        int result = DecimalPoint.getPoint(A, B, N);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void getPointTest4() {
        int A = 10;
        int B = 10;
        int N = 1;
        int expected = 0;

        int result = DecimalPoint.getPoint(A, B, N);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void getPointTest5() {
        int A = 1;
        int B = 3;
        int N = 9;
        int expected = 3;

        int result = DecimalPoint.getPoint(A, B, N);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void getPointTest6() {
        int A = 1;
        int B = 3;
        int N = 10;
        int expected = 3;

        int result = DecimalPoint.getPoint(A, B, N);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void getPointTest7() {
        int A = 1;
        int B = 3;
        int N = 11;
        int expected = 3;

        int result = DecimalPoint.getPoint(A, B, N);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void getPointTest8() {
        int A = 5;
        int B = 2;
        int N = 10;
        int expected = 0;

        int result = DecimalPoint.getPoint(A, B, N);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void getPointTest9() {
        int A = 7;
        int B = 100;
        int N = 1;
        int expected = 0;

        int result = DecimalPoint.getPoint(A, B, N);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void getPointTest10() {
        int A = 7;
        int B = 100;
        int N = 2;
        int expected = 7;

        int result = DecimalPoint.getPoint(A, B, N);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void getPointTest11() {
        int A = 25;
        int B = 7;
        int N = 5;
        int expected = 2;

        int result = DecimalPoint.getPoint(A, B, N);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

}