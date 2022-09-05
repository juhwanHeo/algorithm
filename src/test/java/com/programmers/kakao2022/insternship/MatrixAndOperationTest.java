package com.programmers.kakao2022.insternship;

import com.coding.utils.MakeJavaArray;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MatrixAndOperationTest {


    @Test
    public void solution1() {
        int[][] rc = MakeJavaArray.replaceIntArray2(
                "[[1, 2, 3], [4, 5, 6], [7, 8, 9]]"
        );
        String[] operations = {
                "Rotate", "ShiftRow"
        };
        int[][] result = MatrixAndOperation.solution(rc, operations);

        String expectedString = "[[8, 9, 6], [4, 1, 2], [7, 5, 3]]";

        /* Array print */
        MakeJavaArray.replaceIntArray2("result", Arrays.deepToString(result));
        int[][] expected = MakeJavaArray.replaceIntArray2("expected", expectedString);
        assertArrayEquals(expected, result);
    }

    @Test
    public void solution2() {
        int[][] rc = MakeJavaArray.replaceIntArray2(
                "[[8, 6, 3], [3, 3, 7], [8, 4, 9]]"
        );
        String[] operations = {
                "Rotate", "ShiftRow", "ShiftRow"
        };
        int[][] result = MatrixAndOperation.solution(rc, operations);

        String expectedString = "[[8, 3, 3], [4, 9, 7], [3, 8, 6]]";

        /* Array print */
        MakeJavaArray.replaceIntArray2("result", Arrays.deepToString(result));
        int[][] expected = MakeJavaArray.replaceIntArray2("expected", expectedString);

        assertArrayEquals(expected, result);
    }

    @Test
    public void solution3() {
        int[][] rc = MakeJavaArray.replaceIntArray2(
                "[[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]]"
        );
        String[] operations = {
                "ShiftRow", "Rotate", "ShiftRow", "Rotate"
        };
        int[][] result = MatrixAndOperation.solution(rc, operations);

        String expectedString = "[[1, 6, 7 ,8], [5, 9, 10, 4], [2, 3, 12, 11]]";

        /* Array print */
        MakeJavaArray.replaceIntArray2("result", Arrays.deepToString(result));
        int[][] expected = MakeJavaArray.replaceIntArray2("expected", expectedString);
        assertArrayEquals(expected, result);
    }
}