package com.programmers.level1;

/*
 * @level1
 * @TestName: 바탕화면 정리
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/161990
 */
public class CleanUpDesktop {
    static int[] solution(String[] wallpaper) {
        int minRow = Integer.MAX_VALUE, minCol = Integer.MAX_VALUE;
        int maxRow = Integer.MIN_VALUE, maxCol = Integer.MIN_VALUE;
        for (int i = 0; i < wallpaper.length; i++) {
            String[] split = wallpaper[i].split("");

            for (int j = 0; j < split.length; j++) {
                if (split[j].equals("#")) {
                    minRow = Math.min(minRow, i);
                    minCol = Math.min(minCol, j);
                    maxRow = Math.max(maxRow, i + 1);
                    maxCol = Math.max(maxCol, j + 1);
                }
            }
        }

        return new int[] {minRow, minCol, maxRow, maxCol};
    }
}
