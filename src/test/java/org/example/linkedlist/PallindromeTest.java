package org.example.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PallindromeTest{

    @Test
    @DisplayName("it_should_test_pallindrome")
    public void testPallindrome(){
        var list = new LinkedList<Integer>();
        list.add(6);
        list.add(1);
        list.add(6);
        PallindromicList pallindromicList = new PallindromicList();
        Assertions.assertTrue(pallindromicList.isPallindrome(list));
    }

    @Test
    @DisplayName("it_should_not_return_pallindrome")
    public void testNotPallindrome(){
        var list = new LinkedList<Integer>();
        list.add(6);
        list.add(1);
        PallindromicList pallindromicList = new PallindromicList();
        Assertions.assertFalse(pallindromicList.isPallindrome(list));
    }

    @Test
    @DisplayName("it_should_return_pallindrome_for_empty")
    public void testEmptyPallindrome(){
        var list = new LinkedList<Integer>();
        PallindromicList pallindromicList = new PallindromicList();
        Assertions.assertTrue(pallindromicList.isPallindrome(list));
    }
}
