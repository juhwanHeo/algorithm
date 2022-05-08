package com.programmers.weekly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Weekly 2
 * @TestName: 상호 평가
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/83201
 * @COMMENT:
 */
public class Task2 {
    public static String solution(int[][] scores) {
        int[][] myScores = new int[scores.length][scores[0].length];
        List<Double> avg = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            for (int k = 0; k < scores[0].length; k++) {
                myScores[i][k] = scores[k][i];
            }
        }

        for (int i = 0; i < myScores.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < myScores[0].length; j++) {
                if(i == j) {
                    // 자신이 받은 점수중 자기가 준 점수가 재일 높거나 낮을 경우 continue;
                    int myMax = Arrays.stream(myScores[i])
                            .max()
                            .orElse(Integer.MIN_VALUE);
                    int myMin = Arrays.stream(myScores[i])
                            .min()
                            .orElse(Integer.MAX_VALUE);
                    if (myScores[i][i] == myMax) {
                        if(Arrays.stream(myScores[i])
                                .filter(val -> val == myMax)
                                .count() > 1)
                            list.add(myScores[i][j]);
                        continue;
                    }
                    else if (myScores[i][i] == myMin) {
                        if(Arrays.stream(myScores[i])
                                .filter(val -> val == myMin)
                                .count() > 1)
                            list.add(myScores[i][j]);
                        continue;
                    }
                }
                list.add(myScores[i][j]);
            }
            // 평균
            avg.add(list.stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .orElse(-0.1));
        }

        StringBuffer answer = new StringBuffer();
        avg.forEach(val -> {
           answer.append(hak(val));
        });
        return answer.toString();
    }


    static String hak(double score) {
        String grade;
        switch ((int) score / 10) {
            case 10:
            case 9:
                grade = "A";
                break;
            case 8:
                grade = "B";
                break;
            case 7:
                grade = "C";
                break;
            case 6:
            case 5:
                grade = "D";
                break;
            default:
                grade = "F";
        }
        return grade;
    }

    public static void main(String[] args) {
        int[][] scores1 = {
                {100,90,98,88,65},
                {50,45,99,85,77},
                {47,88,95,80,67},
                {61,57,100,80,65},
                {24,90,94,75,65}
        };

        /*
        * [
        *   [100, 50, 47, 61, 24],
        *   [90, 45, 88, 57, 90],
        *   [98, 99, 95, 100, 94],
        *   [88, 85, 80, 80, 75],
        *   [65, 77, 67, 65, 65]
        * ]
        * */

        int[][] scores2 = {
                {75, 50, 100},
                {75, 100, 20},
                {100, 100, 20}
        };
        /*
         *
         * [
         *      [75, 75, 100],
         *      [50, 100, 100],
         *      [100, 20, 20]
         * ]
         * */

        String myRes1 = solution(scores1);
        String myRes2 = solution(scores2);
        System.out.println("res1: FBABD");
        System.out.println("myRes1: " + myRes1);
        System.out.println("res2: BBF");
        System.out.println("myRes2: " + myRes2);
    }
}
