package tech.kononenko.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 */
public class TwoSum {

    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * <p>
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (indexMap.containsKey(target - nums[i])) {
                int matchingIndex = indexMap.get(target - nums[i]);
                return new int[]{matchingIndex, i};
            }
            indexMap.put(nums[i], i);
        }
        return null;
    }
}
