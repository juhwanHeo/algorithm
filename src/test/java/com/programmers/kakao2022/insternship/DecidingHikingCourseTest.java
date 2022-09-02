package com.programmers.kakao2022.insternship;

import com.coding.utils.MakeJavaArray;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DecidingHikingCourseTest {

    @Test
    public void solution1() {
        int n = 6;
        int[][] paths = MakeJavaArray.replaceIntArray2(
                "[[1, 2, 3], [2, 3, 5], [2, 4, 2], [2, 5, 4], [3, 4, 4], [4, 5, 3], [4, 6, 1], [5, 6, 1]]"
        );
        int[] gates = {
                1, 3
        };
        int[] summits = {
                5
        };
        String expected = "[5, 3]";
        String result = Arrays.toString(DecidingHikingCourse.solution(n, paths, gates, summits));
        assertEquals(expected, result);
    }

    @Test
    public void solution2() {
        int n = 7;
        int[][] paths = MakeJavaArray.replaceIntArray2(
                "[[1, 4, 4], [1, 6, 1], [1, 7, 3], [2, 5, 2], [3, 7, 4], [5, 6, 6]]"
        );
        int[] gates = {
                1
        };
        int[] summits = {
                2, 3, 4
        };
        String expected = "[3, 4]";
        String result = Arrays.toString(DecidingHikingCourse.solution(n, paths, gates, summits));
        assertEquals(expected, result);
    }

    @Test
    public void solution3() {
        int n = 7;
        int[][] paths = MakeJavaArray.replaceIntArray2(
                "[[1, 2, 5], [1, 4, 1], [2, 3, 1], [2, 6, 7], [4, 5, 1], [5, 6, 1], [6, 7, 1]]"
        );
        int[] gates = {
                3, 7
        };
        int[] summits = {
                1, 5
        };
        String expected = "[5, 1]";
        String result = Arrays.toString(DecidingHikingCourse.solution(n, paths, gates, summits));
        assertEquals(expected, result);
    }

    @Test
    public void solution4() {
        int n = 5;
        int[][] paths = MakeJavaArray.replaceIntArray2(
                "[[1, 3, 10], [1, 4, 20], [2, 3, 4], [2, 4, 6], [3, 5, 20], [4, 5, 6]]"
        );
        int[] gates = {
                1, 2
        };
        int[] summits = {
                5
        };
        String expected = "[5, 6]";
        String result = Arrays.toString(DecidingHikingCourse.solution(n, paths, gates, summits));
        assertEquals(expected, result);
    }

}
