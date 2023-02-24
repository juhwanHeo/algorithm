package com.programmers.level3;

import com.coding.utils.MakeJavaArray;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ReturnTroopsTest {

    @Test
    void solution1() {
        int n = 3;
        int[][] roads = MakeJavaArray.replaceIntArray2("[[1, 2], [2, 3]]");
        int[] sources = {2, 3};
        int destination = 1;

        int[] expected = {1, 2};
        int[] result = ReturnTroops.solution(n, roads, sources, destination);
        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    void solution2() {
        int n = 5;
        int[][] roads = MakeJavaArray.replaceIntArray2("[[1, 2], [1, 4], [2, 4], [2, 5], [4, 5]]");
        int[] sources = {1, 3, 5};
        int destination = 5;

        int[] expected = {2, -1, 0};
        int[] result = ReturnTroops.solution(n, roads, sources, destination);
        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

}