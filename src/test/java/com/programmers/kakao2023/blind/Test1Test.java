package com.programmers.kakao2023.blind;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Test1Test {

    @Test
    public void solution1() {
        String today = "2022.05.19";
        String[] terms = {
                "A 6", "B 12", "C 3"
        };
        String[] privacies = {
                "2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"
        };


        int[] expected = {1, 3};
        int[] result = Test1.solution(today, terms, privacies);
        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }


    @Test
    public void solution2() {
        String today = "2020.01.01";
        String[] terms = {
                "Z 3", "D 5"
        };
        String[] privacies = {
                "2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"
        };


        int[] expected = {1, 4, 5};
        int[] result = Test1.solution(today, terms, privacies);
        System.out.println("result = " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }
}
