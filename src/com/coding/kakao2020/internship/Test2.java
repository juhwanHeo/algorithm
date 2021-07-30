package com.coding.kakao2020.internship;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class Test2 {
    static String[][] op = {
            {"+", "-", "*"},
            {"+", "*", "-"},
            {"-", "+", "*"},
            {"-", "*", "+"},
            {"*", "+", "-"},
            {"*", "-", "+"}
    };

    public static long solution(String expression) {
        String[] longArr = expression.split("[^0-9]");
        List<Long> longList = new ArrayList<>();
        for (int i = 0; i < longArr.length; i++)
            longList.add(Long.parseLong(longArr[i]));

        String[] opsArr = expression.split("[0-9]+");
        List<String> opsList = new ArrayList<>();
        List<Long> resList = new ArrayList<>();
        for (int i = 1; i < opsArr.length; i++)
            opsList.add(opsArr[i]);

        for(String[] opers : op) {
            resList.add(calc(longList, opsList, opers));
        }

        return resList.stream()
                .mapToLong(Math::abs)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    public static long calc(List<Long> longLst, List<String> opsLst, String[] opers) {
        List<Long> longList = new ArrayList<>();
        List<String> opsList = new ArrayList<>();
        for(long val : longLst)
            longList.add(val);

        for(String str : opsLst)
            opsList.add(str);

        for(String ops : opers) {
            switch (ops) {
                case "+" :
                    while(opsList.contains("+")){
                        int opIndex = opsList.indexOf("+");
                        long res = longList.get(opIndex) + longList.get(opIndex+1);
                        longList.set(opIndex, res);
                        longList.remove(opIndex+1);
                        opsList.remove(opIndex);
                    }
                    break;
                case "-" :
                    while(opsList.contains("-")){
                        int opIndex = opsList.indexOf("-");
                        long res = longList.get(opIndex) - longList.get(opIndex+1);
                        longList.set(opIndex, res);
                        longList.remove(opIndex+1);
                        opsList.remove(opIndex);
                    }
                    break;
                case "*" :
                    while(opsList.contains("*")){
                        int opIndex = opsList.indexOf("*");
                        long res = longList.get(opIndex) * longList.get(opIndex+1);
                        longList.set(opIndex, res);
                        longList.remove(opIndex+1);
                        opsList.remove(opIndex);
                    }
                    break;
            }
        }
        return longList.get(0);
    }

    public static void main(String[] args) {

        String expression1 = "100-200*300-500+20";
        String expression2 = "50*6-3*2";

        long res1 = 60420;
        long res2 = 300;

        long myRes1 = solution(expression1);
        long myRes2 = solution(expression2);

        System.out.println("answer1 my: "+ myRes1);
        System.out.println("answer1 answer: "+ res2);
        System.out.println("answer1 expression1: " + expression1);
        System.out.println("answer1 equals: " + (myRes1 == res1));
        System.out.println("------------------\n");

        System.out.println("answer2 my: "+ myRes2);
        System.out.println("answer2 answer: " + res2);
        System.out.println("answer2 expression2: "+ expression2);
        System.out.println("answer2 equals: " + (myRes2 == res2));
        System.out.println("------------------\n");


    }
}

