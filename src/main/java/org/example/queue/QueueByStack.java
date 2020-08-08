package org.example.queue;

import java.util.Stack;

public class QueueByStack<T>{
    private Stack<T> newstack = new Stack();
    private Stack<T> oldStack = new Stack<>();

    public void add(T data){
        newstack.push(data);
    }
    public T remove(){
        while(!newstack.isEmpty()){
            oldStack.add(newstack.pop());
        }
        T value = oldStack.pop();
        while (!oldStack.isEmpty()){
            newstack.push(oldStack.pop());
        }
        return value;
    }
}
