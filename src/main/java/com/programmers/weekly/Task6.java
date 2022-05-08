package com.programmers.weekly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Weekly 6
 * @TestName: 복서 정렬하기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/85002
 */
public class Task6 {
    static class People implements Comparable<People>{
        int id;
        int weight;
        double rate;
        int heavyWinCnt;

        public People(int id, int weight, double rate, int heavyWinCnt) {
            this.id = id;
            this.weight = weight;
            this.rate = rate;
            this.heavyWinCnt = heavyWinCnt;
        }

        @Override
        public String toString() {
            return "People{" +
                    "id=" + id +
                    ", weight=" + weight +
                    ", rate=" + rate +
                    ", heavyWinCnt=" + heavyWinCnt +
                    '}';
        }

        @Override
        public int compareTo(People people) {
            if (rate != people.rate)
                return Double.compare(people.rate, rate);
            if (heavyWinCnt != people.heavyWinCnt)
                return Integer.compare(people.heavyWinCnt, heavyWinCnt);
            if (weight != people.weight)
                return Integer.compare(people.weight, weight);
            return Integer.compare(id, people.id);
        }

        public int getId() {
            return id;
        }
    }
    public static int[] solution(int[] weights, String[] head2head) {
        List<People> list = new ArrayList<>();
        for (int i = 0; i < weights.length; i++) {
            long winCnt = head2head[i].chars().filter(c -> c == 'W').count();
            long lossCnt = head2head[i].chars().filter(c -> c == 'L').count();
            int heavyWinCnt = 0;
            double rate = getRate(winCnt, lossCnt);
            for (int k = 0; k < weights.length; k++) {
                if (i == k) continue;
                if (head2head[i].charAt(k) == 'W' && weights[i] < weights[k])
                    heavyWinCnt++;
            }

            list.add(new People(i + 1, weights[i], rate, heavyWinCnt));
        }

        return list.stream()
                .sorted()
                .mapToInt(People::getId)
                .toArray();
    }

    private static double getRate(long winCnt, long lossCnt) {
        if (winCnt == 0 && lossCnt == 0) return 0;
        return ((double) winCnt / (winCnt + lossCnt)) * 100;
    }

    public static void main(String[] args) {

        int[] weights1 = {
//                50,82,75,120
                60,70,60
        };
        String[] head2head1 = {
                "NNN","NNN","NNN"
//                "NLWL",
//                "WNLL",
//                "LWNW",
//                "WWLN"
        };
//        int[] res1 = {3,4,1,2};

        System.out.println(Arrays.toString(solution(weights1,head2head1)));
    }
}
