package com.study.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class SumTest {

    @Test
    @DisplayName("Divide and Conquer 분할정복")
    @Timeout(60)
    @Order(1)
    void sumTest1() {
        long start = 1;
        long end = 50_000_000;
//        long expected = 4500000001500000000L;
        long result = Sum.sum(start, end, 0);

        System.out.println("result = " + result);
//        assertEquals(expected, result);
    }

    @Test
    @DisplayName("for")
    @Timeout(value = 1_500, unit = TimeUnit.MILLISECONDS)
    @Order(2)
    void sumTest2() {
        long start = 1;
        long end = 1_040_000_000L;
//        long expected = 4500000001500000000L;
        long result = Sum.sum(start, end, 0);

        System.out.println("result = " + result);
//        assertEquals(expected, result);
    }
}