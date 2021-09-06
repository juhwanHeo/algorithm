package com.coding.kakao2020.blind;

import java.util.*;

/*
 * @2020 kakao blind
 * @TestName: 자물쇠와 열쇠
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/60059?language=java
 * @COMMENT: https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%9E%90%EB%AC%BC%EC%87%A0%EC%99%80-%EC%97%B4%EC%87%A0-Java 참고
 */

public class Test3 {

    public static boolean solution(int[][] key, int[][] lock) {
        int size = lock.length - 1;

        for(int d = 0 ; d < 4 ; ++d) {
            int[][] rotatedKey = rotationKey(d, key);
            int[][] paddedKey = padding(rotatedKey, size);
            System.out.println(Arrays.deepToString(lock));
            System.out.println(Arrays.deepToString(paddedKey));
            System.out.println();

            for(int R = 0 ; R < paddedKey.length - size ; ++R) {
                for(int C = 0 ; C < paddedKey[0].length - size ; ++C) {
                    boolean flag = true;

                    for(int r = 0 ; r < lock.length ; ++r) {
                        for(int c = 0 ; c < lock[0].length ; ++c) {
                            if(lock[r][c] == paddedKey[R + r][C + c]) flag = false;
                        }
                    }

                    if(flag) return true;
                }
            }
        }

        return false;
    }


    private static int[][] padding(int[][] arr, int size) {
        int[][] res = new int[arr.length + size * 2][arr[0].length + size * 2];
        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < arr[0].length; k++) {
                res[i + size][k + size] = arr[i][k];
            }
        }

        return res;
    }

    private static int[][] deepCopy(int[][] arr) {
        int[][] res = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < arr[0].length; k++) {
                res[i][k] = arr[i][k];
            }
        }

        return res;
    }

    private static int[][] rotationKey(int cnt, int[][] arr) {
        if (cnt == 0) return arr;

        int[][] res = null;
        int[][] origin = deepCopy(arr);

        for (int i = 0; i < cnt; i++) {
            res = new int[arr.length][arr[0].length];

            for (int r = 0; r < origin.length; r++) {
                for (int c = 0; c < origin[0].length; c++) {
                    res[c][origin.length - 1 - r] = origin[r][c];
                }
            }
            origin = res;
        }
        return res;
    }

    /*
    * [0, 0, 0, 0, 0, 0, 0],
    * [0, 0, 0, 0, 0, 0, 0],
    * [0, 0, 0, 1, 0, 0, 0],
    * [0, 0, 1, 0, 0, 0, 0],
    * [0, 0, 1, 0, 0, 0, 0],
    * [0, 0, 0, 0, 0, 0, 0],
    * [0, 0, 0, 0, 0, 0, 0]
    * */

    public static void main(String[] args) {
        int[][] key1 = {
                {0, 0, 0},
                {1, 0, 0},
                {0, 1, 1}
                /*
                [
                [0, 1, 0],
                [1, 0, 0],
                [1, 0, 0]
                ]
                [1, 1, 0],
                [0, 0, 1],
                [0, 0, 0]
                */
        };
        int[][] lock1 = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        System.out.println("myRes1: " + solution(key1, lock1));
    }


//    static boolean isOk(int[][] key, int[][] lock) {
//        int[][] rLock = deepCopy(lock);
//        for (int i = 0; i < rLock.length; i++) {
//            for (int k = 0; k < rLock.length; k++) {
//                if (rLock[i][k] == 1) continue;
//                if (key[i][k] == 1) rLock[i][k] = 1;
//            }
//        }
//        return Arrays.stream(rLock)
//                .allMatch(arr -> Arrays.stream(arr)
//                        .allMatch(val -> val == 1)
//                );
//    }
//
//
//    static int[][] rotate(int[][] arr, int degree) {
//        int[][] rotate;
//        int n = arr.length;
//        int m = arr[0].length;
//
//        switch (degree) {
//            case 90:
//            case 270:
//                rotate = new int[m][n];
//                break;
//            case 180:
//                rotate = new int[n][m];
//                break;
//            default:
//                return arr;
//        }
//
//        for (int i = 0; i < rotate.length; i++) {
//            for (int j = 0; j < rotate[i].length; j++) {
//                switch (degree) {
//                    case 90:
//                        rotate[i][j] = arr[n-1-j][i];
//                        break;
//                    case 180:
//                        rotate[i][j] = arr[n-1-i][m-1-j];
//                        break;
//                    case 270:
//                        rotate[i][j] = arr[j][m-1-i];
//                        break;
//                }
//            }
//        }
//
//        return rotate;
//    }

}

