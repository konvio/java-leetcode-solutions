package io.konv.leetcode;

/**
 * 307. Range Sum Query - Mutable
 */
public class RangeSumQueryMutable {

    /**
     * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
     * The update(i, val) function modifies nums by updating the element at index i to val.
     */
    public static class NumArray {

        private NumArray left, right;
        private int from, to, sum;

        public NumArray(int[] nums) {
            this(0, nums.length - 1, nums);
        }

        public NumArray(int from, int to, int[] nums) {
            if (nums.length == 0) return;
            this.from = from;
            this.to = to;
            if (from == to) {
                sum = nums[from];
                return;
            }
            int mid = (from + to) / 2;
            left = new NumArray(from, mid, nums);
            right = new NumArray(mid + 1, to, nums);
            sum = left.sum + right.sum;
        }

        public void update(int i, int val) {
            if (from == to && from == i) {
                sum = val;
                return;
            }
            int mid = (from + to) / 2;
            if (i <= mid) left.update(i, val);
            else right.update(i, val);
            sum = left.sum + right.sum;
        }

        public int sumRange(int i, int j) {
            if (i <= from && j >= to) return sum;
            int mid = (from + to) / 2;
            if (i > mid) return right.sumRange(i, j);
            if (j <= mid) return left.sumRange(i, j);
            return left.sumRange(i, mid) + right.sumRange(mid + 1, j);
        }
    }
}
