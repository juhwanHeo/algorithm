package com.coding.kakao2020.blind;

import java.util.*;

/*
 * @2020 kakao blind
 * @TestName: 기둥과 보 설치
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/60061?language=java
 */

public class Test5 {

    static class Frame implements Comparable<Frame> {
        int x;
        int y;
        int type;

        public Frame(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }

        @Override
        public String toString() {
            return "["  + x +
                    ", " + y +
                    ", " + type +
                    ']';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Frame frame = (Frame) o;
            return x == frame.x && y == frame.y && type == frame.type;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, type);
        }

        @Override
        public int compareTo(Frame frame) {
            if (x != frame.x) return Integer.compare(x, frame.x);
            else if (y != frame.y) return Integer.compare(y, frame.y);
            return Integer.compare(type, frame.type);
        }
    }
    static PriorityQueue<Frame> pq;
    public static int[][] solution(int n, int[][] build_frame) {
        pq = new PriorityQueue<>();
        for (int[] frame : build_frame) {
            int cmd = frame[3];
            Frame bFrame = new Frame(frame[0], frame[1], frame[2]);
            // cmd :
            // 1 설치
            // 0 삭제
            if (cmd == 1) {
                if (isBuild(bFrame)) pq.offer(bFrame);
            }
            else {
                /*
                * 해당 frame 삭제후 해당 구조물이 조건에 만족하는지 체크
                * */
                pq.remove(bFrame);
                if (!isRemove())  pq.offer(bFrame);
            }
        }

        int[][] answer = new int[pq.size()][3];
        int index = 0;
        while (!pq.isEmpty()) {
            Frame frame = pq.poll();
            answer[index][0] = frame.x;
            answer[index][1] = frame.y;
            answer[index++][2] = frame.type;
        }

        return answer;
    }

    private static boolean isBuild(Frame frame) {
        System.out.println("=========Build==========");
        System.out.println("frame: " + frame);
        // 0 기둥, 1 보
        if (frame.type == 0) return isBuildColumn(frame.x, frame.y);
        else return isBuildBo(frame.x, frame.y);
    }

    private static boolean isRemove() {
        System.out.println("=========Remove==========");
        for (Frame frame : pq) {
            // 0 기둥, 1 보
            if(frame.type==0) {
                if(!isBuildColumn(frame.x, frame.y)) return false;

            } else {
                if(!isBuildBo(frame.x, frame.y)) return false;
            }
        }
        return true;
    }

    private static boolean isBuildColumn(int x , int y) {
          return y == 0
                || pq.contains(new Frame(x,y - 1,0))
                || pq.contains(new Frame(x - 1 ,y,1))
                || pq.contains(new Frame(x , y,1));

//        return y == n + 1
//                || frameArr[y + 1][x] == 0
//                || frameArr[y][x - 1] == 1
//                || frameArr[y][x] == 1;
    }

    private static boolean isBuildBo(int x, int y) {

        return pq.contains(new Frame(x,y - 1,0))
                || pq.contains(new Frame(x + 1,y - 1,0))
                || (pq.contains(new Frame(x - 1,y,1)) && pq.contains(new Frame(x + 1,y,1)));

//        return frameArr[y + 1][x] == 0
//                || frameArr[y + 1][x + 1] == 0
//                || (frameArr[y][x - 1] == 1 && frameArr[y][x + 1] == 1);
    }


    public static void main(String[] args) {
        int n = 5;
        int[][] build_frame1 = {
                {1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}
        };
        int[][] res1 = {
                {1,0,0},{1,1,1},{2,1,0},{2,2,1},{3,2,1},{4,2,1},{5,0,0},{5,1,0}
        };
        int[][] build_frame2 = {
                {0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}
        };
        int[][] res2 = {
                {0,0,0},{0,1,1},{1,1,1},{2,1,1},{3,1,1},{4,0,0}
        };

        /*
        *
        * [[-1, -1, -1, -1, -1, -1], [-1, -1, -1, -1, -1, -1], [-1, -1, -1, -1, -1, -1], [-1, -1, -1, -1, -1, -1], [-1, -1, 0, -1, -1, 0], [-1, 0, -1, -1, -1, 0]]
        *
        * */
        int[][] myRes1 = solution(n, build_frame1);
        System.out.println("myRes1: " + Arrays.deepToString(myRes1));
        System.out.println("res1: " + Arrays.deepToString(res1));
        System.out.println(Arrays.deepEquals(res1, myRes1));
        int[][] myRes2 = solution(n, build_frame2);
        System.out.println("myRes2: " + Arrays.deepToString(myRes2));
        System.out.println("res2: " + Arrays.deepToString(res2));
        System.out.println(Arrays.deepEquals(res2, myRes2));
    }

}

