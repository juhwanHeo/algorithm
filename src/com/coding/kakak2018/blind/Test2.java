package com.coding.kakak2018.blind;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * @2018 kakao blind recruitment
 * @TestName: [1차] 다트 게임
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/17682
 */
public class Test2 {
    public static int solution(String dartResult) {
        Pattern pattern = Pattern.compile("([0-9]+)([SDT])([*#]?)");
        Matcher matcher = pattern.matcher(dartResult);
        Stack<Integer> stack = new Stack<>();

        while(matcher.find()){
            int val = Integer.parseInt(matcher.group(1));
            String sdt = matcher.group(2);
            String option = matcher.group(3);

            if (sdt.equals("D")) val = (int) Math.pow(val, 2);
            else if(sdt.equals("T")) val = (int) Math.pow(val, 3);
            if(option.equals("*")){
                if(!stack.isEmpty()) stack.push(stack.pop() * 2);
                val *= 2;
            }
            else if (option.equals("#")) val *= -1;
            stack.push(val);
        }

        return stack.stream()
                .mapToInt(Integer::valueOf)
                .sum();
    }

    public static void main(String[] args) {
        //1^1 * 2 + 2^2 * 2 + 3^3
        String dart1 = "1S2D*3T";
        int answer1 = 37;
        int myAnswer1 = solution(dart1);
        System.out.println("myRes1: " + myAnswer1);

    }
}
