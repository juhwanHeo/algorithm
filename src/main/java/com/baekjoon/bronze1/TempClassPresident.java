package com.baekjoon.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * @bronze1
 * @TestName: 임시 반장 정하기
 * @URL: https://www.acmicpc.net/problem/1268
 */
public class TempClassPresident {

    public static class Student implements Comparable<Student>{

        int num;
        int same;
        int[] classes;
        List<Integer> friendList;

        public Student(int num, int[] classes) {
            this.num = num;
            this.classes = classes;
            friendList = new ArrayList<>();
        }

        @Override
        public String toString() {
            return "Student{" +
                    "num=" + num +
                    ", same=" + same +
                    ", classes=" + Arrays.toString(classes) +
                    "}\n";
        }

        @Override
        public int compareTo(Student o) {
            if (same != o.same) return Integer.compare(o.same, same);
            return Integer.compare(num, o.num);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] split =  br.readLine().split(" ");
            int[] classes = new int[5];
            for (int j = 0; j < 5; j++) classes[j] = Integer.parseInt(split[j]);

            studentList.add(new Student(i + 1, classes));
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < studentList.size(); j++) {
                for (int k = j + 1; k < studentList.size(); k++) {
                    Student student1 = studentList.get(j);
                    Student student2 = studentList.get(k);
                    if (student1.classes[i] == student2.classes[i]
                            && !student1.friendList.contains(student2.num)) {
                        student1.same++;
                        student2.same++;

                        student1.friendList.add(studentList.get(k).num);
                        student2.friendList.add(studentList.get(j).num);
                    }
                }
            }
        }

        Collections.sort(studentList);
        System.out.println("studentList = " + studentList);
        System.out.println(studentList.get(0).num);
    }

}

