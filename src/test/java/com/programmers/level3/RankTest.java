package com.programmers.level3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {
    @Test
    public void solution1() {
        int n = 5;
        int[][] results = {
                {4, 3},
                {4, 2},
                {3, 2},
                {1, 2},
                {2, 5}
        };
        int expected = 2;
        int result = Rank.solution(n, results);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }
    @Test
    public void solution2() {
        int n = 5;

        int[][] results = {
                {1, 4},
                {4, 2},
                {2, 5},
                {5, 3}
        };
        int expected = 5;
        int result = Rank.solution(n, results);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }
    @Test
    public void solution3() {
        int n = 7;
        int[][] results = {
                {4, 3},
                {4, 2},
                {3, 2},
                {1, 2},
                {2, 5},
                {5,6},
                {6,7}
        };

        int expected = 4;
        int result = Rank.solution(n, results);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }
    @Test
    public void solution4() {
        int n = 9;
        int[][] results = {
                {1,2},
                {1,3},
                {1,4},
                {1,5},
                {6,1},
                {7,1},
                {8,1},
                {9,1}
        };

        int expected = 1;
        int result = Rank.solution(n, results);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

}