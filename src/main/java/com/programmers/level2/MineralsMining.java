package com.programmers.level2;

import java.util.Arrays;
import java.util.List;

/*
 * @level2
 * @TestName: 광물 캐기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/172927
 */
public class MineralsMining {

    static final int DIAMOND_AXE = 0;
    static final int IRON_AXE = 1;
    static final int STONE_AXE = 2;
    static int answer;
    public static int solution(int[] picks, String[] minerals) {
        answer = Integer.MAX_VALUE;
        System.out.println(Arrays.toString(minerals));
        List<String> list = Arrays.asList(minerals);

        dfs(list, picks[0], picks[1], picks[2], DIAMOND_AXE, 0);
        dfs(list, picks[0], picks[1], picks[2], IRON_AXE, 0);
        dfs(list, picks[0], picks[1], picks[2], STONE_AXE, 0);
        return answer;
    }

    static void dfs(List<String> minerals, int dia, int iron, int stone, int type, int sum) {
        if (dia == 0 && iron == 0 && stone == 0) {
            System.out.println("sum = " + sum);
            answer = Math.min(sum, answer);
            return;
        }
        if (type == DIAMOND_AXE && dia == 0) return;
        if (type == IRON_AXE && iron == 0) return;
        if (type == STONE_AXE && stone == 0) return;

        int result = 0;
        int minIndex = Math.min(5, minerals.size());
        List<String> split = minerals.subList(0, minIndex);
        List<String> next = minerals.subList(minIndex, minerals.size());
        for (int i = 0; i < split.size(); i++) {
            String mineral = minerals.get(i);
            result += calc(type, mineral);
        }

        switch (type) {
            case DIAMOND_AXE: dia -= 1; break;
            case IRON_AXE: iron -= 1; break;
            case STONE_AXE: stone -= 1; break;
        }

        System.out.println("type: " + type + ", result = " + result);
        dfs(next, dia, iron, stone, DIAMOND_AXE, sum + result);
        dfs(next, dia, iron, stone, IRON_AXE, sum + result);
        dfs(next, dia, iron, stone, STONE_AXE, sum + result);
    }

    private static int calc(int type, String mineral) {
        int result = 1;
        if (type == IRON_AXE) {
            switch (mineral) {
                case "diamond": result = 5; break;
                case "iron":
                case "stone": break;
            }
        }
        else if (type == STONE_AXE) {
            switch (mineral) {
                case "diamond": result = 25; break;
                case "iron": result = 5; break;
                case "stone": break;
            }
        }

        return result;
    }

}
