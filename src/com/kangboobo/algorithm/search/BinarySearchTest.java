package com.kangboobo.algorithm.search;

/**
 * @author zhu.changgen
 * @version 1.0
 * @date 2022/11/30 10:03
 * @title
 * @description
 */
public class BinarySearchTest {

    public static void main(String[] args) {
        int[] arr = new int[]{-1,0,3,4,6,10,13,14};
        int target = 13;
        System.out.println(BinarySearch.search(arr, target));
    }
}
