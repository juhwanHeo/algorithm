package com.programmers.kakao2022.blind;

import com.coding.utils.MakeJavaArray;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArcheryCompetitionTest {

    @Test
    public void solution1() {
        int n = 5;
        int[] info = {2,1,1,1,0,0,0,0,0,0,0};
        int[] expected = {0,2,2,0,1,0,0,0,0,0,0};
        int[] result = ArcheryCompetition.solution(n, info);
        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    public void solution2() {
        int n = 1;
        int[] info = {1,0,0,0,0,0,0,0,0,0,0};
        int[] expected = {-1};
        int[] result = ArcheryCompetition.solution(n, info);
        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    public void solution3() {
        int n = 9;
        int[] info = {0,0,1,2,0,1,1,1,1,1,1};
        int[] expected = {1,1,2,0,1,2,2,0,0,0,0};
        int[] result = ArcheryCompetition.solution(n, info);
        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    public void solution4() {
        int n = 10;
        int[] info = {0,0,0,0,0,0,0,0,3,4,3};
        int[] expected = {1,1,1,1,1,1,1,1,0,0,2};
        int[] result = ArcheryCompetition.solution(n, info);
        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

}