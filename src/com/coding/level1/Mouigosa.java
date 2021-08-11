package com.coding.level1;

import java.util.*;

/*
 * @level1
 * @TestName: 모의고사
 * @URL:https://programmers.co.kr/learn/courses/30/lessons/42840
 */
public class Mouigosa {
    static int[] person1 = {1, 2, 3, 4, 5};
    static int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
    static int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    public static int[] solution(int[] answers) {
        int[] cnt = {0, 0, 0};

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == person1[i % person1.length])
                cnt[0]++;
            if(answers[i] == person2[i % person2.length])
                cnt[1]++;
            if(answers[i] == person3[i % person3.length])
                cnt[2]++;
        }

        return findIndex(cnt);
    }

    static int[] findIndex(int[] cntArr) {
        List<Integer> index = new ArrayList<>();
        int max = Arrays.stream(cntArr)
                .max()
                .orElse(Integer.MIN_VALUE);

        for (int i = 0; i < cntArr.length; i++) {
            if(cntArr[i] == max) index.add(i+1);
        }
        return index.stream()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        int[] answers1 = {1,2,3,4,5};
        int[] res1 = {1};
        int[] answer2 = {1,3,2,4,2};
        int[] res2 = {1,2,3};

        int[] myRes1 = solution(answers1);
        int[] myRes2 = solution(answer2);

        System.out.println("myRes1: " + Arrays.toString(myRes1));
        System.out.println("myRes2: " + Arrays.toString(myRes2));

    }
}
