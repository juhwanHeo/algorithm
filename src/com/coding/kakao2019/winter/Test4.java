package com.coding.kakao2019.winter;

import java.util.*;

/*
 * @2019 kakao winter internship
 * @TestName: 호텔 방 배정
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/64063
 * @COMMENT: 정확성은 해결 했지만 효율성 해결이 안되서
 *           https://bcp0109.tistory.com/188?category=885291 참고
 */
public class Test4 {
//    static long[] room;
//    static long[] memory;
//    static int memoryIndex;
    static Map<Long, Long> map;

    public static long[] solution(long k, long[] room_number) {
        map = new HashMap<>();
        List<Long> answer = new ArrayList<>();

        for (long num : room_number) {
            System.out.println("for num: " + num);
            answer.add(roomCheck(num));
            System.out.println(map);

        }

        // stream 연습 중
//        return Arrays.stream(room_number)
//                .map(Test4::roomCheck)
//                .toArray();
        return answer.stream()
                .filter(Objects::nonNull) // val -> val != null
                .mapToLong(Long::longValue)
                .toArray();
    }
    static long roomCheck(long num) {
        if(!map.containsKey(num)) {
            map.put(num, num + 1);
            return num;
        }

        long next = map.get(num);
        long empty = roomCheck(next);
        System.out.println(num + ": next: " + next);
        System.out.println(num + ": empty: " + empty);
        map.put(num, empty);
        return empty;
    }

    /*
    * 효율성 탈락
    */
//    static void roomCheck(long num) {
//        if(memory[memoryIndex] == 0) {
//            if(map.containsKey(num))
//                roomCheck(num+1);
//            else
//                memory[memoryIndex++] = num;
//
//        }
//        else roomCheck(num+1);
//    }

    /*
     * 효율성 탈락
     */
//    void roomCheck(long num) {
//        if(room[(int) (num-1)] == 0) {
//            memory[memoryIndex++] = num;
//            room[(int) (num-1)] = num;
//        }
//        else roomCheck(num+1);
//    }

    public static void main(String[] args) {
        long k1= 10;
        long[] room_number1 = {1,3,4,1,3,1};
        long[] answer1 =  {1,3,4,2,5,6};
        long[] myRes1 = solution(k1, room_number1);

        System.out.println("answer1: " + Arrays.toString(answer1));
        System.out.println("myRes1: " + Arrays.toString(myRes1));

    }
}

