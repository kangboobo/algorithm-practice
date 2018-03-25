package com.kangboobo.algorithm.sort;

/***
 * @description 冒泡排序法
 * 		外循环每次取得一个最大元素
 * 		内循环两两比较，较大的元素交换到右边
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
public class BubbleSort {

	public static void sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i; j++) {
				if(arr[j] < arr[j+1]){
					exchange(arr,j,j+1);
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
