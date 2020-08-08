package org.example.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class QueueTest{

    @Test
    @DisplayName("it_should_behave_as_queue_when__of_two_stacks")
    public void testItShouldBehaveAsQueue(){
        QueueByStack<Integer> queue = new QueueByStack<>();

        queue.add(1);
        Assertions.assertEquals(1,queue.remove());

        queue.add(1);
        queue.add(2);
        queue.add(3);

        Assertions.assertEquals(1,queue.remove());
        Assertions.assertEquals(2,queue.remove());
        Assertions.assertEquals(3,queue.remove());


    }


}
