package com.programmers.level1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class KnightlyWeaponTest {

    @Test
    void solution1() {
        int number = 5;
        int limit = 3;
        int power = 2;
        int result = KnightlyWeapon.solution(number, limit, power);
        int expected = 10;

        System.out.println("result = " + result);
        assertEquals(result, expected);
    }

    @Test
    void solution2() {
        int number = 10;
        int limit = 3;
        int power = 2;
        int result = KnightlyWeapon.solution(number, limit, power);
        int expected = 21;

        System.out.println("result = " + result);
        assertEquals(result, expected);
    }

    @Test
    void solution3() {
        int number = 100_000;
        int limit = 100;
        int power = 7;
        int result = KnightlyWeapon.solution(number, limit, power);
        int expected = 1164388;

        System.out.println("result = " + result);
        assertEquals(result, expected);
    }
}