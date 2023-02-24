package com.study.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciDPTest {

    @Test
    @DisplayName("recursive 재귀")
    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    @Order(1)
    void test1() {
        int n = 30_000;
        FibonacciDP.dp = new long[n + 1];
        long result = FibonacciDP.fibonacciRecursive(n);

        System.out.println("result = " + result);
//        assertEquals(expected, result);
    }

    @Test
    @DisplayName("dp")
    @Timeout(value = 3, unit = TimeUnit.NANOSECONDS)
    @Order(2)
    void test2() {
        int n = 30_000;
        long result = FibonacciDP.fibonacciRepeat(n);

        System.out.println("result = " + result);
    }
}