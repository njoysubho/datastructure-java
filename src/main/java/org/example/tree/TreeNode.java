package org.example.tree;

import lombok.Data;

@Data
public class TreeNode{
    private int value;
    private TreeNode rightChild;
    private TreeNode leftChild;

    public TreeNode(int value){
        this.value = value;
    }
}
