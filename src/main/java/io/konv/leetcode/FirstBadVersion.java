package io.konv.leetcode;

/**
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on
 * the previous version, all the versions after a bad version are also bad.
 */
public class FirstBadVersion {

    private final VersionControl versionControl;

    public FirstBadVersion(VersionControl versionControl) {
        this.versionControl = versionControl;
    }

    /**
     * @param n versions [1, 2, ..., n]
     * @return the first bad one, which causes all the following ones to be bad
     */
    public int firstBadVersion(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        if (versionControl.isBadVersion(1)) {
            return 1;
        }
        if (!versionControl.isBadVersion(n)) {
            throw new IllegalArgumentException("First bad version is not found");
        }

        int lo = 1; // isBadVersion = false
        int hi = n; // isBadVersion = true
        int mid;

        while (hi - lo > 1) {
            mid = lo + (hi - lo) / 2;
            if (versionControl.isBadVersion(mid)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        return hi;
    }

    public static class VersionControl {

        private int firstBadVersion;
        private int isBadVersionCount;

        public boolean isBadVersion(int version) {
            isBadVersionCount += 1;
            return version >= firstBadVersion;
        }

        public void setFirstBadVersion(int firstBadVersion) {
            this.firstBadVersion = firstBadVersion;
        }

        public int getIsBadVersionCount() {
            return isBadVersionCount;
        }
    }
}
