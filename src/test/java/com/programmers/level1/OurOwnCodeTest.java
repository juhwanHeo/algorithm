package com.programmers.level1;

import com.programmers.kakao2021.blind.Test6BFS;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OurOwnCodeTest {

    @Test
    void solution() {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;
        String expected = "happy";
        String result = OurOwnCode.solution(s, skip, index);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }
}