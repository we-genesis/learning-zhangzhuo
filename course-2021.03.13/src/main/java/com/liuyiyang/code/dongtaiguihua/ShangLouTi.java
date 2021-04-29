package com.liuyiyang.code.dongtaiguihua;

import java.util.Scanner;

/**
 * N级楼梯，一步只能跨1级或2级楼梯，一共有多少种走法
 * <p>
 * 1、F（n）的最优子结构：F（n-2）与 F（n-1）
 * 2、状态转移方程：F（n）= F（n-2）+ F（n-1）
 * 3、问题的边界：F（1）与 F（2）
 */
public class ShangLouTi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 1) {
            throw new IndexOutOfBoundsException("输入的N必须大于等于一");
        }
        System.out.println(go(n));
        System.out.println(go2(n));
    }

    /**
     * 递归版本，自上而下，保存中间结果
     */
    public static int go(int n) {
        // 一级楼梯有1种走法
        if (n == 1) {
            return 1;
        }
        // 二级楼梯有2种走法
        if (n == 2) {
            return 2;
        }
        return go(n - 2) + go(n - 1);
    }

    /**
     * 循环版本，自下而上，不保存中间结果
     */
    public static int go2(int n) {
        // 一级楼梯有1种走法
        if (n == 1) {
            return 1;
        }
        // 二级楼梯有2种走法
        if (n == 2) {
            return 2;
        }
        int first = 1;
        int last = 2;
        for (int i = 3; i <= n; i++) {
            last = first + last;
            first = last - first;
        }
        return last;
    }
}
