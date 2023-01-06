package com.programmers.level3;

import com.coding.utils.MakeJavaArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class LighthouseTest {

    @Test
    public void solution1() {
        int n = 8;
        int[][] lighthouse = MakeJavaArray.replaceIntArray2("[[1, 2], [1, 3], [1, 4], [1, 5], [5, 6], [5, 7], [5, 8]]");
        int expected = 2;
        int result = Lighthouse.solution(n, lighthouse);
        System.out.println("result = " + result);
        Assertions.assertEquals(expected, result);
    }


    @Test
    public void solution2() {
        int n = 10;
        int[][] lighthouse = MakeJavaArray.replaceIntArray2("[[4, 1], [5, 1], [5, 6], [7, 6], [1, 2], [1, 3], [6, 8], [2, 9], [9, 10]]");
        int expected = 3;
        int result = Lighthouse.solution(n, lighthouse);
        System.out.println("result = " + result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void solution3() {
        int n = 3;
        int[][] lighthouse = MakeJavaArray.replaceIntArray2("[[1, 2], [2, 3]]");
        int expected = 1;
        int result = Lighthouse.solution(n, lighthouse);
        System.out.println("result = " + result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void solution4() {
        int n = 2;
        int[][] lighthouse = MakeJavaArray.replaceIntArray2("[[1, 2]]");
        int expected = 1;
        int result = Lighthouse.solution(n, lighthouse);
        System.out.println("result = " + result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void solution5() {
        int n = 8;
        int[][] lighthouse = MakeJavaArray.replaceIntArray2("[[1, 2], [1, 3], [1, 4], [1, 5], [5, 6], [5, 7], [5, 8], [6, 7], [8, 6], [7, 8]]");
        int expected = 3;
        int result = Lighthouse.solution(n, lighthouse);
        System.out.println("result = " + result);
        Assertions.assertEquals(expected, result);
    }
}
