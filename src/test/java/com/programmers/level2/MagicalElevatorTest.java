package com.programmers.level2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MagicalElevatorTest {

    @Test
    void solution1() {
        int storey = 16;
        int expected = 6;
        int result = MagicalElevator.solution(storey);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }


    @Test
    void solution2() {
        int storey = 2554;
        int expected = 16;
        int result = MagicalElevator.solution(storey);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution3() {
        int storey = 15;
        int expected = 6;
        int result = MagicalElevator.solution(storey);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution4() {
        int storey = 55;
        int expected = 10;
        int result = MagicalElevator.solution(storey);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution5() {
        int storey = 6;
        int expected = 5;
        int result = MagicalElevator.solution(storey);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }
}