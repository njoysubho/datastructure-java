package org.example.linkedlist;

public class PallindromicList{
    public boolean isPallindrome(LinkedList<Integer> l1){
        if (l1 == null) {
            return false;
        }
        var reversed = l1.reverse();
        Node<Integer> head1 = l1.getHead();
        Node<Integer> head2 = reversed.getHead();
        while (head1 != null) {
            if (!head1.getData().equals(head2.getData())) {
                return false;
            }
            head1 = head1.getNext();
            head2 = head2.getNext();
        }
        return true;
    }
}
