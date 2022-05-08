package com.programmers.weekly;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @Weekly 7
 * @TestName: 입실 퇴실
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/86048
 */
public class Task7 {
    public static int[] solution(int[] enters, int[] leaves) {
        Map<Integer, Integer> room = new HashMap<>();
        int[] answer = new int[enters.length];
        int enter = 0;
        int leave = 0;

        while(enter != enters.length && leave != enters.length) {
            room.put(enters[enter], leaves[leave]);

            if (room.size() > 1) {
                for (int key : room.keySet()) answer[key - 1]++;
                answer[enters[enter] - 1] += room.size() - 2;
            }
            System.out.println("room1: " + room);
            while (true) {
                if (leave < enters.length && room.containsKey(leaves[leave])) {
                    room.remove(leaves[leave]);
                    leave++;
                    System.out.println("room2: " + room);
                }
                else break;
            }
            enter++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] enter = {
//                1,3,2
                1,4,2,3
        };
        int[] leave = {
//                1,2,3
                2,1,3,4
        };
        int[] res = {
                0,1,1
        };

        System.out.println(Arrays.toString(solution(enter, leave)));

    }
}
