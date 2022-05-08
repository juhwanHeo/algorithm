package com.programmers.weekly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @Weekly 4
 * @TestName: 직업군 추천하기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/84325?language=java
 */
public class Task4 {
    static class Job implements Comparable<Job> {
        String name;
        int score;

        @Override
        public String toString() {
            return "Job{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    "}\n";
        }

        @Override
        public int compareTo(Job job) {
//            if (this.score < job.score) return 1;
//            else if(this.score == job.score) {
//                if (this.name.compareTo(job.name) > 0) return 1;
//            }
//            return -1;
            if (this.score != job.score) return Integer.compare(job.score, this.score);
            return this.name.compareTo(job.name);
        }
    }

    public static String solution(String[] tables, String[] languages, int[] preference) {
        List<Job> list = new ArrayList<>();
        for (String table : tables) {
            String[] split = table.split(" ");
            Job job = new Job();
            job.name = split[0];
            int langScore = 5;
            for (int i = 1; i < split.length; i++) {
                for (int k = 0; k < languages.length; k++) {
                    if (split[i].equals(languages[k])) job.score += langScore * preference[k];
                }
                langScore--;
            }
            list.add(job);
        }

        Collections.sort(list);
        System.out.println(list);
        return list.get(0).name;
    }

    public static void main(String[] args) {
        String[] tables1 = {
                "SI JAVA JAVASCRIPT SQL PYTHON C#",
                "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
                "HARDWARE C C++ PYTHON JAVA JAVASCRIPT",
                "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
                "GAME C++ C# JAVASCRIPT C JAVA"
        };
        String[] lang1  = {"PYTHON", "C++", "SQL"};
        int[] preference1 = {7, 5, 5};

        String myRes = solution(tables1, lang1, preference1);
        System.out.println("res: " + "HARDWARE");
        System.out.println("myRes: " + myRes);
    }
}
