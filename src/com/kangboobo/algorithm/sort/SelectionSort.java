package com.kangboobo.algorithm.sort;

/***
 * @description 选择排序法
 * 		外循环根据内循环结束后的最小元素下标交换位置
 * 		内循环两两比较，记录较小的元素的下标
 * 分类：内部比较排序
 * 循环次数：(n-1)+(n-2)+(n-3)+...+3+2+1 =n*(n-1)/2
 * 交换次数：取决于倒置数
 * 时间复杂度：O(n2)
 * 空间复杂度：O(1)
 * 稳定性：不稳定
 *
 * @author kangboobo
 *
 */
public class SelectionSort {

	public static void sort(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			int min = i;// 记录最小元素下标
			for (int j = i + 1; j < arr.length; j++) {
				if(arr[j] < arr[min]){
					min = j;
				}
			}

			if(min != i){
				exchange(arr,min,i);
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
