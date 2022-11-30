package com.kangboobo.algorithm.sort.impl;

import com.kangboobo.algorithm.sort.Sort;

/***
 * @description 插入排序算法
 *
 *              外循环对数组中前n个子数组进行排序，每轮仅将第n+1个元素添加进子数组中进行排序，插入到合适的位置
 *
 *              分类：内部比较排序
 *
 *              循环次数：(n-1)+(n-2)+(n-3)+...+3+2+1 =n*(n-1)/2
 *
 *              交换次数：取决于倒置数
 *
 *              时间复杂度：O(n2) 空间复杂度：O(1)
 *
 *              稳定性：稳定
 *
 * @author kangboobo
 *
 */
public class InsertionSort implements Sort {

	/**
	 * 排序方法
	 *
	 * @param arr
	 */
	@Override
	public void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr[j - 1]) {
					exchange(arr, j, j - 1);
				} else {
					break;
				}
			}
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
