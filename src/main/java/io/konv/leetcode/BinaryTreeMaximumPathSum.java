package io.konv.leetcode;

/**
 * 124. Binary Tree Maximum Path Sum
 */
public class BinaryTreeMaximumPathSum {

    private int GLOBAL_MAX_PATH_SUM;

    /**
     * Given a non-empty binary tree, find the maximum path sum.
     * <p>
     * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree
     * along the parent-child connections.
     * <p>
     * The path must contain at least one node and does not need to go through the root.
     */
    public int maxPathSum(TreeNode root) {
        GLOBAL_MAX_PATH_SUM = root.val;
        calculateMaxRootToChildPathSum(root);
        return GLOBAL_MAX_PATH_SUM;
    }

    private int calculateMaxRootToChildPathSum(TreeNode root) {
        int leftPathSum = (root.left != null) ? calculateMaxRootToChildPathSum(root.left) : 0;
        int rightPathSum = (root.right != null) ? calculateMaxRootToChildPathSum(root.right) : 0;

        int pathSum = root.val;
        if (leftPathSum > 0) pathSum += leftPathSum;
        if (rightPathSum > 0) pathSum += rightPathSum;
        if (pathSum > GLOBAL_MAX_PATH_SUM) GLOBAL_MAX_PATH_SUM = pathSum;

        return root.val + Math.max(0, Math.max(leftPathSum, rightPathSum));
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
