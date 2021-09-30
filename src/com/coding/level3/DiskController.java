package com.coding.level3;

import java.util.*;

/*
 * @level3
 * @TestName: 디스크 컨트롤러
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/42627
 */
public class DiskController {

    static class Job implements Comparable<Job> {
        int start;
        int time;

        Job(int start, int time) {
            this.start = start;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "start=" + start +
                    ", time=" + time +
                    '}';
        }

        @Override
        public int compareTo(Job o) {
            return Integer.compare(time, o.time);
        }
    }

    static int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        int cnt = 0;

        Queue<Job> queue = new LinkedList<>();
        Queue<Job> pq = new PriorityQueue<>();

        Arrays.sort(jobs, (a1, a2) -> a1[0] - a2[0]);
        for (int[] job : jobs) queue.offer(new Job(job[0], job[1]));

        while (cnt < jobs.length) {
            while (!queue.isEmpty() && time >= queue.peek().start){
                pq.offer(queue.poll());
            }

            if (!pq.isEmpty()) {
                Job job = pq.poll();
                answer += (time - job.start) + job.time;
                time += job.time;
                cnt++;
            }
            else time++;
        }

        return answer / jobs.length;
    }

    public static void main(String[] args) {
        int[][] arr1 = {
//                {0, 3},
//                {1, 9},
//                {2, 6} // 9
                {0, 10}, {2, 10}, {9, 10}, {15, 2} // 14
        };
        int res = 9;

        System.out.println(solution(arr1));
    }
}
