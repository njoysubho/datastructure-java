package org.example.linkedlist;

import lombok.Data;

@Data
public class LinkedList<T>{
    private Node<T> head;

    public Node<T> add(T data){
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
        return newNode;
    }

    public void addToFirst(T data){
        var newNode = new Node<T>(data);
        if (head == null) {
            head = newNode;
        } else {
            var temp = head;
            newNode.setNext(head);
            head = newNode;
        }
    }

    public void deleteMiddle(T data){
        if (head == null || head.getData().equals(data)) {
            return;
        }
        var temp = head;
        Node<T> prev = null;
        while (!temp.getData().equals(data)) {
            prev = temp;
            temp = temp.getNext();
        }
        prev.setNext(temp.getNext());
    }

    public LinkedList<T> reverse(){
        LinkedList<T> reversedList = new LinkedList<>();

        Node<T> current = head;

        while (current != null) {
            reversedList.addToFirst(current.getData());
            current = current.getNext();
        }
        return reversedList;
    }


    public int size(){
        if (head == null) return 0;
        int count = 0;
        Node<T> temp = head;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    @Override
    public String toString(){
        if (head == null) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> temp = head;
        while (temp != null) {
            sb.append(temp.getData() + ",");
            temp = temp.getNext();
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("]");
        return sb.toString();
    }
}

class Node<T>{
    private T data;
    private Node<T> next;

    public Node<T> getNext(){
        return next;
    }

    public void setNext(Node<T> next){
        this.next = next;
    }

    public Node(T data){
        this.data = data;
    }

    public T getData(){
        return data;
    }

    public void setData(T data){
        this.data = data;
    }
}
