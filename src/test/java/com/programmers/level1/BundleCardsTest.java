package com.programmers.level1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BundleCardsTest {

    @Test
    void solution1() {
        String[] cards1 = {
                "i", "drink", "water"
        };
        String[] cards2 = {
                "want", "to"
        };
        String[] goal = {
                "i", "want", "to", "drink", "water"
        };
        String expected = "Yes";
        String result = BundleCards.solution(cards1, cards2, goal);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution2() {
        String[] cards1 = {
                "i", "water", "drink"
        };
        String[] cards2 = {
                "want", "to"
        };
        String[] goal = {
                "i", "want", "to", "drink", "water"
        };
        String expected = "No";
        String result = BundleCards.solution(cards1, cards2, goal);

        System.out.println("result = " + result);
        assertEquals(expected, result);
    }
}