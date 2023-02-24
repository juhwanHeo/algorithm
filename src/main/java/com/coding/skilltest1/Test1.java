package com.coding.skilltest1;

public class Test1 {
    static String solution(String[] seoul) {
        StringBuilder answer = new StringBuilder("김서방은 ");
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                answer.append(i);
            }
        }
        return answer.append("에 있다").toString();
    }
    public static void main(String[] args) {

        String[] s = {
                "Jane", "Kim"
        };
        System.out.println("solution(s) = " + solution(s));

    }
}
