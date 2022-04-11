package tech.kononenko.leetcode;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactorialTrailingZeroesTest {

    private static FactorialTrailingZeroes subject;

    @BeforeAll
    static void setUp() {
        subject = new FactorialTrailingZeroes();
    }

    @Test
    void trailingZeroes() {
        assertEquals(subject.trailingZeroes(25), 6);
    }
}