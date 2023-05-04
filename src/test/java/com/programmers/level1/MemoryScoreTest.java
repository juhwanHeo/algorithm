package com.programmers.level1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MemoryScoreTest {

    @Test
    void solution1() {
        String[] name = {
                "may", "kein", "kain", "radi"
        };
        int[] yearning = {
                5, 10, 1, 3
        };
        String[][] photo ={
                {"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}
        };


        int[] result = MemoryScore.solution(name, yearning, photo);
        int[] expected = {19, 15, 6};


        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(result, expected);
    }

    // ["kali", "mari", "don"]	[11, 1, 55]	[["kali", "mari", "don"], ["pony", "tom", "teddy"], ["con", "mona", "don"]]	[67, 0, 55]
    @Test
    void solution2() {
        String[] name = {
                "kali", "mari", "don"
        };
        int[] yearning = {
                11, 1, 55
        };
        String[][] photo ={
                {"kali", "mari", "don"}, {"pony", "tom", "teddy"}, {"con", "mona", "don"}
        };


        int[] result = MemoryScore.solution(name, yearning, photo);
        int[] expected = {67, 0, 55};

        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(result, expected);
    }

    //["may", "kein", "kain", "radi"]	[5, 10, 1, 3]	[["may"],["kein", "deny", "may"], ["kon", "coni"]]	[5, 15, 0]
    @Test
    void solution3() {
        String[] name = {
                "may", "kein", "kain", "radi"
        };
        int[] yearning = {
                5, 10, 1, 3
        };
        String[][] photo ={
                {"may"},{"kein", "deny", "may"}, {"kon", "coni"}
        };


        int[] result = MemoryScore.solution(name, yearning, photo);
        int[] expected = {5, 15, 0};

        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(result, expected);
    }
}