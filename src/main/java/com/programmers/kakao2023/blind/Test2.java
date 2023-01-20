package com.programmers.kakao2023.blind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test2 {

    static class House implements Comparable<House>{
        int index;
        int delivery;
        int pickup;

        public House(int index, int delivery, int pickup) {
            this.index = index;
            this.delivery = delivery;
            this.pickup = pickup;
        }

        @Override
        public String toString() {
            return "(i:" + index +
                    ", d:" + delivery +
                    ", p:" + pickup + ")";
        }

        @Override
        public int compareTo(House o) {
            return Integer.compare(o.index, index);
        }
    }

    static List<House> houseList;
    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        int delivery = 0;
        int pick = 0;

        for (int i = n - 1; i > 0; i--) {
            if (deliveries[i] != 0 || pickups[i] != 0) {
                int cnt = 0;
                while (delivery < deliveries[i] || pick < pickups[i]) {
                    cnt++;
                    delivery += cap;
                    pick += cap;

                }

                delivery -= deliveries[i];
                pick -= pickups[i];
                System.out.println("deliveries: " + deliveries[i] + ", pickups: "+ pickups[i]);
                System.out.println("delivery: " + delivery + ", pick: " + pick);

                answer += ((i + 1L) * cnt) * 2L;
            }
        }


//        houseList = new ArrayList<>();
//
//        for (int i = 0; i < n; i++) {
//            houseList.add(new House(i + 1, deliveries[i], pickups[i]));
//        }
//        Collections.sort(houseList);
//        System.out.println("init: "+ houseList);
//
//        int delivery = 0;
//        int pickup = 0;
//        for (House house : houseList) {
//            if (house.delivery > 0 && house.pickup > 0) {
//                int count = 0;
//                while (delivery < deliveries[house.index] || pickup < pickups[house.index]) {
//                    count ++;
//                    delivery += cap;
//                    pickup += cap;
//                }
//                delivery -= deliveries[house.index];
//                pickup -= deliveries[house.index];
//                answer += house.index * count * 2;
//            }
//        }


        return answer;
    }
}
