package com.programmers.level1;

import java.util.Comparator;

/*
 * @level1
 * @TestName: 정수 내림차순으로 배치하기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12933
 */
public class IntDesc {
    static long solution(long n) {
//        String[] res = Arrays.stream(String.valueOf(n).split(""))
//                .mapToInt(Integer::parseInt)
//                .boxed()
//                .sorted(Comparator.reverseOrder())
//                .map(String::valueOf)
//                .toArray(String[]::new);

        StringBuilder sb = new StringBuilder();
        Long.toString(n).chars()
                .boxed()
                .sorted(Comparator.reverseOrder())
                .map(c-> (char) c.intValue())
                .forEach(sb::append);
//        for (String str : res) sb.append(str);

        return Long.parseLong(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(solution(118372));
    }
}
