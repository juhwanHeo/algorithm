package com.coding.level1;


import java.util.*;

public class NotWanju {
    public static String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < completion.length; i++) {
            if(!participant[i].equals(completion[i])) return participant[i];
        }

        return participant[participant.length -1];
    }
    public static void main(String[] args) {
        String[] participant1 = {"leo", "kiki", "eden"};
        String[] completion1 = {"eden", "kiki"};
        String return1 = "leo";

        String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
        String return2 = "vinko";

        String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
        String[] completion3 = {"stanko", "ana", "mislav"};
        String return3 = "mislav";

        String myRes1 = solution(participant1, completion1);
//        String myRes2 = solution(answer2);

        System.out.println("myRes1: " + myRes1);
//        System.out.println("myRes2: " + Arrays.toString(myRes2));
    }

}
