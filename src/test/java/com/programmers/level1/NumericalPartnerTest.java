package com.programmers.level1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumericalPartnerTest {

    @Test
    void solution1() {
        String X = "100";
        String Y = "2345";
        String result = NumericalPartner.solution(X, Y);
        String expected = "-1";
        System.out.println("result = " + result);
        assertEquals(result, expected);
    }


    @Test
    void solution2() {
        String X = "100";
        String Y = "203045";
        String result = NumericalPartner.solution(X, Y);
        String expected = "0";
        System.out.println("result = " + result);
        assertEquals(result, expected);
    }


    @Test
    void solution3() {
        String X = "100";
        String Y = "123450";
        String result = NumericalPartner.solution(X, Y);
        String expected = "10";
        System.out.println("result = " + result);
        assertEquals(result, expected);
    }


    @Test
    void solution4() {
        String X = "12321";
        String Y = "42531";
        String result = NumericalPartner.solution(X, Y);
        String expected = "321";
        System.out.println("result = " + result);
        assertEquals(result, expected);
    }

    @Test
    void solution5() {
        String X = "5525";
        String Y = "1255";
        String result = NumericalPartner.solution(X, Y);
        String expected = "552";
        System.out.println("result = " + result);
        assertEquals(result, expected);
    }

    @Test
    void solution6() {
        String X = "3082003";
        String Y = "3003020";
        String result = NumericalPartner.solution(X, Y);
        String expected = "332000";
        System.out.println("result = " + result);
        assertEquals(result, expected);
    }


}