package com.coding.kakak2018.blind;

import java.util.*;

/*
 * @2018 kakao blind recruitment
 * @TestName: [1차] 캐시
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/17680
 */

// https://bcp0109.tistory.com/296
class LRUCache extends LinkedHashMap<String, Integer> {
    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(String key) {
        int time = super.getOrDefault(key, 0);
        super.put(key, 1);
        return time == 0 ? 5 : 1;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > capacity;
    }
}
public class Test4 {

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LRUCache cache = new LRUCache(cacheSize);
        for (String city : cities) answer += cache.get(city.toUpperCase());
        return answer;
    }

    public static void main(String[] args) {
        int cacheSize1 = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        int res = 50;
        int myRes = solution(cacheSize1, cities);
        System.out.println("myRes:" + myRes);

    }
}
