package com.busyzero.algo8;

/**
 * @Descrition  动态规划图
 * 跳台阶 一只青蛙一次可以跳上一级台阶， 也可以两级。 求该青蛙跳上n级台阶总共多少种跳发
 * @author wangdong
 * @mail katey2658@163.com
 * @date 2020/6/7 2:46 下午
 */
public class Solution {
    public int jumpFloor(int target) {
        if (target < 1) return 0;
        int[] dp = new int[3];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = dp[0] + dp[1];
        if (target < 3) {
            return dp[target - 1];
        }
        for (int i = 4; i < target; i++) {
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = dp[0] + dp[1];
        }
        return dp[2];
    }
}
