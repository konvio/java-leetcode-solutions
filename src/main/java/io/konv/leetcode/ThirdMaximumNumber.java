package io.konv.leetcode;

/**
 * 414. Third Maximum Number
 */
public class ThirdMaximumNumber {

    /**
     * Given a non-empty array of integers, return the third maximum number in this array.
     * If it does not exist, return the maximum number.
     * The time complexity must be in O(n).
     */
    public int thirdMax(int[] nums) {
        long[] top = {Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE};
        for (int n : nums) {
            if (n == top[0] || n == top[1] || n == top[2]) continue;
            if (n > top[2]) top[2] = n;
            if (top[2] > top[1]) swap(top, 1, 2);
            if (top[1] > top[0]) swap(top, 0, 1);
        }
        return (top[2] > Long.MIN_VALUE) ? (int) top[2] : (int) top[0];
    }

    private void swap(long[] a, int i, int j) {
        long t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
