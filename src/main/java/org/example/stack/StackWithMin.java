package org.example.stack;

import org.w3c.dom.Node;

public class StackWithMin<T extends Comparable>{
    private static class NodeWithMin<T>{
       private T data;
       private T currentMin;
       private NodeWithMin<T> next;

       public NodeWithMin(T data,T currentMin){
           this.data = data;
           this.currentMin = currentMin;
       }
    }
  private NodeWithMin<T> top;
    public void push(T data){
        var currentTop = top;
        NodeWithMin<T> newNode=null;
        if(top==null) {
            newNode =new NodeWithMin<T>(data,data);
        }else{
            var min = currentTop.currentMin;
            if(min.compareTo(data)>0){
                min=data;
            }
            newNode =new NodeWithMin<T>(data,min);
        }
        newNode.next = top;
        top= newNode;
    }

    public T pop(){
        if(top==null) throw new IllegalArgumentException("Stack is empty");
        var temp =top;
        top=top.next;
        return temp.data;
    }

    public T min(){
        if(top ==null) throw new IllegalArgumentException("Stack is empty");
        return top.currentMin;
    }
}

