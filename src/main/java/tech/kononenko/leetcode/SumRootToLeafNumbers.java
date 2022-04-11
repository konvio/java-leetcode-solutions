package tech.kononenko.leetcode;

/**
 * 129. Sum Root to Leaf Numbers
 */
public class SumRootToLeafNumbers {

    /**
     * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
     * <p>
     * An example is the root-to-leaf path 1->2->3 which represents the number 123.
     * <p>
     * Find the total sum of all root-to-leaf numbers.
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        totalSum = 0;
        sumNumbers(root, 0);
        return totalSum;
    }

    private int totalSum = 0;

    private void sumNumbers(TreeNode root, int currentSum) {
        currentSum = currentSum * 10 + root.val;

        if (root.left == null && root.right == null) {
            totalSum += currentSum;
            return;
        }

        if (root.left != null) sumNumbers(root.left, currentSum);
        if (root.right != null) sumNumbers(root.right, currentSum);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
