package tech.kononenko.leetcode;

/**
 * 58. Length of Last Word
 */
public class LengthOfLastWord {

    /**
     * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
     * <p>
     * If the last word does not exist, return 0.
     */
    public int lengthOfLastWord(String s) {
        int len = 0;
        for (int i = indexOfLastNonEmptyChar(s); i >= 0 && s.charAt(i) != ' '; --i) len++;
        return len;
    }

    private int indexOfLastNonEmptyChar(String s) {
        for (int i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) != ' ') return i;
        }
        return -1;
    }
}
