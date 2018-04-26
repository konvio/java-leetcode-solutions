package io.konv.leetcode;

/**
 * 64. Minimum Path Sum
 */
public class MinimumPathSum {

    /**
     * Given a m x n grid filled with non-negative numbers,
     * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
     */
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        for (int row = 1; row < rows; ++row) grid[row][0] += grid[row - 1][0];
        for (int col = 1; col < cols; ++col) grid[0][col] += grid[0][col - 1];

        for (int row = 1; row < rows; ++row) {
            for (int col = 1; col < cols; ++col) {
                grid[row][col] += Math.min(grid[row - 1][col], grid[row][col - 1]);
            }
        }

        return grid[rows - 1][cols - 1];
    }
}
