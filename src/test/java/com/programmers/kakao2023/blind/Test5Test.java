package com.programmers.kakao2023.blind;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Test5Test {

    @Test
    public void solution1() {
        String[] commands = {
                "UPDATE 1 1 menu",
                "UPDATE 1 2 category",
                "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice",
                "UPDATE 3 1 ramyeon",
                "UPDATE 3 2 korean", "UPDATE 3 3 noodle",
                "UPDATE 3 4 instant", "UPDATE 4 1 pasta",
                "UPDATE 4 2 italian", "UPDATE 4 3 noodle",
                "MERGE 1 2 1 3", "MERGE 1 3 1 4",
                "UPDATE korean hansik", "UPDATE 1 3 group",
                "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"
        };
        String[] expected = {
                "EMPTY", "group"
        };
        String[] result = Test5.solution(commands);
        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }


    @Test
    public void solution2() {
        String[] commands = {
                "UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1",
                "MERGE 2 1 1 1", "PRINT 1 2", "UNMERGE 2 2", "PRINT 1 1"
        };
        String[] expected = {
                "d", "EMPTY"
        };
        String[] result = Test5.solution(commands);
        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }
    @Test
    public void solution3() {
        String[] commands = {
                "UPDATE 1 1 A", "UPDATE 2 2 B",
                "UPDATE 3 3 C", "UPDATE 4 4 D",
                "MERGE 1 1 2 2", "MERGE 3 3 4 4", "MERGE 1 1 4 4", "UNMERGE 3 3",
                "PRINT 1 1", "PRINT 2 2", "PRINT 3 3", "PRINT 4 4"
        };
        String[] expected = {
                "EMPTY", "EMPTY", "A", "EMPTY"
        };
        String[] result = Test5.solution(commands);
        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

}
