package com.programmers.kakao2022.insternship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodingTestStudyTest {
    @Test
    public void solution1() {
        int alp = 10;
        int cop = 10;
        int[][] problems = {
                {10,15,2,1,2},
                {20,20,3,3,4}
        };
        int expected = 15;
        int result = CodingTestStudy.solution(alp, cop, problems);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void solution2() {
        int alp = 0;
        int cop = 0;
        int[][] problems = {
                {0,0,2,1,2},
                {4,5,3,1,2},
                {4,11,4,0,2},
                {10,4,0,4,2}
        };
        int expected = 13;
        int result = CodingTestStudy.solution(alp, cop, problems);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

}
