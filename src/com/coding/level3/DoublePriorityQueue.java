package com.coding.level3;

import java.util.*;

/*
 * @level3
 * @TestName: 이중 우선순위 큐
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/42628
 */
public class DoublePriorityQueue {

    static int[] solution(String[] operations) {
        int[] answer = new int[2];
        Queue<Integer> pqMin = new PriorityQueue<>();
        Queue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            String[] split = operation.split(" ");
            String cmd = split[0];
            int val = Integer.parseInt(split[1]);

            if (cmd.equals("I")) {
                pqMax.offer(val);
                pqMin.offer(val);
            }
            else {
                if (pqMin.size() + pqMax.size() == 0) continue;
                if (val == 1) {
                    int max = pqMax.poll();
                    pqMin.remove(max);

                }
                else {
                    int min = pqMin.poll();
                    pqMax.remove(min);
                }
            }
        }

        if (pqMax.size() + pqMin.size() != 0) {
            answer[0] = pqMax.poll();
            answer[1] = pqMin.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] cmd = {
//                "I 16","D 1" // [0, 0]
                "I 7","I 5","I -5","D -1" //[7, 5]
        };
        int res = 9;

        System.out.println(Arrays.toString(solution(cmd)));
    }
}
