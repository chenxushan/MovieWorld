package com.mobius.leetcode.dp;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class Num053 {
    public int maxSubArray(int[] nums) {
        // 子问题：
        // f(k) = nums[0..k) 中以 nums[k-1] 结尾的最大子数组和
        // 原问题 = max{ f(k) }, 0 <= k <= N

        // f(0) = 0
        // f(k) = max{ f(k-1), 0 } + nums[k-1]

        int N = nums.length;
        int[] dp = new int[N+1];
        dp[0] = 0;

        int res = Integer.MIN_VALUE;
        for (int k = 1; k <= N; k++) {
            dp[k] = Math.max(dp[k-1], 0) + nums[k-1];
            res = Math.max(res, dp[k]);
        }
        return res;
    }

    public static int maxSubArray1(int[] nums) {
        // 子问题：
        // f(k) = nums[0..k) 中以 nums[k-1] 结尾的最大子数组和
        // 原问题 = max{ f(k) }, 0 <= k <= N

        // f(0) = 0
        // f(k) = max{ f(k-1), 0 } + nums[k-1]

        int N = nums.length;
        int[] dp = new int[N+1];
        dp[0] = 0;
        int[] back = new int[N+1];
        back[0] = 0;
        int res = Integer.MIN_VALUE;
        for (int k = 1; k <= N; k++) {
            if (dp[k-1] < 0) {
                dp[k] = nums[k-1];
                back[k-1] = 0;
            } else {
                dp[k] = dp[k-1]+nums[k-1];
                back[k-1] = 1;
            }

            //dp[k] = Math.max(dp[k-1], 0) + nums[k-1];
            res = Math.max(res, dp[k]);
        }
        if (dp[N] > 0 && dp[N-1] > 0) {
            back[N] = 1;
        } else{
            back[N] = 0;
        }
        for (int i: dp) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int j: back) {
            System.out.print(j + " ");
        }
        System.out.println();
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray1(nums));
    }
}
