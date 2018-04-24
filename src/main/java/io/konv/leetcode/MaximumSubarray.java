package io.konv.leetcode;

/**
 * 53. Maximum Subarray
 */
public class MaximumSubarray {

    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest
     * sum and return its sum.
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
            if (nums[i] > max) max = nums[i];
        }
        return max;
    }
}
