package com.kangboobo.algorithm.hanoi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhu.changgen
 * @version 1.0
 * @date 2022/11/30 13:16
 * @title 汉诺塔问题
 * @description 我们有由底至上为从大到小放置的 n 个圆盘，和三个柱子（分别为左/中/右即left/mid/right），开始时所有圆盘都放在左边的柱子上，按照汉诺塔游戏的要求我们要把所有的圆盘都移到右边的柱子上，要求一次只能移动一个圆盘，而且大的圆盘不可以放到小的上面。
 * <p>
 * 请实现一个函数打印最优移动轨迹。
 * <p>
 * 给定一个 `int n` ，表示有 n 个圆盘。请返回一个 `string` 数组，其中的元素依次为每次移动的描述。描述格式为： `move from [left/mid/right] to [left/mid/right]`。
 * <p>
 * 数据范围：1\le n \le 161≤n≤16
 * 要求：时间复杂度 O(3^n)O(3
 * n
 * ) ， 空间复杂度 O(3^n)O(3
 * n
 * )
 */
public class HanoiProblem {

    public List<String> moveList = new ArrayList<>();

    /**
     * 递归
     * 汉诺塔问题的解决方案可以分为3步：
     * 1、把n-1个盘子从left 借助 right，搬到mid柱子上；
     * 2、把剩下最大的那一个盘子从left搬到right柱子上；
     * 3、把n-1个盘子从mid 借助 left，搬到right柱子上。
     *
     * @param n
     * @param from
     * @param temp
     * @param to
     * @return
     */
    public void move(int n, String from, String temp, String to) {
        if (n == 0) {
            return;
        }
        move(n - 1, from, to, temp);
        moveList.add("move from " + from + " to " + to);
        move(n - 1, temp, from, to);
    }
}
