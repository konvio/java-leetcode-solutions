package tech.kononenko.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FirstBadVersionTest {

    FirstBadVersion target;
    FirstBadVersion.VersionControl versionControl;

    @BeforeEach
    void setUp() {
        versionControl = new FirstBadVersion.VersionControl();
        target = new FirstBadVersion(versionControl);
    }

    @Test
    void firstBadVersion_allVersionsGood_throwsException() {
        versionControl.setFirstBadVersion(Integer.MAX_VALUE);

        assertThatThrownBy(() -> target.firstBadVersion(42)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void firstBadVersion() {
        checkFirstBadVersionIsFound(42, 1);
        checkFirstBadVersionIsFound(42, 42);
        checkFirstBadVersionIsFound(345, 34);
    }

    private void checkFirstBadVersionIsFound(int n, int firstBadVersion) {
        setFirstBadVersion(firstBadVersion);

        assertThat(findFirstBadVersion(n)).isEqualTo(firstBadVersion);
    }

    private int findFirstBadVersion(int n) {
        return target.firstBadVersion(n);
    }

    private void setFirstBadVersion(int n) {
        versionControl.setFirstBadVersion(n);
    }
}