package tech.kononenko.leetcode;

/**
 * 794. Valid Tic-Tac-Toe State
 */
public class ValidTicTacToeState {

    /**
     * A Tic-Tac-Toe board is given as a string array board. Return True if and only if it is possible to reach this board position during the course of a valid tic-tac-toe game.
     * <p>
     * The board is a 3 x 3 array, and consists of characters " ", "X", and "O".  The " " character represents an empty square.
     * <p>
     * Here are the rules of Tic-Tac-Toe:
     * <p>
     * Players take turns placing characters into empty squares (" ").
     * The first player always places "X" characters, while the second player always places "O" characters.
     * "X" and "O" characters are always placed into empty squares, never filled ones.
     * The game ends when there are 3 of the same (non-empty) character filling any row, column, or diagonal.
     * The game also ends if all squares are non-empty.
     * No more moves can be played if the game is over.
     */
    public boolean validTicTacToe(String[] board) {
        int firstMoves = countChar(board, 'X');
        int secondMoves = countChar(board, 'O');

        int diff = firstMoves - secondMoves;
        if (!(diff == 0 || diff == 1)) return false;

        boolean isFirstWinner = isWinner(board, 'X');
        boolean isSecondWinner = isWinner(board, 'O');
        if (isFirstWinner && isSecondWinner) return false;

        if (isFirstWinner && (firstMoves <= secondMoves)) return false;
        if (isSecondWinner && (firstMoves != secondMoves)) return false;

        return true;
    }

    private boolean isWinner(String[] board, char marker) {
        return containsThreeInRow(board, marker) ||
                containsThreeInColumn(board, marker) ||
                containsThreeInDiagonal(board, marker);
    }

    private boolean containsThreeInRow(String[] board, char c) {
        for (int row = 0; row < 3; ++row) {
            if ((board[row].charAt(0) == c) && (board[row].charAt(1) == c) && (board[row].charAt(2) == c)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsThreeInColumn(String[] board, char c) {
        for (int col = 0; col < 3; ++col) {
            if ((board[0].charAt(col) == c) && (board[1].charAt(col) == c) && (board[2].charAt(col) == c)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsThreeInDiagonal(String[] board, char c) {
        if (board[1].charAt(1) != c) return false;
        return (board[0].charAt(2) == c && board[2].charAt(0) == c) ||
                (board[0].charAt(0) == c && board[2].charAt(2) == c);
    }

    private int countChar(String[] strings, char c) {
        int count = 0;
        for (String s : strings) {
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == c) count++;
            }
        }
        return count;
    }
}
