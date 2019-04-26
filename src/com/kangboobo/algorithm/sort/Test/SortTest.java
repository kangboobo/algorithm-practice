package com.kangboobo.algorithm.sort.Test;

import com.kangboobo.algorithm.sort.impl.ShellSort;

/***
 * @description
 * @author kangboobo
 *
 */
public class SortTest {

	public static int N = 5;// 数组大小

	public static void main(String[] args) {
		int[] a = new int[N];
		getData(a);

		show(a);

		new ShellSort().sort(a);

		show(a);
	}

	public static void getData(int[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (Math.random() * 10000);
		}
	}

	public static void show(int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (i < a.length - 1)
				System.out.print(a[i] + ",");
			else
				System.out.print(a[i]);
		}
		System.out.println();
	}
}
