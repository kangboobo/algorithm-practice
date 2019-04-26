package com.kangboobo.algorithm.sort.impl;

import com.kangboobo.algorithm.sort.Sort;

/***
 * @description 快速排序算法-非递归实现
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
public class QuikSortNotRecursion implements Sort {

	/**
	 * 排序方法
	 *
	 * @param arr
	 */
	@Override
	public void sort(int[] arr) {
		sort(arr, 0, arr.length - 1);
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
	 * 实现方式
	 *
	 * @param arr
	 * @param left
	 * @param right
	 */
	public void sort(int[] arr, int left, int right) {

	}

}
