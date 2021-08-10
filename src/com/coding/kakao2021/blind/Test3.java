package com.coding.kakao2021.blind;

import java.util.*;

/*
* @2021 kakao blind recruitment
* @TestName: 순위 검색
* @URL: https://programmers.co.kr/learn/courses/30/lessons/72412
* @COMMENT: 효율성 검사에서 통과하지 못하여 https://girawhale.tistory.com/94 참고
*/
public class Test3 {
    static boolean[] visited;
    public static int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (String in : info) {
            Set<String> hs = new HashSet<>();
            visited = new boolean[4];

            String[] split = in.split(" ");
            int score = Integer.parseInt(split[4]);

            // 조합
            for(int i = 0; i <= 4; i ++) {
                comb(split, hs, 0, 4, i);
            }
            hs.forEach(key -> {
                map.computeIfAbsent(key, s -> new ArrayList<>()).add(score);
            });
        }

        for (Map.Entry<String, List<Integer>> entry : map.entrySet())
            entry.getValue().sort(null);

        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            // '-' 제외
            String[] split = query[i].replaceAll("-", "").split(" and | ");
            String key = String.join("", split[0], split[1], split[2], split[3]);
            int score = Integer.parseInt(split[4]);
            List<Integer> list = map.getOrDefault(key, new ArrayList<>());

            // 이진탐색
            // 점수 아래인 사람 찾기
            int low = 0, high = list.size();
            while (low < high) {
                int mid = (low + high) / 2;
                if (list.get(mid) < score) low = mid + 1;
                else high = mid;
            }
            answer[i] = list.size() - low;
        }
        return answer;
    }

    static String getComb(String[] arr, int n) {
        String str = "";
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                str += arr[i];
            }
        }

        return str;
    }

    static void comb(String[] arr,Set<String> hs, int depth, int n, int r) {
        if(r == 0) {
            hs.add(getComb(arr, n));
            return;
        }
        if(depth == n) return;

        visited[depth] = true;
        comb(arr, hs,depth + 1, n,r - 1);

        visited[depth] = false;
        comb(arr, hs,depth + 1, n, r);
    }

    public static void main(String[] args) {
        String[] info1 = {
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
        };
        String[] query2 = {
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"
        };
        int[] myRes1 = solution(info1, query2);
        System.out.println("myRes1: " + Arrays.toString(myRes1));

    }
}

