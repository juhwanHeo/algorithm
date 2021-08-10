package com.coding.level2;

/*
 * @level2
 * @TestName: 타겟 넘버
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/72412
 */
public class TargetNumber {
    public static int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    static int dfs(int[] numbers, int target, int sum, int depth) {
        int res = 0;
        if(numbers.length == depth) {
            if (sum == target) return 1;
            return 0;
        }
        res += dfs(numbers, target, sum + numbers[depth],depth + 1);
        res += dfs(numbers, target, sum - numbers[depth],depth + 1);
        return res;
    }

    public static void main(String[] args) {
        int[] numbers1 = {1, 1, 1, 1, 1};
        int target1 = 3;
        int return1 = 5;
        int myRes = solution(numbers1, target1);
        System.out.println(myRes);
        System.out.println(myRes == return1);

    }
}
