package com.busyzero.algo9;

/**
 * @author wangdong
 * @mail katey2658@163.com
 * @date 2020/6/7 3:05 下午
 */
public class Solution {
    public int rectCover(int target) {
        if (target < 1) return 0;
        int[] dp = new int[3];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = dp[0] + dp[1];
        if (target < 4) {
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
