package com.programmers.level1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodFightCompetitionTest {

    @Test
    void solution1() {
        int[] food = {1, 3, 4, 6};
        String result = FoodFightCompetition.solution(food);
        String expected = "1223330333221";
        System.out.println("result = " + result);
        assertEquals(result, expected);
    }


    @Test
    void solution2() {
        int[] food = {1, 7, 1, 2};
        String result = FoodFightCompetition.solution(food);
        String expected = "111303111";
        System.out.println("result = " + result);
        assertEquals(result, expected);
    }
}