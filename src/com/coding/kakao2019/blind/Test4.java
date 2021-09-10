package com.coding.kakao2019.blind;

import java.util.*;

/*
 * @2019 kakao blind recruitment
 * @TestName: 무지의 먹방 라이브
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/42891
 */
public class Test4 {

    static class Food implements Comparable<Food> {
        int index;
        int time;

        public Food(int index, int time) {
            this.index = index;
            this.time = time;
        }

        @Override
        public int compareTo(Food food) {
            return Integer.compare(time, food.time);
        }

        @Override
        public String toString() {
            return "Food{" +
                    "index=" + index +
                    ", time=" + time +
                    '}';
        }
    }


    public static int solution(int[] food_times, long k) {
//        if(Arrays.stream(food_times).mapToLong(Long::valueOf).sum() <= k) return -1;
        List<Food> list = new ArrayList<>();
        long sum = 0;
        for (int i = 0; i < food_times.length; i++) {
            list.add(new Food(i + 1, food_times[i]));
            sum += food_times[i];
        }
        if (sum <= k) return -1;
        Collections.sort(list);

        long time = 0; // 먹은 시간
        long previous = 0; // 전에 먹은 음식 시간
        long length = food_times.length; // 남은 음식 개수

        while(time + ((list.get(0).time - previous) * length) <= k) {
            int now = list.remove(0).time;
            time += (now - previous) * length;
            length--;
            previous = now;
        }

        list.sort(Comparator.comparingInt(a -> a.index));
        return list.get((int) (k % length)).index;
    }

    public static void main(String[] args) {
        int[] food_times = {
                3, 1, 2
        };
        int k = 5;
        int res = 1;

        System.out.println(solution(food_times, k));

    }
}

