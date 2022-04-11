package tech.kononenko.leetcode;

/**
 * 72. Edit Distance
 */
public class EditDistance {

    /**
     * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
     * <p>
     * You have the following 3 operations permitted on a word:
     * <p>
     * Insert a character
     * Delete a character
     * Replace a character
     */
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();

        // D[i][j] = minDistance(word1[1..i], word2[1..j])
        int[][] D = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i < D.length; ++i) D[i][0] = i;
        for (int i = 0; i < D[0].length; ++i) D[0][i] = i;

        for (int i = 1; i < D.length; ++i) {
            for (int j = 1; j < D[i].length; ++j) {
                D[i][j] = Math.min(Math.min(D[i - 1][j], D[i][j - 1]) + 1,
                        D[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1)
                );
            }
        }

        return D[word1.length()][word2.length()];
    }
}
