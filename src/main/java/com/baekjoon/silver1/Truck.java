package com.baekjoon.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * @Silver1
 * @TestName: 트럭
 * @URL: https://www.acmicpc.net/problem/13335
 */
public class Truck {

    static class Car {
        int weight;

        int time = 0;

        public Car(int weight) {
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

        public Car(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }

        @Override
        public String toString() {
            return "time: " + time + ", weight: " + weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(stk.nextToken());
        int w = Integer.parseInt(stk.nextToken());
        int L = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine(), " ");
        int[] truckWeight = new int[n];
        for (int i = 0; i < n; i++) {
            truckWeight[i] = Integer.parseInt(stk.nextToken());
        }


        System.out.println(solution(w, L, truckWeight));

    }

    private static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Car> wait = new LinkedList<>();
        Queue<Car> bridge = new LinkedList<>();
        int time = 0;

        for (int truckWeight : truck_weights) wait.offer(new Car(truckWeight));

        while (!wait.isEmpty() || !bridge.isEmpty()) {
            bridge.forEach(Car::timeIncrease);

            if (!bridge.isEmpty()) {
                Car truck = bridge.peek();
                if (truck.getTime() == bridge_length) bridge.poll();
            }

            int currentWeight = bridge.isEmpty() ? 0 : bridge.stream()
                    .map(Car::getWeight)
                    .mapToInt(Integer::intValue)
                    .sum();

            int waitWeight = wait.isEmpty() ? 0 : wait.peek().getWeight();

            if (!wait.isEmpty() && currentWeight + waitWeight <= weight)
                bridge.offer(wait.poll());

            time++;
        }

        return time;
    }
}

