package com.kangboobo.algorithm.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Title ArrangeNK
 * @Description 第K排列问题
 * @Author zhucg
 */
public class ArrangeNK {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        Integer k = scanner.nextInt();
        int[] factorialArr = getFactorialArray(n);
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        StringBuffer sb = new StringBuffer();
        getPermutation(n, k - 1, factorialArr, sb, numbers);
        System.out.println(sb);
        System.out.println(getPermutation(n, k));
    }

    public static int[] getFactorialArray(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] * i;
        }
        return arr;
    }

    /**
     * @Title getPermutation
     * @Description 获取第K个排列（递归实现）
     * @param
     * @return
     */
    public static void getPermutation(int n, int k, int[] factorialArr, StringBuffer sb, List<Integer> numbers) {
        if (n == 0) {
            return;
        }
        int index = k / factorialArr[n - 1];
        int number = numbers.get(index);
        numbers.remove(index);
        sb.append(number);
        getPermutation(n - 1, k % factorialArr[n - 1], factorialArr, sb, numbers);
    }

    /**
     * @Title getPermutation
     * @Description 获取第K个排列（非递归实现）
     * @param
     * @return
     */
    public static String getPermutation(int n, int k) {
        String permutation = "";
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        k--;
        int[] f = getFactorialArray(n);
        for (int i = n; i > 0; i--) {
            int index = k / f[i - 1];
            permutation += numbers.get(index);
            numbers.remove(index);
            k = k % f[i - 1];
        }
        return permutation;
    }
}
