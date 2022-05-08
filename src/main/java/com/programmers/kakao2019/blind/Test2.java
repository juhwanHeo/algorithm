package com.programmers.kakao2019.blind;

import java.util.*;

/*
 * @2019 kakao blind recruitment
 * @TestName: 오픈채팅방
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/42888
 */
public class Test2 {
    public static String[] solution(String[] records) {
        List<String> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        for (String record : records) {
            String[] split = record.split(" ");
            String cmd = split[0];
            String id = split[1];
            if (split.length > 2) map.put(id, split[2]);
            else list.add(id + "님이 나갔습니다.");
            if (cmd.charAt(0) == 'E') list.add(id + "님이 들어왔습니다.");
        }

        /*
        * replaceAll하면 테케 절반 이상 실패
        * 이유를 모르겟음
        */
//        for (String key : map.keySet()) {
//            list.replaceAll(str -> str.replace(key, map.get(key)));
//        }

        for (int i = 0; i < list.size(); i++) {
            int endOfId = list.get(i).indexOf("님");
            String id = list.get(i).substring(0, endOfId);
            list.set(i, list.get(i).replace(id, map.get(id)));
        }

        return list.stream()
                .map(String::valueOf)
                .toArray(String[]::new);
    }

    public static void main(String[] args) {
       String[] record = {
               "Enter uid1234 Muzi",
               "Enter uid4567 Prodo",
               "Leave uid1234",
               "Enter uid1234 Prodo",
               "Change uid4567 Ryan"
//               "Enter uid0606 Gimoi",
//               "Enter uid4567 Prodo",
//               "Leave uid0606",
//               "Enter uid1234 Prodo",
//               "Change uid1234 OhYeah"
       };
        String[] record2 = {
               "Enter uid0606 Gimoi",
               "Enter uid4567 Prodo",
               "Leave uid0606",
               "Enter uid1234 Prodo",
               "Change uid1234 OhYeah"
        };
       String[] res = {
               "Prodo님이 들어왔습니다.",
               "Ryan님이 들어왔습니다.",
               "Prodo님이 나갔습니다.",
               "Prodo님이 들어왔습니다."
       };

       String[] myRes1 = solution(record);
       String[] myRes2 = solution(record2);
       System.out.println("myRes1: " + Arrays.toString(myRes1));
       System.out.println("myRes2: " + Arrays.toString(myRes2));
//       System.out.println("myRes1: " + Arrays.equals(myRes1, res));

    }
}

