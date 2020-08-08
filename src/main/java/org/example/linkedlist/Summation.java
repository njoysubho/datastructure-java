package org.example.linkedlist;

public class Summation{
    public LinkedList<Integer> sum(LinkedList<Integer> l1, LinkedList<Integer> l2){
        if (l1 == null || l2 == null) {
            return null;
        }
        int sizeDiff = l1.size() - l2.size();
        if (sizeDiff > 0) {
            fillZeroes(l2, sizeDiff);
        } else {
            fillZeroes(l1, Math.abs(sizeDiff));
        }
        var result = new LinkedList<Integer>();
        var first = l1.getHead();
        var second = l2.getHead();
        int c = 0;
        while (first != null && second != null) {
            int sum = first.getData() + second.getData() + c;
            if (sum >= 10) {
                sum = sum % 10;
                c = 1;
            }
            result.add(sum);
            first = first.getNext();
            second = second.getNext();
        }
        return result;
    }

    public LinkedList<Integer> sumForward(LinkedList<Integer> l1, LinkedList<Integer> l2){
        if (l1 == null || l2 == null) {
            return null;
        }
        int sizeDiff = l1.size() - l2.size();
        if (sizeDiff > 0) {
            fillZeroesAtHead(l2, sizeDiff);
        } else {
            fillZeroesAtHead(l1, Math.abs(sizeDiff));
        }
        var result = new LinkedList<Integer>();
        var first = l1.getHead();
        var second = l2.getHead();

        PathSum sum=sumForward(first,second);
        return sum.sum;
    }

    public PathSum sumForward(Node<Integer> l1, Node<Integer> l2){
        if(l1==null||l2==null){
            return new PathSum();
        }
        PathSum sum=sumForward(l1.getNext(),l2.getNext());
        int res = sum.carry+l1.getData()+l2.getData();
        if(res>=10){
            sum.sum.addToFirst(res%10);
            sum.carry=1;
        }else{
            sum.sum.addToFirst(res);
            sum.carry=0;
        }
        return sum;
    }



    private void fillZeroes(LinkedList<Integer> l, int n){
        for (int i = 0; i < n; i++) {
            l.add(0);
        }
    }

    private void fillZeroesAtHead(LinkedList<Integer> l, int n){
        for (int i = 0; i < n; i++) {
            l.addToFirst(0);
        }
    }

    class PathSum{
        private LinkedList<Integer> sum=new LinkedList<>();
        private int carry;
    }
}

