package com.study.test;

/*
* BinarySearch Study
* */
public class BinarySearch {
    static int[] arr = {1, 3, 5, 7, 8, 10, 20, 35, 99, 100};

    static int binarySearch(int key, int low, int high) {
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (key == arr[mid]) return mid;
            else if (key < arr[mid]) high = mid -1;
            else low = mid + 1;
        }
        return -1;
    }
    public static void main(String[] args) {

    }

}

