package com.kangboobo.algorithm.math;

/**
 * @author zhu.changgen
 * @version 1.0
 * @date 2022/11/30 14:32
 * @title 请你计算 a^b mod p 的值。
 * @description
 */
public class FastPower {

    public static long cal(long a, long b, long p) {
        // 根据公式 (a1*a2)^b % p = (a1%p)^b * (a2%p)^b % p 可以进行快速幂计算
        long result = 1;
        while (b > 0) {
            if (b % 2 == 0) {
                b = b / 2;
                a = a * a % p;
            } else {
                b--;
                result = result * a % p;
            }
        }
        return result;
    }
}
