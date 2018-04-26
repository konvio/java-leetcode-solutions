package io.konv.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LengthOfLastWordTest {

    private LengthOfLastWord subject;

    @BeforeEach
    public void setUp() {
        subject = new LengthOfLastWord();
    }

    @Test
    public void lengthOfLastWordTest() {
        assertThat(subject.lengthOfLastWord("hello my world ")).isEqualTo(5);
        assertThat(subject.lengthOfLastWord("    a   ")).isEqualTo(1);
        assertThat(subject.lengthOfLastWord("")).isEqualTo(0);
        assertThat(subject.lengthOfLastWord("   ")).isEqualTo(0);
    }
}