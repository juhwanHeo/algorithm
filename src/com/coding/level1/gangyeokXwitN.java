package com.coding.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/*
 * @level1
 * @TestName: x만큼 간격이 있는 n개의 숫자
 * @URL:https://programmers.co.kr/learn/courses/30/lessons/12954
 */
public class gangyeokXwitN {
    static long[] solution(int x, int n) {
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(((long) x * (i+1)));
        }
        return list.stream()
                .filter(Objects::nonNull)
                .mapToLong(Long::longValue)
                .toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2, 5)));
    }
}
