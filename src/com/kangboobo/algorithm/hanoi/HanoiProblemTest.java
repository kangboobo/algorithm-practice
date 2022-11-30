package com.kangboobo.algorithm.hanoi;

import java.util.List;

/**
 * @author zhu.changgen
 * @version 1.0
 * @date 2022/11/30 13:24
 * @title
 * @description
 */
public class HanoiProblemTest {

    public static void main(String[] args) {
        HanoiProblem hanoiProblem = new HanoiProblem();
        hanoiProblem.move(3, "left", "mid", "right");
        List<String> moveList = hanoiProblem.moveList;
        System.out.println(moveList);
    }
}
