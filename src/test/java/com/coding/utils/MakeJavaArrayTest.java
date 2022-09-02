package com.coding.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MakeJavaArrayTest {

//    @Test
//    public void test1() {
//        PrintUtils.printArray(MakeJavaArray.replaceIntArray1(
//                "[2, 3, 4]"
//        ));
//    }

    @Test
    public void test2() {
        PrintUtils.printArray(MakeJavaArray.replaceIntArray2(
                "[[1, 3, 10], [1, 4, 20], [2, 3, 4], [2, 4, 6], [3, 5, 20], [4, 5, 6]]"
        ));
    }
}