package com.kangboobo.algorithm.sort;

/***
 * @description 快速排序算法
 * @author kangboobo
 *
 */
public class QuikSort {

	public static void sort(int[] a, int left, int right) {
		if (right <= left) {
			return;
		}

		int i, j, index;
        i = left;
        j = right;
        index = a[i]; // 用子表的第一个记录做基准
        while (i < j) {
        	// 从表的两端交替向中间扫描
            while (i < j && a[j] >= index)
                j--;
            if (i < j)
                a[i++] = a[j];// 从右向左扫描，用比基准小的记录替换低位记录

            while (i < j && a[i] < index)
                i++;
            if (i < j) // 从左向右扫描，用比基准大的记录替换高位记录
                a[j--] = a[i];
        }
        a[i] = index;// 将基准数值替换回 a[i]

        sort(a, left, i - 1); // 对低子表进行递归排序
        sort(a, i + 1, right); // 对高子表进行递归排序
	}
}
