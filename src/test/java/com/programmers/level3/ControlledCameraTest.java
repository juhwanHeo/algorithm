package com.programmers.level3;

import com.coding.utils.MakeJavaArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControlledCameraTest {

    @Test
    void solution() {
        /* [[-20,-15], [-14,-5], [-18,-13], [-5,-3]] */

        int[][] routes = {
                {-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}
        };
        int expected = 2;
        long result = ControlledCamera.solution(routes);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }
}