package tech.kononenko.leetcode;

import java.util.BitSet;

/**
 * 73. Set Matrix Zeroes
 */
public class SetMatrixZeroes {

    /**
     * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
     */
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;

        int rows = matrix.length;
        int cols = matrix[0].length;

        BitSet zeroRows = new BitSet(rows);
        BitSet zeroCols = new BitSet(cols);

        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if (matrix[row][col] == 0) {
                    zeroCols.set(col);
                    zeroRows.set(row);
                }
            }
        }

        for (int i = 0; i < rows; ++i) {
            if (zeroRows.get(i)) fillRowZeroes(matrix, i);
        }

        for (int i = 0; i < cols; ++i) {
            if (zeroCols.get(i)) fillColZeroes(matrix, i);
        }
    }

    private void fillRowZeroes(int[][] matrix, int row) {
        for (int col = 0; col < matrix[row].length; ++col) {
            matrix[row][col] = 0;
        }
    }

    private void fillColZeroes(int[][] matrix, int col) {
        for (int row = 0; row < matrix.length; ++row) {
            matrix[row][col] = 0;
        }
    }
}
