package com.coding.kakao2021.blind;


import java.util.*;

/*
* @2021 kakao blind recruitment
* @TestName: 순위 검색
* @URL: https://programmers.co.kr/learn/courses/30/lessons/72412
*/
class Person implements Comparable{
    String lang; /* 언어 */
    String jobGroup; /* 직군 */
    String career; /* 경력 */
    String soulFood; /* 소울푸드 */
    int score; /* 점수 */

    public Person(String lang, String jobGroup, String career, String soulFood, int score) {
        this.lang = lang;
        this.jobGroup = jobGroup;
        this.career = career;
        this.soulFood = soulFood;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lang='" + lang + '\'' +
                ", career='" + career + '\'' +
                ", jobGroup='" + jobGroup + '\'' +
                ", soulFood='" + soulFood + '\'' +
                ", score=" + score +
                "} \n";
    }


    @Override
    public int compareTo(Object o) {
        Person person = (Person) o;
        if(this.score >= person.score) {
            if (this.lang.equals(person.lang) || person.lang.equals("-")) {
                if (this.career.equals(person.career) || person.career.equals("-")) {
                    if (this.jobGroup.equals(person.jobGroup) || person.jobGroup.equals("-")) {
                        if (this.soulFood.equals(person.soulFood) || person.soulFood.equals("-"))
                            return 1;
                    }
                }
            }
        }
        return 0;
    }
}

public class Test3NotEfficiency {
    public static int[] solution(String[] info, String[] query) {
        List<Integer> answer = new ArrayList<>();
        List<Person> infoList = new ArrayList<>();
        for (String str : info) {
            String[] data = str.split(" ");
            infoList.add(new Person(data[0], data[1], data[2], data[3], Integer.parseInt(data[4])));
        }
        System.out.println("info: " + infoList);
        for(String str : query) {
            String[] data = str.split(" ");
            Person person = new Person(data[0], data[2], data[4], data[6], Integer.parseInt(data[7]));
            System.out.println("query: " + person);
            int dad = 0;
            for(Person pInfo : infoList) {
                if(pInfo.compareTo(person) > 0) dad++;
            }
            answer.add(dad);
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }


    public static void main(String[] args) {
        String[] info1 = {
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
        };
        String[] query2 = {
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"
        };
        int[] myRes1 = solution(info1, query2);
        System.out.println("myRes1: " + Arrays.toString(myRes1));

    }
}

