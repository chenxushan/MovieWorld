package com.mobius.leetcode.presum;

import java.util.Arrays;

/**
 * 给定一个整数类型的数组 nums，返回数组的「枢纽元素」。
 * 数组的「枢纽元素」定义为：对于数组中的某个元素 ，若  左侧所有元素之和等于右侧所有元素之和，则  为枢纽元素。
 * 如果数组不存在枢纽元素，则返回 -1。如果数组有多个中心索引，则返回最左边一个。
 */
public class PivotIndex724 {
    public int pivotIndex(int[] nums) {

        if (nums.length == 1 || nums.length == 0) {
            return 0;
        }

        int total = Arrays.stream(nums).sum();
        int length = nums.length;
        int [] preSum  = new int[length+1];
        preSum[0] = 0;
        for (int i = 0 ;i < length; i++) {
            preSum[i+1] = preSum[i] + nums[i];
        }

        for (int j = 0; j < length; j++) {
            if (preSum[j] == preSum[length] - preSum[j+1]) {
                return j;
            }
        }
        return -1;
    }

    public int pivotIndex1(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }


}
