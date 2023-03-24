package com.programmers.level3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntermittentCameraTest {

    @Test
    void solution() {
        int[][] routes = {
                {-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}
        };

        int expected = 2;
        int result = IntermittentCamera.solution(routes);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

}