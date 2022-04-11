package tech.kononenko.leetcode;

/**
 * 165. Compare Version Numbers
 */
public class CompareVersionNumbers {

    /**
     * Compare two version numbers version1 and version2.
     * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
     * <p>
     * You may assume that the version strings are non-empty and contain only digits and the . character.
     * The . character does not represent a decimal point and is used to separate number sequences.
     * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level
     * revision of the second first-level revision.
     */
    public int compareVersion(String version1, String version2) {
        String[] levels1 = version1.split("\\.");
        String[] levels2 = version2.split("\\.");

        int level1, level2;
        for (int i = 0; i < Math.max(levels1.length, levels2.length); ++i) {
            level1 = (i < levels1.length) ? Integer.parseInt(levels1[i]) : 0;
            level2 = (i < levels2.length) ? Integer.parseInt(levels2[i]) : 0;
            if (level1 != level2) return Integer.signum(level1 - level2);
        }
        return 0;
    }
}
