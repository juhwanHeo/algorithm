package com.coding.level1;

/*
 * @level1
 * @TestName: 정수 제곱근 판별
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/12934
 */
public class IntSqrt {
    public static long solution(long n) {
        double data = Math.sqrt(n);

//        if (data - (int) data == 0)
//            return (long) (Math.pow(data + 1, 2));
        // 정수 판별 방법 추가
        System.out.println("is Long? " + (data % 1 == 0));
        if (data % 1 == 0)
            return (long) (Math.pow(data + 1, 2));
        return -1;
    }

    public static void main(String[] args) {

        System.out.println(solution(121));
        System.out.println(solution(3));
    }
}
