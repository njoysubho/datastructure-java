package org.example.linkedlist;

public class KthToLast<T>{
    public T getKthToLast(int k, LinkedList<T> list){
        if (k < 0) {
            return null;
        }
        int size = list.size(); // loop here O(n)
        if (size < k) {
            return null;
        }
        int indexFromStart = (size - 1) - k;
        Node<T> current = list.getHead();
        for (int i = 0; i < indexFromStart; i++) {
            current = current.getNext();
        }                         // loop here O(n)
        return current.getData();
    }

}
