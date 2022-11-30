package com.kangboobo.algorithm.sort.impl;

import com.kangboobo.algorithm.sort.Sort;

/***
 * @description 快速排序算法
 *
 *              冒泡排序法升级版，采用分治和递归的思想
 *
 *              每趟递归选择一个基准元素（待排序数组的第一个元素），将小于基准元素的都交换到左边，大于基准元素的都交换的右边
 *
 *              分类：内部比较排序
 *
 *              循环次数：
 *
 *              交换次数：
 *
 *              时间复杂度：O(nlogn) --> O(n2) 空间复杂度：O(logn) --> O(n),取决于递归树的深度
 *
 *              稳定性：不稳定
 *
 * @author kangboobo
 *
 */
public class QuikSort implements Sort {

    /**
     * 排序方法
     *
     * @param arr
     */
    @Override
    public void sort(int[] arr) {
        sort2(arr, 0, arr.length - 1);
    }

    /**
     * 交换from和to下标的元素位置
     *
     * @param arr
     * @param from
     * @param to
     */
    @Override
    public void exchange(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }

    /**
     * 实现方式1
     *
     * @param arr
     * @param left
     * @param right
     */
    public void sort1(int[] arr, int left, int right) {
        if (right <= left) {
            return;
        }
        int i = left; // 左端下标
        int j = right;// 右端下标
        int index = arr[i]; // 第一个元素做基准
        while (i < j) {
            while (i < j && arr[j] >= index) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];// 从右向左扫描，用比基准小的记录替换低位记录
                i++;
            }
            while (i < j && arr[i] < index) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];// 从左向右扫描，用比基准大的记录替换高位记录
                j--;
            }
        }
        arr[i] = index;// 将基准元素交换到 a[i]，且此位置为最终位置
        sort1(arr, left, i - 1); // 对左子表进行递归排序
        sort1(arr, i + 1, right); // 对右子表进行递归排序
    }

    /**
     * 实现方式2
     *
     * @param arr
     * @param left
     * @param right
     */
    public void sort2(int[] arr, int left, int right) {
        if (right <= left) {
            return;
        }

        int key = arr[left]; // 第一个元素做基准
        int low = left; // 小于基准的子数组最后一个元素的索引
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < key) {
                low++;
                exchange(arr, low, i);// 把小于基准的元素放到子数组末尾
            }
        }
        // 最后把基准放到子数组的最后后边，右边的子数组既是大于基准的子数组
        arr[left] = arr[low];
        arr[low] = key;
        sort2(arr, left, low - 1); // 对左子表进行递归排序
        sort2(arr, low + 1, right); // 对右子表进行递归排序
    }
}
