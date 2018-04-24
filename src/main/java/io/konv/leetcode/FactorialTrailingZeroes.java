package io.konv.leetcode;

/**
 * 172. Factorial Trailing Zeroes
 */
public class FactorialTrailingZeroes {

    /**
     * Given an integer n, return the number of trailing zeroes in n!.
     */
    public int trailingZeroes(int n) {
        int res = 0;
        while (n / 5 > 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }
}
