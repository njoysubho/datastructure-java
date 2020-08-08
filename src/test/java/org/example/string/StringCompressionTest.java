package org.example.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCompressionTest{
    @Test
    @DisplayName("Consecutive Count")
    public void testConsecutiveCount(){
        StringCompression compression=new StringCompression();
        Assertions.assertEquals("a2b1c5d2a3",compression.compress("aabcccccddaaa"));
    }

    @Test
    @DisplayName("Consecutive Count Null String")
    public void testConsecutiveCountNullString(){
        StringCompression compression=new StringCompression();
        Assertions.assertNull(compression.compress(null));
    }
}
