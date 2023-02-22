package com.programmers.level2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeesawPartnerTest {

    @Test
    void solution() {
        int[] weights = {
                100, 180, 360, 100, 270
        };
        int expected = 4;
        long result = SeesawPartner.solution(weights);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }
}