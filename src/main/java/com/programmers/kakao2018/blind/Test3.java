package com.programmers.kakao2018.blind;

import java.util.ArrayList;
import java.util.List;

/*
 * @2018 kakao blind recruitment
 * @TestName: [1차] 뉴스 클러스터링
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/17677
 */
public class Test3 {
    public static int solution(String str1, String str2) {
        String regex = "^[a-zA-Z]*$";
        List<String> strList1 = new ArrayList<>();
        List<String> strList2 = new ArrayList<>();

        for (int i = 0; i < str1.length()-1; i++) {
            String str = str1.substring(i, i+2);
            if(str.matches(regex)) strList1.add(str.toUpperCase());
        }

        for (int i = 0; i < str2.length()-1; i++) {
            String str = str2.substring(i, i+2);
            if(str.matches(regex)) strList2.add(str.toUpperCase());
        }

        return jaCard(strList1, strList2);
    }

    private static int jaCard(List<String> strList1, List<String> strList2) {
        if (strList1.size() == 0 && strList2.size() == 0) return 65536;
        List<String> union = getUnion(strList1, strList2);
        List<String> intersection = getIntersection(strList1, strList2);

        System.out.println("union: " + union);
        System.out.println("intersection: " + intersection);

        double val1 = intersection.size();
        double val2 = union.size();
        return (int) (val1 / val2 * 65536);
    }

    private static List<String> getUnion(List<String> strList1, List<String> strList2) {
        List<String> list1 = new ArrayList<>(strList1);
        List<String> list2 = new ArrayList<>(strList2);
        List<String> unionList = new ArrayList<>();

        for (String str : list1) {
            list2.remove(str);
            unionList.add(str);
        }

        unionList.addAll(list2);
        return unionList;
    }

    private static List<String> getIntersection(List<String> strList1, List<String> strList2) {
        List<String> list1 = new ArrayList<>(strList1);
        List<String> list2 = new ArrayList<>(strList2);
        List<String> intersectionList = new ArrayList<>();

        for (String str : list1) {
            if (list2.contains(str)) {
                intersectionList.add(str);
                list2.remove(str);
            }
        }

        return intersectionList;
    }

    public static void main(String[] args) {
        // {FR, RA, AN, NC, CE}
        String str11 = "FRANCE";
        String str12 = "french";
        int answer1 = 16384;


        String str21 = "handshake";
        String str22 = "shake hands";
        int answer2 = 65536;

        String str31 = "aa1+aa2";
        String str32 = "AAAA12";
        int answer3 = 43690;


        int myAnswer1 = solution(str11, str12);
        System.out.println("-------------------\n\n\n");
        int myAnswer2 = solution(str21, str22);
        System.out.println("-------------------\n\n\n");
        int myAnswer3 = solution(str31, str32);
        System.out.println("myRes1: " + myAnswer1);
        System.out.println("myRes2: " + myAnswer2);
        System.out.println("myRes3: " + myAnswer3);



    }
}
