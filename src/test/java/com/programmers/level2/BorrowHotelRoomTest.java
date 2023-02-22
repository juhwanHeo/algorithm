package com.programmers.level2;

import com.coding.utils.PrintUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BorrowHotelRoomTest {

    @Test
    void solution1() {
        String[][] book_time = {
                {"15:00", "17:00"},
                {"16:40", "18:20"},
                {"14:20", "15:20"},
                {"14:10", "19:20"},
                {"18:20", "21:20"}
        };

        int expected = 3;

        int result = BorrowHotelRoom.solution(book_time);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution2() {
        String[][] book_time = {
                {"09:10", "10:10"}, {"10:20", "12:20"}
        };

        int expected = 1;

        int result = BorrowHotelRoom.solution(book_time);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution3() {
        String[][] book_time = {
                {"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}
        };

        int expected = 3;

        int result = BorrowHotelRoom.solution(book_time);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    void solution4() {
        /*
         * 누적합 테스트
         *
         * 2 ~ 5분
         * arr[2] += 1
         * arr[5 + 1] -= 1
         * [0, 0, 1, 0, 0, 0, -1, 0, 0, 0, -1]
         *
         * 4 ~ 10 분
         * arr[4] += 1;
         * arr[9 + 1] -= 1;
         * [0, 0, 1, 0, 1, 0, -1, 0, 0, 0, -1]
         * */
        int[] arr = new int[11]; // 0 ~ 10 분

        arr[0] += 1;
        arr[9 + 1] -= 1;
        arr[2] += 1;
        arr[5 + 1] -= 1;
        arr[4] += 1;
        arr[9 + 1] -= 1;

        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
            PrintUtils.printArray(arr);
        }
    }

}