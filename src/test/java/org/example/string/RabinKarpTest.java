package org.example.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RabinKarpTest{

    @Test
    public void test(){
        String text = "abcdef";
        String pattern = "abc";
        Assertions.assertTrue(RabinKarp.isMatch(text,pattern));
    }
}
