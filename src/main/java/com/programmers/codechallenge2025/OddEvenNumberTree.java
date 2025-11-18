package com.programmers.codechallenge2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/*
홀수 노드
- 노드의 번호가 홀수이며 자식 노드의 개수가 홀수인 노드입니다.
짝수 노드
- 노드의 번호가 짝수이며 자식 노드의 개수가 짝수인 노드입니다.
역홀수 노드
- 노드의 번호가 홀수이며 자식 노드의 개수가 짝수인 노드입니다.
역짝수 노드
- 노드의 번호가 짝수이며 자식 노드의 개수가 홀수인 노드입니다.

홀짝 트리
- 홀수 노드와 짝수 노드로만 이루어진 트리입니다.
역홀짝 트리
- 역홀수 노드와 역짝수 노드로만 이루어진 트리입니다.
* */
@Slf4j
public class OddEvenNumberTree {

  static List<List<Integer>> adj;
  static int[] childes;
  public static int[] solution(int[] nodes, int[][] edges) {
    Arrays.sort(nodes);
    int nodeSize = nodes[nodes.length - 1];
    childes = new int[nodeSize + 1];

    adj = new ArrayList<>();
    for (int i = 0; i <= nodeSize; i++) adj.add(new ArrayList<>());

    for (int[] edge : edges) {
      adj.get(edge[0]).add(edge[1]);
      adj.get(edge[1]).add(edge[0]);
      childes[edge[0]]++;
      childes[edge[1]]++;
    }



    // log
    for (List<Integer> integers : adj) {
      log.info("adj: {}", integers);
    }
    log.info("Arrays.toString(childes): {}", Arrays.toString(childes));

    return new int[] { 0, 0 };
  }

  public static void dfs(int root, int next2) {

  }
}
