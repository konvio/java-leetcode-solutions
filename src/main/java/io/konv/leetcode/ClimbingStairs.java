package io.konv.leetcode;

/**
 * 70. Climbing Stairs
 */
public class ClimbingStairs {

    /**
     * You are climbing a stair case. It takes n steps to reach to the top.
     * <p>
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     */
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int last = 2, secondLast = 1, current = 3;
        for (int i = 3; i <= n; ++i) {
            current = last + secondLast;
            secondLast = last;
            last = current;
        }

        return current;
    }
}
