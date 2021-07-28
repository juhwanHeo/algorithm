package com.coding.kakao2021summer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Node implements Comparable<Node>{
    int start, end, weight;

    public Node(int start, int end, int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public boolean isTrap(int[] traps) {
        return Arrays.stream(traps)
                .anyMatch(value -> value == start || value == end);
    }

    public void swap() {
        int temp = start;
        start = end;
        end = temp;
    }


    @Override
    public int compareTo(Node node) {
        return weight - node.weight;
    }

    @Override
    public String toString() {
        return "(" + start +
                " --> " +
                end + ") [" + weight + "]";
    }
}

public class Test4 {
    static int v;
    static List<Node> list;
    static int[] dist;

    public static int solution(int n, int start, int end, int[][] roads, int[] traps) {
        int answer = 0;
        v = n;
        dist = new int[v + 1];
        list = new ArrayList<>();
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int[] roadList : roads) {
            list.add(new Node(roadList[0], roadList[1], roadList[2]));
        }

        dijkstra(start, traps);
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= v; i++){
            if(dist[i] == Integer.MAX_VALUE) sb.append("INF ");
            else sb.append(dist[i]).append(" ");
        }
//        answer = Arrays.stream(dist).filter((dis) -> dis != Integer.MAX_VALUE).sum();
        answer = dist[end-1];
        return answer;
    }

    private static void dijkstra(int start, int[] traps){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] check = new boolean[v + 1];
        queue.add(new Node(0, start,0));
        dist[start] = 0;

        while(!queue.isEmpty()){
            System.out.println("\n=====================");
            System.out.println("queue: " + queue);
            Node curNode = queue.poll();
            int cur = curNode != null ? curNode.end : 0;
            if(check[cur]) continue;
            check[cur] = true;

            System.out.println("list: " + list);
            System.out.println("curNode: " + curNode);
            for(Node node : list){
                System.out.println("node: " + node);
                System.out.println("dist: " + Arrays.toString(dist));
                if(node.isTrap(traps)) {
                    node.swap();
                    check[cur] = false;
                }
                if(dist[node.end] > dist[cur] + node.weight){
                    dist[node.end] = dist[cur] + node.weight;
                    System.out.println("dist if in: " + Arrays.toString(dist));
                    queue.add(new Node(node.start, node.end, dist[node.end]));
                }
                System.out.println("---------------------");
            }
        }
    }

    public static void main(String[] args) {
        int[][] roads1 = {{1, 2, 2}, {3, 2, 3}};
        int[] traps1 = {2};
        int answer1 = solution(3, 1, 3, roads1, traps1);

        int[][] roads2 = {{1, 2, 1}, {3, 2, 1}, {2, 4, 1}};
        int[] traps2 = {2, 3};
//        int answer2 = solution(4, 1, 4, roads2, traps2);

        System.out.println("answer1 my: "+ answer1);
        System.out.println("answer1 answer: 5");
        System.out.println("answer1 equals: " + (5 == answer1));

        System.out.println("--------------------");
//        System.out.println("answer2: "+ answer2);
//        System.out.println("answer2 answer: 4");
//        System.out.println("answer2 equals: " + (4 == answer2));
    }

}


//            boolean isTrap = Arrays.stream(traps)
//                        .noneMatch((a) -> a == cur);
