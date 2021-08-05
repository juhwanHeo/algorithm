package com.coding.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class gangyeokXwitN {
    static long[] solution222(int x, int n) {
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
        System.out.println(Arrays.toString(solution222(2, 5)));
    }
}
