package com.programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

/*
 * @level2
 * @TestName: 광물 캐기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/172927
 */
public class MineralsMining {

    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;

        Arrays.sort(minerals, Comparator.reverseOrder());


        System.out.println(Arrays.toString(minerals));

        for (String mineral : minerals) {
            int type = 0;
            if (picks[2] > 0) type = 2;
            else if (picks[1] > 0) type = 1;
            else type = 0;

//            picks

        }

        return answer;
    }

    private static int calc(int type, String mineral) {
        int result = 1;
        if (type == 2) {
            switch (mineral) {
                case "diamond": result = 25; break;
                case "iron": result = 5; break;
                case "stone": result = 1; break;
            }
        } else if (type == 1) {
            switch (mineral) {
                case "diamond": result = 5; break;
                case "iron":
                case "stone": result = 1; break;
            }
        }

        return result;
    }



}
