package org.example.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StackTest{

    @Test
    @DisplayName("it_should_fetch_min")
    public void testItShouldFetchMin(){
        StackWithMin<Integer> stack = new StackWithMin<>();
        stack.push(1);
        Assertions.assertEquals(1,stack.min());

        stack.push(2);
        Assertions.assertEquals(1,stack.min());

        stack.push(-2);
        Assertions.assertEquals(-2,stack.min());

        stack.pop();
        Assertions.assertEquals(1,stack.min());

        stack.push(-3);
        Assertions.assertEquals(-3,stack.min());

        stack.push(-4);
        Assertions.assertEquals(-4,stack.min());

        stack.pop();
        Assertions.assertEquals(-3,stack.min());
    }

}
