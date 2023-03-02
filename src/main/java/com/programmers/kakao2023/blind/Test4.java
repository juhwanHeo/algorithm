package com.programmers.kakao2023.blind;

/*
 * @2023 KAKAO BLIND RECRUITMENT
 * @TestName: 표현 가능한 이진트리
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/150367
 * @COMMENT: binary Search 하듯이 dfs 진행
 */
public class Test4 {

    static boolean isOk;
    static boolean[] visited;
    public static int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            StringBuilder binary = new StringBuilder(Long.toBinaryString(numbers[i]));
            int len = binary.length(), level = 0;

            // Tree level 찾기
            while (len != 0) {
                len >>= 1;
                level++;
            }

            System.out.println("level = " + level);

            // 포화 이진트리 만들기
            while (binary.length() != Math.pow(2, level) - 1) {
                binary.insert(0, "0");
            }

            isOk = true;
            visited = new boolean[binary.length() + 1];
            dfs(1, binary.length(), '1', binary.toString());

            answer[i] = isOk ? 1 : 0;
        }

        return answer;
    }

    /* L --> D --> R */
    static void dfs(int start, int end, char before, String binary) {
        int mid = (start + end) / 2;
        if (visited[mid] || mid == 0) return;
        char current = binary.charAt(mid - 1);

        // L
        dfs(start, mid - 1, current, binary);

        // D
        visited[mid] = true;
        if (before == '0' && current == '1') {
            isOk = false;
            return;
        }

        // R
        dfs(mid + 1, end, current, binary);
    }

    // [0, 1, 2, 3, 4, 5, 6, 7]
    /* L --> D --> R */
    static void dfs2(int start, int end, char before, String binary) {
        int mid = (start + end) / 2;
        if (visited[mid]) return;
        visited[mid] = true;
        char current = binary.charAt(mid);
        // L
        dfs2(start, mid - 1, current, binary);

        // D
        if (before == '0' && current == '1') {
            isOk = false;
            return;
        }

        // R
        dfs2(mid + 1, end, current, binary);
    }
}
