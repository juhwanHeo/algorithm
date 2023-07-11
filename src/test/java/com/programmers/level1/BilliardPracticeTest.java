package com.programmers.level1;

import com.coding.utils.MakeJavaArray;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BilliardPracticeTest {

    @Test
    void solution1() {
        int m = 10;
        int n = 10;
        int startX = 3;
        int startY = 7;
        int[][] balls = MakeJavaArray.replaceIntArray2("[[7, 7], [2, 7], [7, 3]]");
        int[] result = BilliardPractice.solution(m, n, startX, startY, balls);
        int[] expected = {52, 37, 116};
        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(result, expected);
    }
    @Test
    void solution2() {
        // 10, 10, 5, 9, [[5, 8]] ,[9]
        // 10, 10, 5, 9, [[5, 8]] ,[9]
        int m = 10;
        int n = 10;
        int startX = 5;
        int startY = 9;
        int[][] balls = MakeJavaArray.replaceIntArray2("[[5, 8]]");
        int[] result = BilliardPractice.solution(m, n, startX, startY, balls);
        int[] expected = {9};
        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(result, expected);
    }

    @Test
    void solution3() {
        // 10, 10, 5, 9, [[5, 8]] ,[9]
        // 10, 10, 5, 9, [[5, 8]] ,[9]
        int m = 3;
        int n = 3;
        int startX = 1;
        int startY = 1;
        int[][] balls = MakeJavaArray.replaceIntArray2("[[2, 2]]");
        int[] result = BilliardPractice.solution(m, n, startX, startY, balls);
        int[] expected = {10};
        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(result, expected);
    }


    @Test
    void solution4() {
        // 10, 10, 5, 9, [[5, 8]] ,[9]
        // 10, 10, 5, 9, [[5, 8]] ,[9]
        int m = 1000;
        int n = 300;
        int startX = 1;
        int startY = 1;
        int[][] balls = MakeJavaArray.replaceIntArray2("[[255, 112]]");
        int[] result = BilliardPractice.solution(m, n, startX, startY, balls);
        int[] expected = {77285};
        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(result, expected);
    }

    @Test
    void solution5() {
        // 10, 10, 5, 9, [[5, 8]] ,[9]
        // 10, 10, 5, 9, [[5, 8]] ,[9]
        int m = 10;
        int n = 10;
        int startX = 5;
        int startY = 5;
        int[][] balls = MakeJavaArray.replaceIntArray2("[[3, 7], [3, 6]]");
        int[] result = BilliardPractice.solution(m, n, startX, startY, balls);
        int[] expected = {68, 65};
        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(result, expected);
    }
}