package org.example.stack;

public class Stack<T>{
    private static class StackNode<T>{
        private T data;
        private StackNode<T> next;

        public StackNode(T data){
            this.data = data;
        }
    }

    private StackNode<T> top;

    public void push(T data){
        var newNode = new StackNode<T>(data);
        newNode.next = top;
        top = newNode;
    }

    public T pop(){
        if (isEmpty()) throw new IllegalArgumentException("Stack is empty");
        var temp = top;
        top = top.next;
        return temp.data;
    }

    public T peek(){
        if (top == null) throw new IllegalArgumentException("Stack is empty");
        return top.data;
    }

    public boolean isEmpty(){
        return top == null;
    }
}
