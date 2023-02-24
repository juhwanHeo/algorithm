package com.coding.kakaomobility;

import java.util.*;

public class Test3 {
    public static int solution(int[] A) {
        // write your code in Java SE 8
        int answer = 0;

        Set<Integer> oddSet = new HashSet<>();
        Set<Integer> evenSet = new HashSet<>();
        int oddCnt = 0;
        int evenCnt = 0;
        System.out.println("Arrays.toString(A) = " + Arrays.toString(A));

        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) {
                if (evenSet.isEmpty() || evenSet.contains(A[i])){
                    evenSet.add(A[i]);
                    evenCnt ++;
                }
                else {
                    evenSet.clear();
                    evenSet.add(A[i]);
                    evenCnt = 1;
                }
            }
            else {
                if (oddSet.isEmpty() || oddSet.contains(A[i])){
                    oddSet.add(A[i]);
                    oddCnt ++;
                }
                else {
                    oddSet.clear();
                    oddSet.add(A[i]);
                    oddCnt = 1;
                }
            }

            answer = Math.max(evenCnt + oddCnt, answer);
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] A = {
//                3,2,3,2,3 // 5
                0,2,3,1,2,4,3,4,5,5
        };

        System.out.println("solution(A) = " + solution(A));
    }
}
