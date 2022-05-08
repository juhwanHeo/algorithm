package com.programmers.kakao2019.blind;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @2019 kakao blind recruitment
 * @TestName: 후보키
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/42890
 * @COMMENT: https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%9B%84%EB%B3%B4%ED%82%A4-Java 참고
 *           비트 마스크 공부 필요
 *           코드 공부하기
 */
public class Test3 {
    static List<Set<Integer>> candidateKey;
    public static int solution(String[][] relation) {
        candidateKey = new ArrayList<>();
        int colSize = relation[0].length;

        for(int i = 1 ; i <= colSize ; ++i) {
            makeKeySet(-1, colSize - 1, 0, i, new HashSet<>(), relation);
        }

        return candidateKey.size();
    }

    private static void makeKeySet(int attr, int maxAttr, int idx, int size, Set<Integer> keySet, String[][] relation) {
        if(idx == size) {

            for(int i : keySet) System.out.print(i + " ");

            for(Set<Integer> key : candidateKey) {
                if(keySet.containsAll(key)) {
                    System.out.println("는 " + key + "를 포함합니다.");
                    return;
                }
            }

            if(isUnique(keySet, relation)) {
                System.out.println("는 후보키 입니다.");
                candidateKey.add(keySet);
            } else {
                System.out.println("는 후보키가 아닙니다.");
            }

            return;
        }

        for(int i = attr + 1 ; i <= maxAttr ; ++i) {
            HashSet<Integer> newKeySet = new HashSet<>(keySet);
            newKeySet.add(i);
            makeKeySet(i, maxAttr, idx + 1, size, newKeySet, relation);
        }
    }

    private static boolean isUnique(Set<Integer> keySet, String[][] relation) {
        Set<String> hs = new HashSet<>();

        for (String[] str : relation) {
            String key = "";
            for (int c : keySet) {
                key += str[c];
            }

            if (hs.contains(key)) return false;
            else hs.add(key);
        }
        return true;
    }


    public static void main(String[] args) {
       String[][] relation = {
                   {"100","ryan","music","2" },
                   {"200","apeach","math","2" },
                   {"300","tube","computer","3" },
                   {"400","con","computer","4" },
                   {"500","muzi","music","3" },
                   {"600","apeach","music","2" }
           };
       int res1 = 2;

       int myRes1 = solution(relation);
//       String[] myRes2 = solution(record2);
       System.out.println("myRes1: " + myRes1);
//       System.out.println("myRes2: " + Arrays.toString(myRes2));
//       System.out.println("myRes1: " + Arrays.equals(myRes1, res));

    }
}

