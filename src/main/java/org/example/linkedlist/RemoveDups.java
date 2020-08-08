package org.example.linkedlist;

import java.util.HashSet;

public class RemoveDups{
    public LinkedList<Integer> removeDups(LinkedList<Integer> originalList){
        var existing = new HashSet<Integer>();
        var currentNode = originalList.getHead();
        Node<Integer> prevNode = null;
        while (currentNode != null) {
            if (existing.contains(currentNode.getData())) {
                prevNode.setNext(currentNode.getNext());
            } else {
                existing.add(currentNode.getData());
                prevNode = currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return originalList;
    }


}
