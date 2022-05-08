package com.programmers.level2;

import java.util.PriorityQueue;

/*
 * @level2
 * @TestName: 프린터
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/42587
 */
public class Printer {
    static class Print implements Comparable<Print> {
        int name;
        int priorities;

        Print(int name, int priorities) {
            this.name = name;
            this.priorities = priorities;
        }


        @Override
        public int compareTo(Print print) {
            return Integer.compare(print.priorities, this.priorities);
        }

        @Override
        public String toString() {
            return "Print{" +
                    "name='" + name + '\'' +
                    ", priorities=" + priorities +
                    "}";
        }
    }

    static int solution(int[] priorities, int location) {
        int answer = 1;
        PriorityQueue<Print> pq = new PriorityQueue<>();
        for (int i = 0; i < priorities.length; i++) {
            pq.offer(new Print(i, priorities[i]));
        }

        while(!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                Print print = pq.peek();
                System.out.println("print: " + print);
                if (print != null)  {
                    if (priorities[i] == print.priorities) {
                        System.out.println(pq);
                        System.out.println("i: " + i + ", location: " + location);
                        System.out.println();
                        if (i == location) return answer;
                        pq.poll();
                        answer++;
                    }
                }

            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] priorities1 = {2, 1, 3, 2};
        int location1 = 2;

        int[] priorities2 = {1, 1, 9, 1, 1, 1};
        int location2 = 0;

        System.out.println(solution(priorities1, location1));
        System.out.println("\n------------\n");
        System.out.println(solution(priorities2, location2));
    }
}
