package org.example.linkedlist;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LinkedListTest{

    @Test
    @DisplayName("It Should Remove Duplicate")
    public void testRemoveDup(){
        var originalList=new LinkedList<Integer>();
        originalList.add(1);
        originalList.add(2);
        originalList.add(1);
        RemoveDups removeDups=new RemoveDups();
        originalList=removeDups.removeDups(originalList);
        assertEquals(2,originalList.size());
    }

    @Test
    @DisplayName("Get Kth from Last")
    public void testGetKthFromLast(){
        KthToLast<Integer> kthToLast=new KthToLast<>();
        LinkedList<Integer> list=new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        assertEquals(5,kthToLast.getKthToLast(0,list));
        assertEquals(3,kthToLast.getKthToLast(2,list));
        assertNull(kthToLast.getKthToLast(10, list));
        assertNull(kthToLast.getKthToLast(-10, list));
    }

    @Test
    @DisplayName("delete  from middle")
    public void testDeleteMiddle(){
        KthToLast<Integer> kthToLast=new KthToLast<>();
        LinkedList<Integer> list=new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.deleteMiddle(3);
        assertEquals(4,list.size());
        list.deleteMiddle(5);
        assertEquals(3,list.size());
        list.deleteMiddle(1);
        assertEquals(3,list.size());
    }


}
