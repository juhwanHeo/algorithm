package com.programmers.level3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonnelReportTest {

    @Test
    void solution1() {
        int[][] scores = {
                {2, 2}, {1, 4}, {3, 2}, {3, 2}, {2, 1}
        };
        int expected = 4;
        int result = PersonnelReport.solution(scores);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution2() {
        int[][] scores = {
                {1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 1}
        };
        int expected = 1;
        int result = PersonnelReport.solution(scores);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }


    @Test
    void solution3() {
        int[][] scores = {
                {3, 1},
                {1, 4},
                {2, 3},
                {2, 3},
                {1, 5},
                {1, 0},
                {1, 0}
        };
        int expected = 5;
        int result = PersonnelReport.solution(scores);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }


    @Test
    void solution4() {
        int[][] scores = {
                {4, 1}, {2, 4}, {3, 5}
        };
        int expected = 2;
        int result = PersonnelReport.solution(scores);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }


    @Test
    void solution5() {
        int[][] scores = {
                {2, 2}, {2, 2}, {2, 3}, {3, 2}
        };
        int expected = 3;
        int result = PersonnelReport.solution(scores);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }


    @Test
    void solution6() {
        int[][] scores = {
                {2, 2}, {3, 3}, {3, 3}, {2, 2}, {4, 4}
        };
        int expected = -1;
        int result = PersonnelReport.solution(scores);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }
}