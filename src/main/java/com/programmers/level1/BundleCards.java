package com.programmers.level1;

/*
 * @level1
 * @TestName: 자릿수 더하기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12931
 */
public class BundleCards {
    static String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";

        int idx1 = 0, idx2 = 0, goalIdx = 0;




        while (goalIdx < goal.length) {
            if (idx1 < cards1.length && goal[goalIdx].equals(cards1[idx1])) {
                idx1++;
                goalIdx++;
                continue;
            }
            else if (idx2 < cards2.length && goal[goalIdx].equals(cards2[idx2])) {
                idx2++;
                goalIdx++;
                continue;
            }

            answer = "No";
            break;
        }
        return answer;
    }
}
