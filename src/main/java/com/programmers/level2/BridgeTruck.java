package com.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

/*
 * @level2
 * @TestName: 다리를 지나는 트럭
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/42583
 */
public class BridgeTruck {

    static class Truck {
        int weight;
        int time = 0;

        public Truck(int weight) {
            this.weight = weight;
        }

        public int getWeight() {
            return this.weight;
        }

        public int getTime() {
            return this.time;
        }

        public void timeIncrease() {
            this.time++;
        }

        @Override
        public String toString() {
            return "time: " + time + ", weight: " +  weight;
        }
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Truck> wait = new LinkedList<>();
        Queue<Truck> bridge = new LinkedList<>();

        for (int truckWeight : truck_weights) {
            wait.offer(new Truck(truckWeight));
        }

        int time = 0;
        while(!wait.isEmpty() || !bridge.isEmpty()) {

            bridge.forEach(Truck::timeIncrease);

            if(! bridge.isEmpty()) {
              Truck truck = bridge.peek();
              if (truck.getTime() == bridge_length) bridge.poll();
            }

            int currentWeight = bridge.isEmpty() ? 0 : bridge.stream()
                    .map(Truck::getWeight)
                    .mapToInt(Integer::intValue)
                    .sum();
            int waitWeight = wait.isEmpty() ? 0 : wait.peek().getWeight();

            if (currentWeight + waitWeight <= weight && !wait.isEmpty())
                bridge.offer(wait.poll());

            answer++;
            System.out.println(time + " bridge = " + bridge);
            System.out.println("currentWeight = " + currentWeight);
            System.out.println("waitWeight = " + waitWeight);
        }

        return answer;
    }

    public static void main(String[] args) {
        int length1 = 2;
        int weight1 = 10;
        int length2 = 5;
        int weight2 = 5;
        int[] truckWeight = {
//                7, 4, 5, 6 // 8
                2, 2, 2, 2, 1, 1, 1, 1, 1 // 19
        };

//        System.out.println("solution() = " + solution(length1, weight1, truckWeight));
        System.out.println("solution() = " + solution(length2, weight2, truckWeight));
    }
}
