package com.programmers.kakao2023.blind;

public class Test6 {

    static class Direction {
        int d, l, r, u;
    }

    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        StringBuilder answer = new StringBuilder();
        Direction direction = new Direction();
        int dist = distance(x, y ,r ,c);
        k -= dist;
        if (k < 0 || k % 2 != 0) return "impossible";

        if (x > r) direction.u += x - r;
        else direction.d += r - x;

        if (y > c) direction.l += y - c;
        else direction.r = c - y;

        for (int i = 0; i < direction.d; i++) answer.append("d");

        int d = Math.min(k / 2, n - (x + direction.d));
        for (int i = 0; i < d; i++) answer.append("d");
        direction.u += d;
        k -= 2 * d;

        for (int i = 0; i < direction.l; i++) answer.append("l");
        int l = Math.min(k / 2, y - direction.l - 1);
        for (int i = 0; i < l; i++) answer.append("l");
        direction.r += l;
        k -= 2 * l;

        for (int i = 0; i < k / 2; i++) answer.append("rl");
        for (int i = 0; i < direction.r; i++) answer.append("r");
        for (int i = 0; i < direction.u; i++) answer.append("u");
        return answer.toString();
    }

    static int distance(int x, int y, int r, int c) {
        return Math.abs(x - r) + Math.abs(y - c);
    }
}
