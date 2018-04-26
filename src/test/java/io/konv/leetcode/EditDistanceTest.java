package io.konv.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class EditDistanceTest {

    private EditDistance subject;

    @BeforeEach
    public void setUp() {
        subject = new EditDistance();
    }

    @Test
    public void minDistanceTest() {
        assertThat(subject.minDistance("hello", "ello")).isEqualTo(1);
        assertThat(subject.minDistance("i love linkedlist", "i love arraylist")).isEqualTo(6);
    }
}