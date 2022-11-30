package com.kangboobo.algorithm.sort.impl;

import com.kangboobo.algorithm.sort.Sort;

/**
 * @author zhu.changgen
 * @version 1.0
 * @date 2022/11/30 17:05
 * @title 堆排序
 * @description 堆排序，也可以理解为二叉树排序，这里的堆分为两种，一种是大顶堆，一种是小顶堆，我们所有的排序方法都以升序为主，其实倒序原理也都差不多，
 * 所以这里我们主要分析的是大顶堆。大顶堆就是根节点不小于他的两个子节点
 * <p>
 * 时间复杂度：O(n * log n)，空间复杂度：O(1)
 * 稳定性：不稳定
 */
public class HeapSort implements Sort {

    @Override
    public void sort(int[] arr) {
        int len = arr.length;
        // 构建大根堆
        buildMaxHeap(arr, len);
        // 排序
        for (int i = 0; i < len; i++) {
            // 根与最末尾元素替换，最末尾即使最大元素
            swap(arr, 0, len - 1 - i);
            // 对余下子数组进构建大根堆
            heapify(arr, 0, len - 1 - i);
        }
    }

    /**
     * 构建大根堆
     */
    public void buildMaxHeap(int[] arr, int len) {
        for (int i = (len - 2) / 2; i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    @Override
    public void exchange(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }

    private void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
