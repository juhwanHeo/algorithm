package com.programmers.kakao2023.blind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @2023 kakao blind recruitment
 * @TestName: 이모티콘 할인행사
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/150368
 * @COMMENT: 순열
 */
public class Test3 {
    static List<List<Emoticon>> output;
    public static int[] solution(int[][] users, int[] emoticons) {
        output = new ArrayList<>();;

        /* 최소 최대 구하기 */
        int[] discounts = {10, 20, 30, 40};
        dfs(discounts, emoticons, new int[emoticons.length], 0, emoticons.length);
        List<int[]> result = new ArrayList<>();

        for (List<Emoticon> emoticonList : output) {
            int subscriber = 0;
            int sales = 0;
            for (int[] user : users) {
                int sum = 0;
                for (Emoticon emoticon : emoticonList) {
                    if (user[0] > emoticon.discount) continue;

                    sum += emoticon.price;
                }
                if (user[1] <= sum) subscriber++;
                else sales += sum;
            }
            result.add(new int[]{subscriber, sales});
        }

        result.sort((l1, l2) -> {
            if (l1[0] != l2[0]) return l2[0] - l1[0];
            return l2[1] - l1[1];
        });
        result.forEach(item -> System.out.println(Arrays.toString(item)));

        return result.get(0);
    }

    static class Emoticon {
        int discount, price;

        public Emoticon(int discount, int price) {
            this.discount = discount;
            this.price = price;
        }

        @Override
        public String toString() {
            return "(" + discount + ", " + price + ")";
        }
    }

    /* 중복 순열 */
    private static void dfs(int[] discounts, int[] emoticons, int[] out, int depth, int r) {
        if (depth == r) {
            List<Emoticon> result = new ArrayList<>();
            for (int i = 0; i < out.length; i++) {
                int price =  emoticons[i] - emoticons[i] / 100 * out[i];
                result.add(new Emoticon(out[i], price));
            }
            output.add(result);
            return;
        }

        for (int discount : discounts) {
            out[depth] = discount;
            dfs(discounts, emoticons, out, depth + 1, r);
        }
    }
}
