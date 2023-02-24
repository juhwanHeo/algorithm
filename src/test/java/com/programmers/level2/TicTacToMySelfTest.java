package com.programmers.level2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToMySelfTest {

    @Test
    void solution1() {
        String[] board = {
                "O.X",
                ".O.",
                "..X"
        };
        int expected = 1;
        int result = TicTacToMySelf.solution(board);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution2() {
        String[] board = {
                "OOO",
                "...",
                "XXX"
        };
        int expected = 0;
        int result = TicTacToMySelf.solution(board);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution3() {
        String[] board = {
                "...",
                ".X.",
                "..."
        };
        int expected = 0;
        int result = TicTacToMySelf.solution(board);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution4() {
        String[] board = {
                "...",
                "...",
                "..."
        };
        int expected = 1;
        int result = TicTacToMySelf.solution(board);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution5() {
        String[] board = {
                "O.X",
                ".OX",
                "..O"
        };
        int expected = 1;
        int result = TicTacToMySelf.solution(board);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution6() {
        String[] board = {
                "O.X",
                ".OX",
                "OOX"
        };
        int expected = 0;
        int result = TicTacToMySelf.solution(board);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution7() {
        String[] board = {
                "OXX",
                "OOX",
                "OXO"
        };
        int expected = 1;
        int result = TicTacToMySelf.solution(board);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution8() {
        String[] board = {
                "OOO",
                "OXX",
                "OXX"
        };
        int expected = 1;
        int result = TicTacToMySelf.solution(board);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution9() {
        String[] board = {
                "OXO",
                "OOX",
                "OXX"
        };
        int expected = 1;
        int result = TicTacToMySelf.solution(board);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution10() {
        String[] board = {
                "XO.",
                "OXO",
                "XOX"
        };
        int expected = 1;
        int result = TicTacToMySelf.solution(board);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution11() {
        String[] board = {
                "OOO",
                "O..",
                "XXX"
        };
        int expected = 0;
        int result = TicTacToMySelf.solution(board);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution12() {
        String[] board = {
                "OXX",
                "O.X",
                "OXO"
        };
        int expected = 0;
        int result = TicTacToMySelf.solution(board);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

}