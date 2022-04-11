package tech.kononenko.leetcode;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 179. Largest Number
 */
public class LargerstNumber {

    /**
     * Given a list of non negative integers, arrange them such that they form the largest number.
     * <p>
     * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
     */
    public String largestNumber(int[] nums) {
        return Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> new BigInteger(s2 + s1).compareTo(new BigInteger(s1 + s2)))
                .collect(Collectors.joining())
                .replaceFirst("^0+", "0");
    }
}
