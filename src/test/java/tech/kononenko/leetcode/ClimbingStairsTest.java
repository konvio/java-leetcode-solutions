package tech.kononenko.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ClimbingStairsTest {

    private ClimbingStairs subject;

    @BeforeEach
    public void setUp() {
        subject = new ClimbingStairs();
    }

    @Test
    public void climbStairsTest() {
        assertThat(subject.climbStairs(3)).isEqualTo(3);
        assertThat(subject.climbStairs(4)).isEqualTo(5);
    }
}