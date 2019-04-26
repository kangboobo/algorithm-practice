package com.kangboobo.algorithm.sort;

/***
 * @description 排序算法
 * @author kangboobo
 *
 */
public interface Sort {

	/**
	 * 排序方法
	 *
	 * @param arr
	 */
	public void sort(int[] arr);

	/**
	 * 交换元素方法
	 *
	 * @param arr
	 * @param from
	 * @param to
	 */
	public void exchange(int[] arr, int from, int to);
}
