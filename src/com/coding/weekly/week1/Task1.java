package com.coding.weekly.week1;

/*
-- 코드를 입력하세요
SELECT
    ANIMAL_ID
FROM
    ANIMAL_INS
WHERE 1=1
    AND NVL(NAME, 'NULL') = 'NULL'
ORDER BY 1 DESC;
*/

public class Task1 {
    public static long solution(int price, int money, int count) {
        long answer = 0;
        for (int i = 0; i < count; i++) {
            answer += (long) price * (i + 1);
        }

        if(money - answer > 0) return 0;
        else return Math.abs(money - answer);
    }

    public static void main(String[] args) {
        int price = 3;
        int money = 20;
        int count = 4;
        int res = 10;

        long myRes = solution(price, money, count);
        long myRes2 = solution(100, 1600, 5);
        System.out.println("res: " + res);
        System.out.println("myRes: " + myRes);
    }
}
