package org.example.tree;

public class BinarySearchTree<T extends Comparable<T>>{
    private class Node{
        private T value;
        private Node rightChild;
        private Node leftChild;

        public Node(T value){
            this.value = value;
        }
    }

    private Node root;

    public T valueOf(Node node){
        return node == null ? null : node.value;
    }

    public void add(T value){
        root = add(root, value);
    }

    private Node add(Node node, T value){
        if (node == null) {
            return new Node(value);
        }
        if (node.value.equals(value)) {
            return node;
        }
        if (value.compareTo(node.value) < 0) {
            node.leftChild = add(node.leftChild, value);
        } else if (value.compareTo(node.value) > 0) {
            node.rightChild = add(node.rightChild, value);
        }
        return node;
    }

    public void delete(T value){
        root = delete(root, value);

    }

    private Node delete(Node node, T value){
        if (node == null) return null;
        if (value.compareTo(node.value) < 0) {
            node.leftChild = delete(node.leftChild, value);
        } else if (value.compareTo(node.value) > 0) {
            node.rightChild = delete(node.rightChild, value);
        } else {
            if (node.leftChild == null) {
                return node.rightChild;
            }
            if (node.rightChild == null) {
                return node.leftChild;
            }
            Node successor = minValue(node.rightChild);
            node.value = successor.value;
            node.rightChild = delete(node.rightChild, node.value);
        }
        return node;
    }

    public void inorder(Node node){
        if (node == null) return;
        inorder(node.leftChild);
        System.out.println(node.value);
        inorder(node.rightChild);
    }

    public T inorderSuccessor(T value){
        Node node = searchNode(value);
        if (node != null) {
            return valueOf(inorderSuccessor(node));
        }
        return null;
    }

    private Node inorderSuccessor(Node node){
        // if node has right child , then left most child of the right sub tree
        if (node == null) return null;
        if (node.rightChild != null) {
            return minValue(node.rightChild);
        }
        Node suc = null;
        Node tempRoot = root;
        while (tempRoot != null) {
            if (node.value.compareTo(root.value) < 0) {
                suc = root;
                tempRoot = tempRoot.leftChild;
            } else if (node.value.compareTo(root.value) > 0) {
                tempRoot = tempRoot.rightChild;
            } else {
                break;
            }
        }
        return suc;
    }

    public Node searchNode(T value){
        return searchNode(root, value);
    }

    private Node searchNode(Node node, T value){
        if (node == null) return null;
        if (value.compareTo(node.value) < 0) {
            return searchNode(node.leftChild, value);
        } else if (value.compareTo(node.value) > 0) {
            return searchNode(node.rightChild, value);
        } else {
            return node;
        }
    }

    private Node minValue(Node node){
        Node current = node;
        while (current.leftChild != null) {
            current = current.leftChild;
        }
        return current;
    }


    public boolean isValid(){
        return isValid(root, null, null);
    }

    private boolean isValid(Node node, T min, T max){
        if (node == null) return true;
        if (min != null && node.value.compareTo(min) < 0) return false;
        if (max != null && node.value.compareTo(max) > 0) return false;
        return isValid(node.leftChild, min, node.value) && isValid(node.rightChild, node.value, max);
    }
}
