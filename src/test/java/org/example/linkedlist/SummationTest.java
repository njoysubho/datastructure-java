package org.example.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SummationTest{
    @Test
    @DisplayName("it_should_add_non_null_list")
    public void testAddNonNullList(){
        var n1 = new LinkedList<Integer>();
        var n2 = new LinkedList<Integer>();
        n1.add(7);
        n1.add(1);
        n1.add(6);

        n2.add(5);
        n2.add(9);
        n2.add(2);

        Summation summation = new Summation();
        var sum=summation.sum(n1,n2);

        var listToint=toInt(sum);
        Assertions.assertEquals(912,toInt(sum));
    }

    @Test
    @DisplayName("it_should_not_add_null_list")
    public void testAddNullList(){
        var n1 = new LinkedList<Integer>();
        LinkedList<Integer> n2 = null;
        n1.add(7);
        n1.add(1);
        n1.add(6);

        Summation summation = new Summation();
        var sum=summation.sum(n1,n2);
        Assertions.assertNull(sum);
    }
    @Test
    @DisplayName("it_should_unequal_size_list")
    public void testAddUnEqualList(){
        var n1 = new LinkedList<Integer>();
        LinkedList<Integer> n2 = new LinkedList<Integer>();
        n1.add(7);
        n1.add(1);
        n1.add(6);

        n2.add(1);
        Summation summation = new Summation();
        var sum=summation.sum(n1,n2);

        Assertions.assertEquals(618,toInt(sum));
    }

    @Test
    @DisplayName("it_should_add_forward_list")
    public void testAddForwardList(){
        var n1 = new LinkedList<Integer>();
        var n2 = new LinkedList<Integer>();
        n1.add(6);
        n1.add(1);
        n1.add(7);

        n2.add(2);
        n2.add(9);
        n2.add(5);

        Summation summation = new Summation();
        var sum=summation.sumForward(n1,n2);

        var listToint=toInt(sum);
        Assertions.assertEquals(912,toIntForward(sum));
    }

    private Integer toInt(LinkedList<Integer> sum){
        int n=sum.size();
        int total=0;
        Node<Integer> temp=sum.getHead();
        for(int i=0;i<n;i++){
            total+= (int)(temp.getData()*Math.pow(10,i));
            temp=temp.getNext();
        }
        return total;
    }

    private Integer toIntForward(LinkedList<Integer> sum){
        int n=sum.size();
        int total=0;
        Node<Integer> temp=sum.getHead();
        for(int i=n-1;i>=0;i--){
            total+= (int)(temp.getData()*Math.pow(10,i));
            temp=temp.getNext();
        }
        return total;
    }
}
