package com.programmers.kakao2020.internship;

import java.util.Arrays;

/*
 * @2020 kakao internship
 * @TestName: 키패드 누르기
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/67256
 */
class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private void changeVal(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void move(int num) {
        switch (num) {
            case 1: changeVal(0, 0); break;
            case 2: changeVal(1, 0); break;
            case 3: changeVal(2, 0); break;
            case 4: changeVal(0, 1); break;
            case 5: changeVal(1, 1); break;
            case 6: changeVal(2, 1); break;
            case 7: changeVal(0, 2); break;
            case 8: changeVal(1, 2); break;
            case 9: changeVal(2, 2); break;
            case 0: changeVal(1, 3); break;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Test1 {
    static int[] leftNum = {1, 4, 7};
    static int[] rightNum = {3, 6, 9};

    public static String solution(int[] numbers, String hand) {
        String answer = "";
        Point leftHand = new Point(0,3);
        Point rightHand = new Point(2,3);
        Point curPoint = new Point(-1,-1);
        // 1, 4, 7 = L
        // 3, 6, 9 = R
        // 2, 5, 8, 0 = middle
        for(int num : numbers) {
            if(Arrays.stream(leftNum).anyMatch(value -> value == num)) {
                leftHand.move(num);
                answer += "L";
            }
            else if(Arrays.stream(rightNum).anyMatch(value -> value == num)) {
                rightHand.move(num);
                answer +="R";
            }
            else {
                curPoint.move(num);
                int leftDist = getDist(leftHand, curPoint);
                int rightDist = getDist(rightHand, curPoint);
                if(leftDist < rightDist) {
                    leftHand.move(num);
                    answer += "L";
                }
                else if(leftDist == rightDist) {
                    if(hand.equals("left")) {
                        leftHand.move(num);
                        answer += "L";
                    } else {
                        rightHand.move(num);
                        answer +="R";
                    }

                } else {
                    rightHand.move(num);
                    answer +="R";
                }
            }

        }
        return answer;
    }

    private static int getDist(Point p1, Point p2) {
        return Math.abs(p1.getX()- p2.getX()) + Math.abs(p1.getY() - p2.getY());
    }

    public static void main(String[] args) {
        int[] numbers1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        int[] numbers2 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        int[] numbers3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        String hand1 = "right";
        String hand2 = "left";
        String hand3 = "right";

        String myRes1 = solution(numbers1, hand1);
        String myRes2 = solution(numbers2, hand2);
        String myRes3 = solution(numbers3, hand3);
        String res1 = "LRLLLRLLRRL";
        String res2 = "LRLLRRLLLRR";
        String res3 = "LLRLLRLLRL";


        System.out.println("numbers1: " + Arrays.toString(numbers1));
        System.out.println("answer1 my: "+ myRes1);
        System.out.println("answer1 my: "+ myRes1.length());
        System.out.println("answer1 answer: " + res1);
        System.out.println("answer1 answer: " + res1.length());
        System.out.println("answer1 equals: " + myRes1.equals(res1));
        System.out.println("------------------\n");

        System.out.println("answer2 my: "+ myRes2);
        System.out.println("answer2 answer: " + res2);
        System.out.println("answer2 equals: " + myRes2.equals(res2));
        System.out.println("------------------\n");

        System.out.println("answer3 my: "+ myRes3);
        System.out.println("answer3 answer: " + res3);
        System.out.println("answer3 equals: " + myRes3.equals(res3));
        System.out.println("------------------\n");

    }
}

