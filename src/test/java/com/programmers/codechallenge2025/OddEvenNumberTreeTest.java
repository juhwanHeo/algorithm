package com.programmers.codechallenge2025;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class OddEvenNumberTreeTest {

  @Test
  public void solutionTest1() {
    int[] nodes = {
        11, 9, 3, 2, 4, 6
    };
    int[][] edges = {
        {9, 11},
        {2, 3},
        {6, 3},
        {3, 4},
    };
    int[] expected = {1, 0};  // 홀짝, 역홀짝

    int[] result = OddEvenNumberTree.solution(nodes, edges);

    log.info("result: {}",Arrays.toString(result));
    assertEquals(expected, result);
  }

  @Test
  public void solutionTest2() {
    int[] nodes = {
        9, 15, 14, 7, 6, 1, 2, 4, 5, 11, 8, 10
    };

    int[][] edges = {
        {5, 14},
        {1, 4},
        {9, 11},
        {2, 15},
        {2, 5},
        {9, 7},
        {8, 1},
        {6, 4},
    };

    int[] expected = {2, 1};

    int[] result = OddEvenNumberTree.solution(nodes, edges);

    log.info("result: {}",Arrays.toString(result));
    assertEquals(expected, result);
  }
}