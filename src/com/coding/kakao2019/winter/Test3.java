package com.coding.kakao2019.winter;

import java.util.*;

public class Test3 {

    public static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        HashSet<String> set = new HashSet<>();

        for(String ban : banned_id) {
            for (String user : user_id) {
                if(isBan(user, ban)) set.add(user) ;

            }

            System.out.println("set: " + set);
        }

        System.out.println("====================\n");
        return answer;
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

        String[] user_id3 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] ban_id3 = {"fr*d*", "*rodo", "******", "******"};
        int answer3 = 3;
        int res3 = solution(user_id3, ban_id3);

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

