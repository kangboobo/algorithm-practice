package com.kangboobo.algorithm.sort.impl;

import com.kangboobo.algorithm.sort.Sort;

/***
 * @description 希尔排序算法
 *
 * 插入排序法升级版，解决插入排序每次只能移动一位的低效操作
 *
 * 选择一个增量序列hk,hk-1...h3,h2,h1(h1=1)
 *
 * 第一轮按照hk的步长将数组划分为n/hk+1个子数组，对每个子数组进行插入排序
 *
 * 最后一轮时，相当于对几乎排序好的数组进行插入排序
 *
 * 分类：内部比较排序
 *
 * 循环次数：
 *
 * 交换次数：
 *
 * 时间复杂度：O(n * log n） --> O(n * log2n)取决于步长序列，空间复杂度：O(1)
 *
 * 稳定性：不稳定
 *
 * @author kangboobo
 *
 */
public class ShellSort implements Sort {

    /**
     * 排序方法
     *
     * @param arr
     */
    @Override
    public void sort(int[] arr) {
        int h = 1;
        // 根据数组的长度确定增量序列的最大值
        while (h <= arr.length) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            // 每轮按照增量序列作为步长进行插入排序
            for (int i = h; i < arr.length; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (arr[j] < arr[j - h]) {
                        exchange(arr, j, j - h);
                    }
                }
            }
            // 递减增量序列，进行下一轮排序
            h = (h - 1) / 3;
        }
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
}
