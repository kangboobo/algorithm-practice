package com.kangboobo.algorithm.math;

/**
 * @author zhu.changgen
 * @version 1.0
 * @date 2022/11/30 15:29
 * @title
 * @description 请你计算 a*b mod p的值。要求只能使用加法和取模运算，且计算过程中的值不能超过 2*10^7
 */
public class FastAdd {

    public static int cal(int a, int b, int p) {
        int r = 0;
        while (b > 0) {
            if (b % 2 == 0) {
                b /= 2;
                a = (a + a) % p;
            } else {
                b--;
                r = (r + a) % p;
            }
        }
        return r;
    }
}
