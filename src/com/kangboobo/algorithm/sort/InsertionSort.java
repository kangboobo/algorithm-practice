package com.kangboobo.algorithm.sort;
/***
 * @description 插入排序法
 *		外循环从左到右每轮将一个元素插入到正确的位置
 *		内循环两两比较，将较小的元素左移
 * 分类：内部比较排序
 * 循环次数：(n-1)+(n-2)+(n-3)+...+3+2+1 =n*(n-1)/2
 * 交换次数：取决于倒置数
 * 时间复杂度：O(n2)
 * 空间复杂度：O(1)
 * 稳定性：稳定
 *
 * @author kangboobo
 *
 */
public class InsertionSort {

	public static void sort(int[] arr){
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j >= i; j--) {
				if(arr[j] < arr[j-1]){
					exchange(arr,j,j-1);
				}
			}
		}
	}

	/**
	 * 交换from和to下标的元素位置
	 * @param arr
	 * @param from
	 * @param to
	 */
	public static void exchange(int[] arr, int from, int to) {
		int temp = arr[from];
		arr[from] = arr[to];
		arr[to] = temp;
	}
}
