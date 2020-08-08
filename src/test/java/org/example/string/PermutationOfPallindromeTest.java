package org.example.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PermutationOfPallindromeTest{

    @Test
    @DisplayName("Pallindrome String With Only Letter")
    public void testPallindromicPureString(){
        assertAll("assert",
                () -> assertTrue(PermutationOfPallindrome.check("Tact coa")),
                () -> assertTrue(PermutationOfPallindrome.check("madam")),
                () -> assertFalse(PermutationOfPallindrome.check("sabyasachi")),
                () -> assertTrue(PermutationOfPallindrome.check("ssa"))
        );
    }

    @Test
    @DisplayName("Pallindrome String With AlphaNumeric Letter")
    public void testPallindromicAlphanumericString(){
        assertAll("assert",
                () -> assertTrue(PermutationOfPallindrome.check("Tact8 coa"))
        );
    }

    @Test
    @DisplayName("String With Null")
    public void testPallindromicNullString(){
        assertAll("assert",
                () -> assertFalse(PermutationOfPallindrome.check(null))
        );
    }
}
