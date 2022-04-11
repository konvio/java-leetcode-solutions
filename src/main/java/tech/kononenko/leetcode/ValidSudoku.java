package tech.kononenko.leetcode;

import java.util.BitSet;

/**
 * 36. Valid Sudoku
 */
public class ValidSudoku {

    private BitSet digitsSet = new BitSet(10);

    /**
     * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
     * <p>
     * Each row must contain the digits 1-9 without repetition.
     * Each column must contain the digits 1-9 without repetition.
     * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
     */
    public boolean isValidSudoku(char[][] board) {
        return verifyRows(board) && verifyColumns(board) && verifySubBoxes(board);
    }

    @SuppressWarnings("Duplicates")
    private boolean verifyRows(char[][] board) {
        int currentDigit = 0;
        for (int row = 0; row < 9; ++row) {
            digitsSet.clear();
            for (int col = 0; col < 9; ++col) {
                if (Character.isDigit(board[row][col])) {
                    currentDigit = board[row][col] - 48;
                    if (digitsSet.get(currentDigit)) return false;
                    digitsSet.set(currentDigit);
                }
            }
        }
        return true;
    }

    @SuppressWarnings("Duplicates")
    private boolean verifyColumns(char[][] board) {
        int currentDigit = 0;
        for (int col = 0; col < 9; ++col) {
            digitsSet.clear();
            for (int row = 0; row < 9; ++row) {
                if (Character.isDigit(board[row][col])) {
                    currentDigit = board[row][col] - 48;
                    if (digitsSet.get(currentDigit)) return false;
                    digitsSet.set(currentDigit);
                }
            }
        }
        return true;
    }

    @SuppressWarnings("Duplicates")
    private boolean verifySubBoxes(char[][] board) {
        int currentDigit = 0;

        for (int leftRow = 0; leftRow <= 6; leftRow += 3) {
            for (int topCol = 0; topCol <= 6; topCol += 3) {
                digitsSet.clear();
                for (int row = leftRow; row <= leftRow + 2; ++row) {
                    for (int col = topCol; col <= topCol + 2; ++col) {
                        if (Character.isDigit(board[row][col])) {
                            currentDigit = board[row][col] - 48;
                            if (digitsSet.get(currentDigit)) return false;
                            digitsSet.set(currentDigit);
                        }
                    }
                }
            }
        }
        return true;
    }
}
