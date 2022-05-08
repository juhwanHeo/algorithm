package com.programmers.kakao2019.winter;

import java.util.HashSet;

/*
 * @2019 kakao winter internship
 * @TestName: 불량 사용자
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/64064
 * @COMMENT: https://daehun93.github.io/%EC%88%9C%EC%97%B4-%EC%A1%B0%ED%95%A9-%EC%99%84%EB%B2%BD%EC%A0%95%EB%A6%AC/ 참고
 *           https://bcp0109.tistory.com/14#comment14639188 도 참고하기
 */
public class Test3 {
    static HashSet<HashSet<String>> hhs;
    static boolean[] visited;
    public static int solution(String[] user_id, String[] banned_id) {
        hhs = new HashSet<>();
        visited = new boolean [user_id.length];
        perm(user_id, banned_id, new HashSet<>(), 0);
        return hhs.size();
    }

    static void perm(String[] user_id, String[] banned_id, HashSet<String> hs, int depth) {
        if(depth == banned_id.length){
            hhs.add(new HashSet<>(hs));
            return ;
        }

        for(int i = 0; i< user_id.length; i ++) {
            if(visited[i]) continue;
            if(banned_id[depth].length() != user_id[i].length()) continue;
            if(isBan(user_id[i], banned_id[depth])) {
                hs.add(user_id[i]);
                visited[i] = true;
                perm(user_id, banned_id, hs, depth + 1);
                hs.remove(user_id[i]);
                visited[i] = false;
            }
        }
    }

    static boolean isBan(String user, String ban) {
        if(user.length() != ban.length()) return false;
        for (int i = 0; i < user.length(); i++) {
            if(ban.charAt(i ) == '*') continue;
            if(user.charAt(i) != ban.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] user_id1 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] ban_id1 = {"fr*d*", "abc1**"};
        int answer1 = 2;
        int res1 = solution(user_id1, ban_id1);

        String[] user_id2 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] ban_id2 = {"*rodo", "*rodo", "******"};
        int answer2 = 2;
        int res2 = solution(user_id2, ban_id2);
//        int res2 = -1;

        String[] user_id3 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] ban_id3 = {"fr*d*", "*rodo", "******", "******"};
        int answer3 = 3;
        int res3 = solution(user_id3, ban_id3);
//        int res3 = -1;

        System.out.println("answer1 my: "+ res1);
        System.out.println("answer1 answer: " + answer1);
        System.out.println("answer1 equals: " + (res1 == answer1));
        System.out.println("------------------\n");

        System.out.println("answer2 my: "+ res2);
        System.out.println("answer2 answer: " + answer2);
        System.out.println("answer2 equals: " + (res2 == answer2));
        System.out.println("------------------\n");

        System.out.println("answer3 my: "+ res3);
        System.out.println("answer3 answer: " + answer3);
        System.out.println("answer3 equals: " + (res3 == answer3));
        System.out.println("------------------\n");
    }
}

