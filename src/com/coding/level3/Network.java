package com.coding.level3;

import java.util.Arrays;
/*
 * @level3
 * @TestName: 네트워크
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/43162
 */
public class Network {

    public static int solution(int n, int[][] computers) {
        int one = 0;
        for (int[] computer : computers) {
            one += findOne(computer);
        }
        if(n == one) return n;
        System.out.println("one: " + one);
        System.out.println("n: " + n);
        return (int) (n - Math.round((one - n) / 2.0));

    }

    static long findZero(int[] computers) {
        return Arrays.stream(computers)
                .filter(val -> val >= 1)
                .count();
    }

    static long findOne(int[] computers) {
        return Arrays.stream(computers)
                .filter(val -> val >= 1)
                .count();
    }

    public static void main(String[] args) {
        int n1 = 3;
        int[][] computers = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };
        int return1 = 2;
        //
        //        return n- (zero - n) /2;
        //
        int n2 = 4;
        int[][] computers2 = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {1, 1, 0, 1}
        };
        int return2 = 1;
//        int myRes = solution(n1, computers);
//        System.out.println(myRes);
//        System.out.println(myRes == return1);

        int myRes2 = solution(n2, computers2);
        System.out.println(myRes2);
        System.out.println(myRes2 == return2);
    }

}
