package com.liuyiyang.code.dongtaiguihua;

import java.util.Scanner;

/**
 * 第一行输入weight：背包载重，表示背包最多能装多重的东西
 * 第二行输入nums：表示物品的数量
 * 之后跟nums行，表示每个物品的重量weight，以及物品的价值value
 * <p>
 * 输出：背包最多能装多少价值的东西
 * <p>
 * 1、F（surplusWeight, index）的最优子结构：F（surplusWeight, index - 1）和 F（surplusWeight - weights[index], index - 1）+ values[index]
 * 2、状态转移方程：F（surplusWeight, index） = Math.max(F（surplusWeight, index - 1）, F（surplusWeight - weights[index], index - 1）+ values[index])
 * 3、问题的边界：index = 0
 */
public class BeiBaoWenTi {
    private static int weight, nums;
    private static int[] weights, values;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        weight = sc.nextInt();
        nums = sc.nextInt();
        weights = new int[nums];
        values = new int[nums];
        for (int i = 0; i < nums; i++) {
            weights[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }
        System.out.println(dynamicProgramming(nums - 1, weight));
        System.out.println(dynamicProgramming2());
        System.out.println(dynamicProgramming3());
    }

    /**
     * 递归版本，自上而下，保存中间结果
     */
    public static int dynamicProgramming(int index, int surplusWeight) {
        if (index == 0) {
            return surplusWeight >= weights[index] ? values[index] : 0;
        }
        if (surplusWeight < weights[index]) {
            return dynamicProgramming(index - 1, surplusWeight);
        }
        return Math.max(dynamicProgramming(index - 1, surplusWeight), dynamicProgramming(index - 1, surplusWeight - weights[index]) + values[index]);
    }

    /**
     * 循环版本，自下而上，保存中间结果
     */
    public static int dynamicProgramming2() {
        int[][] dp = new int[nums][weight + 1];
        for (int index = 0; index < nums; index++) {
            for (int surplusWeight = 0; surplusWeight <= weight; surplusWeight++) {
                if (index == 0) {
                    dp[index][surplusWeight] = surplusWeight >= weights[index] ? values[index] : 0;
                } else if (surplusWeight < weights[index]) {
                    dp[index][surplusWeight] = dp[index - 1][surplusWeight];
                } else {
                    dp[index][surplusWeight] = Math.max(dp[index - 1][surplusWeight], dp[index - 1][surplusWeight - weights[index]] + values[index]);
                }
            }
        }
        return dp[nums - 1][weight];
    }

    /**
     * 循环版本，自下而上，不保存中间结果
     */
    public static int dynamicProgramming3() {
        int[] dp = new int[weight + 1];
        for (int index = 0; index < nums; index++) {
            for (int surplusWeight = weight; surplusWeight >= 0; surplusWeight--) {
                if (index == 0) {
                    dp[surplusWeight] = surplusWeight >= weights[index] ? values[index] : 0;
                } else if (surplusWeight >= weights[index]) {
                    dp[surplusWeight] = Math.max(dp[surplusWeight], dp[surplusWeight - weights[index]] + values[index]);
                }
            }
        }
        return dp[weight];
    }
}
