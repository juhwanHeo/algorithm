package com.coding.kakaomobility;

import java.util.*;

public class Test2 {
    static Set<Integer> set;
    static int cnt = 0 ;

    public static int solution(int[] T, int[] A) {
        set = new HashSet<>();

        for (int val : A) {
            dfs(val, T);
        }

        System.out.println("set = " + set);
        return set.size();
    }

    public static void dfs(int index, int[] arr) {
        System.out.println(cnt++ + " index = " + index);
//        if (set.contains(index)) return;
        set.add(index);
        int next = arr[index];

        if (index == 0) return;
        dfs(next, arr);
    }


    public static void main(String[] args) {
        int[] T1 =  {
//          0, 0, 1, 1
                0,3,0,0,5,0,5
        };

        int[] A1 = {
//            2
                4,2,6,1,0 // 7

        };

        System.out.println("solution(T1, A1) = " + solution(T1, A1));

    }
}
