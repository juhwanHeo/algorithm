package com.study.test;

public class Sum {

    public static long sum(long start, long end) {
        int result = 0;
        for (long i = start; i <= end; i++) {
            result += i;
        }
        return result;
    }

    public static long sum(long start, long end, int depth) {
        if (start == end) return start;
        long mid = (start + end) / 2;
        return sum(start, mid, depth + 1) + sum(mid + 1, end, depth + 1);
    }

}

