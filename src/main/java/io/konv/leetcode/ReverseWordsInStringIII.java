package io.konv.leetcode;

/**
 * 557. Reverse Words in a String III
 */
public class ReverseWordsInStringIII {

    /**
     * Given a string, you need to reverse the order of characters in each word within a sentence
     * while still preserving whitespace and initial word order.
     * <p>
     * In the string, each word is separated by single space and there will not be any extra space in the string.
     */
    public String reverseWords(String s) {
        if (s.isEmpty()) return s;

        char[] chars = s.toCharArray();

        int start = -1;
        int end = findNextWhitespaceIndex(chars, start + 1);
        if (end < 0) end = s.length();

        while (start < s.length()) {
            reverse(chars, start + 1, end - 1);
            start = end;
            end = findNextWhitespaceIndex(chars, start + 1);
            if (end < 0) end = s.length();
        }

        return new String(chars);
    }

    private int findNextWhitespaceIndex(char[] a, int start) {
        for (int i = start; i < a.length; ++i) {
            if (a[i] == ' ') return i;
        }
        return -1;
    }

    private void reverse(char[] a, int startInclusive, int endInclusive) {
        for (int i = 0; i < (endInclusive - startInclusive + 2) / 2; ++i) {
            swap(a, startInclusive + i, endInclusive - i);
        }
    }

    private void swap(char[] a, int i, int j) {
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
