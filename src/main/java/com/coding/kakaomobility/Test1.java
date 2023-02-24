package com.coding.kakaomobility;

import java.util.HashMap;
import java.util.Map;

public class Test1 {

    public static String solution(String S, String C) {
        StringBuilder sb = new StringBuilder();
        String[] split = S.split(", ");
        Map<String, Integer> map = new HashMap<>();

        int idx = 1;
        for (String str : split) {
            String[] strSplit = str.split(" ");

            StringBuilder email = new StringBuilder();
            email.append("<");
            String first = strSplit[0];
            if (strSplit.length == 2) {
                String last = strSplit[1];

                email.append(first.charAt(0)).append(last);
            }
            else {
                String middle = strSplit[1];
                String last = strSplit[2];

                email.append(first.charAt(0)).append(middle.charAt(0));
                if (last.length() > 8) email.append(last.replaceAll("-", ""), 0, 8);
                else email.append(last.replaceAll("-", ""));

            }
            map.put(email.toString(), map.getOrDefault(email.toString(), 0) + 1);

            int cnt = map.get(email.toString());
            if (cnt >= 2) email.append(cnt);
            email.append("@").append(C)
                    .append(".com")
                    .append(">");

            sb.append(str).append(" ")
                .append(email.toString().toLowerCase());

            if (idx++ != split.length) sb.append(", ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String S = "John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker";
        String C = "Example";
        System.out.println("solution(S, C) = \n" + solution(S, C));

        String result = "John Doe <jdoe@example.com>, Peter Parker <pparker@example.com>, Mary Jane Watson-Parker <mjwatsonpa@example.com>, James Doe <jdoe2@example.com>, John Elvis Doe <jedoe@example.com>, Jane Doe <jdoe3@example.com>, Penny Parker <pparker2@example.com>";
        System.out.println("result = \n" + result);
        System.out.println(solution(S, C).equals(result));
        /*
         */
    }
}
