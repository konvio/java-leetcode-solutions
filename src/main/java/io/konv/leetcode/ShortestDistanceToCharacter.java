package io.konv.leetcode;

/**
 * 821. Shortest Distance to a Character
 */
public class ShortestDistanceToCharacter {

    /**
     * Given a string S and a character C, return an array of integers representing the shortest distance
     * from the character C in the string.
     */
    public int[] shortestToChar(String s, char c) {
        int[] distances = new int[s.length()];

        int next = s.indexOf(c);

        for (int i = 0; i <= next; ++i) {
            distances[i] = next - i;
        }

        int previous = next;
        next = s.indexOf(c, next + 1);
        if (next < 0) next = Integer.MAX_VALUE;

        for (int i = previous + 1; i < s.length(); ++i) {
            distances[i] = Math.min(next - i, i - previous);
            if (i == next) {
                previous = next;
                next = s.indexOf(c, next + 1);
                if (next < 0) next = Integer.MAX_VALUE;
            }
        }

        return distances;
    }
}
