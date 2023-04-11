package com.programmers.level2;

import java.util.*;

/*
 * @level2
 * @TestName: 연속된 부분 수열의 합
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/178870
 * @COMMENT: 투 포인터
 */
public class PartitionSum {

    static class Point implements Comparable<Point> {
        int start, end, length;

        public Point(int start, int end, int length) {
            this.start = start;
            this.end = end;
            this.length = length;
        }

        @Override
        public int compareTo(Point o) {
            if (length != o.length) return Integer.compare(length, o.length);
            return Integer.compare(start, o.start);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "start=" + start +
                    ", end=" + end +
                    ", length=" + length +
                    '}';
        }
    }

    public static int[] solution(int[] sequence, int k) {
        int[] answer = {0, Integer.MAX_VALUE};
        int left = 0, right = 0;
        int sum = sequence[0];
        List<Point> list = new ArrayList<>();

        while (true) {
            System.out.println(left + ", " + right +", sum = " + sum + ", " + (left >= sequence.length) + ", " + (right >= sequence.length));
            if (left >= sequence.length || right >= sequence.length) break;
            if (k < sum) {
                sum -= sequence[left++];
            }
            else if (k > sum) {
                right += 1;
                if (right < sequence.length) sum += sequence[right];
            }
            else {
                list.add(new Point(left, right, right - left));
                sum -= sequence[left++];
            }
        }

        Collections.sort(list);
        answer[0] = list.get(0).start;
        answer[1] = list.get(0).end;
        return answer;
    }

}
