package com.programmers.level3;

import com.coding.utils.MakeJavaArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectingIslandsTest {

    @Test
    public void solution1() {
        int n = 4;
        int[][] costs = MakeJavaArray.replaceIntArray2("[[0, 1, 1], [0, 2, 2], [1, 2, 5], [1, 3, 1], [2, 3, 8]]");
        int expected = 4;
        int result = ConnectingIslands.solution(n, costs);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void solution2() {
        int n = 4;
        int[][] costs = MakeJavaArray.replaceIntArray2("[[0, 1, 1], [0, 2, 999], [1, 2, 5], [1, 3, 1], [2, 3, 8]]");
        int expected = 7;
        int result = ConnectingIslands.solution(n, costs);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }
}