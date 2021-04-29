package com.liuyiyang.code.dongtaiguihua;

import java.util.Scanner;

/**
 * 计算1 + 2 +......+ n -1 + n
 * <p>
 * 状态转移方程：F（n）= F（n-1）+ n
 */
public class NumberSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 1) {
            throw new IndexOutOfBoundsException("输入的N必须大于等于一");
        }
        System.out.println(sum(n));
        System.out.println(sum2(n));
    }

    /**
     * 递归版本，自上而下，保存中间结果
     */
    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return sum(n - 1) + n;
    }

    /**
     * 循环版本，自下而上，不保存中间结果
     */
    public static int sum2(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}
