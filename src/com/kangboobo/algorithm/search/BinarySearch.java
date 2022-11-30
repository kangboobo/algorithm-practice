package com.kangboobo.algorithm.search;

/**
 * @author zhu.changgen
 * @version 1.0
 * @title 二分查找
 * @date 2022/11/30 9:49
 * @description
 */
public class BinarySearch {

    public static int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


}
