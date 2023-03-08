package com.programmers.kakao2020.blind;

import com.coding.utils.MakeJavaArray;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MovingBlocksTest {

    @Test
    void solution1() {
        int[][] board = MakeJavaArray.replaceIntArray2("[[0, 0, 0, 1, 1],[0, 0, 0, 1, 0],[0, 1, 0, 1, 1],[1, 1, 0, 0, 1],[0, 0, 0, 0, 0]]");
        int expected = 7;
        int result = MovingBlocks.solution(board);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution2() {
        int[][] board = MakeJavaArray.replaceIntArray2("[[0, 0, 0, 0, 1, 0], [0, 0, 1, 1, 1, 0], [0, 1, 1, 1, 1, 0], [0, 1, 0, 0, 1, 0], [0, 0, 1, 0, 0, 0], [0, 0, 0, 0, 0, 0]]");
        int expected = 10;
        int result = MovingBlocks.solution(board);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }
}