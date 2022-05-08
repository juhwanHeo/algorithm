package com.programmers.level1;

import java.util.Arrays;

/*
 * @level1
 * @TestName: 로또의 최고 순위와 최저 순위
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/77484
 */
public class LottoRank {
    static int[] solution(int[] lottos, int[] win_nums) {
        int zeroCnt = (int) Arrays.stream(lottos)
                            .filter(val -> val == 0)
                            .count();
        int matchCnt = 0;
        for (int lotto : lottos) {
            for (int win_num : win_nums) {
                if(lotto == win_num) {
                    matchCnt++;
                    break;
                }
            }
        }
        int maxRank = rank(matchCnt);
        int minRank = rank(matchCnt + zeroCnt);
        return new int[]{minRank, maxRank};
    }

    private static int rank(int val) {
        int rank = 0;
        switch (val){
            case 6: rank  = 1; break;
            case 5: rank  = 2; break;
            case 4: rank  = 3; break;
            case 3: rank  = 4; break;
            case 2: rank  = 5; break;
            case 1:
            case 0: rank = 6; break;
        }
        return rank;
    }

    public static void main(String[] args) {
        int[] lottos1 = {44, 1, 0, 0, 31, 25};
        int[] win_nums1 = {31, 10, 45, 1, 6, 19};
        int[] res1 = {3, 5};
        System.out.println(Arrays.toString(solution(lottos1, win_nums1)));
    }
}
