package com.kangboobo.algorithm.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhu.changgen
 * @version 1.0
 * @date 2022/11/30 10:25
 * @title
 * @description ranko 的手表坏了，正常应该显示 xx:xx 的形式（4 个数字），比如下午 1 点半应该显示 13:30 ，但现在经常会有一些数字有概率无法显示。
 * ranko 在  t_t1 时刻看了下时间，过了一段时间在 t_t2 时刻看了下时间。她想知道， t_t1 和 t_t2 这两个时刻之间相距的时间的最大值和最小值是多少？
 * 保证 t_t1 在 t_t2 之前（且 t_t1 和 t_t2 不等）。t_t1和 t_t2在同一天的 00:00 到 23:59 之间。
 * <p>
 * ### 输入描述：
 * 两行输入两个时间，为 xx:xx 的形式。其中 xx 为数字或者字符 '?' ，问号代表这个数字没有显示。
 * 保证输入是合法的。
 * <p>
 * ### 输出描述：
 * 一行输出两个整数，分别代表 t_t1 和 t_t2 相距时间的最小值和最大值（单位分钟）。
 * <p>
 * 输入：
 * 18:0?
 * 2?:1?
 * 输出：
 * 121 319
 * 说明：
 * 相距最小的时间为 18:09 到 20:10 ，相距121分钟。
 * 相距最大的时间为 18:00 到 23:19 ，相距319分钟。
 */
public class RankoTime {

    public static void search(String firstTimeStr, String secondTimeStr) {
        List<Integer> firstTime = new ArrayList<>();
        List<Integer> secondTime = new ArrayList<>();
        for (int i = 0; i < 24 * 60; i++) {
            int hour = i / 60;
            int min = i % 60;
            if ((firstTimeStr.charAt(0) == '?' || firstTimeStr.charAt(0) - '0' == hour / 10)
                    && (firstTimeStr.charAt(1) == '?' || firstTimeStr.charAt(1) - '0' == hour % 10)
                    && (firstTimeStr.charAt(3) == '?' || firstTimeStr.charAt(3) - '0' == min / 10)
                    && (firstTimeStr.charAt(4) == '?' || firstTimeStr.charAt(4) - '0' == min % 10)) {
                firstTime.add(i);
            }
            if ((secondTimeStr.charAt(0) == '?' || secondTimeStr.charAt(0) - '0' == hour / 10)
                    && (secondTimeStr.charAt(1) == '?' || secondTimeStr.charAt(1) - '0' == hour % 10)
                    && (secondTimeStr.charAt(3) == '?' || secondTimeStr.charAt(3) - '0' == min / 10)
                    && (secondTimeStr.charAt(4) == '?' || secondTimeStr.charAt(4) - '0' == min % 10)) {
                secondTime.add(i);
            }
        }

        int max = secondTime.get(secondTime.size() - 1) - firstTime.get(0);
        int min = 60 * 24;
        for (int first : firstTime) {
            for (int second : secondTime) {
                if (first < second) {
                    min = Math.min(second - first, min);
                }
            }
        }
        System.out.println(min + " " + max);
    }

    /**
     * 暴力方式计算最大间隔
     *
     * @param firstTimeHour
     * @param firstTimeMin
     * @param secondTimeHour
     * @param secondTimeMin
     * @return
     */
    public static int max(String firstTimeHour, String firstTimeMin,
                          String secondTimeHour, String secondTimeMin) {
        // 第一个时间取所有可能性中最小值
        char firstTimeHour1 = firstTimeHour.startsWith("?") ? '0' : firstTimeHour.charAt(0);
        char firstTimeHour2 = firstTimeHour.endsWith("?") ? '0' : firstTimeHour.charAt(1);
        int firstHour = Integer.parseInt(firstTimeHour1 + firstTimeHour2 + "");
        char firstTimeMin1 = firstTimeMin.startsWith("?") ? '0' : firstTimeMin.charAt(0);
        char firstTimeMin2 = firstTimeMin.endsWith("?") ? '0' : firstTimeMin.charAt(1);
        int firstMin = Integer.parseInt(firstTimeMin1 + firstTimeMin2 + "");
        // 第二个时间取所有可能性中最大值
        char secondTimeHour1 = secondTimeHour.startsWith("?") ? '2' : secondTimeHour.charAt(0);
        char secondTimeHour2 = secondTimeHour.endsWith("?") ?
                (secondTimeHour1 == '2' ? '3' : '9') : secondTimeHour.charAt(1);
        int secondHour = Integer.parseInt(secondTimeHour1 + secondTimeHour2 + "");
        char secondTimeMin1 = secondTimeMin.startsWith("?") ? '5' : secondTimeMin.charAt(0);
        char secondTimeMin2 = secondTimeMin.endsWith("?") ? '9' : secondTimeMin.charAt(1);
        int secondMin = Integer.parseInt(secondTimeMin1 + secondTimeMin2 + "");
        // 计算时间间隔
        return (secondHour * 60 + secondMin) - (firstHour * 60 + firstMin);
    }

}
