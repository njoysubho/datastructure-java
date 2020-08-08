package org.example.tree;

public class MinimalBST{

    public TreeNode createMinBST(int[] array){
        return createMinBST(array, 0, array.length - 1);
    }

    private TreeNode createMinBST(int[] array, int start, int end){
        if (end > start) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(mid);
        node.setLeftChild(createMinBST(array,0,mid-1));
        node.setRightChild(createMinBST(array,mid+1,end));
        return node;
    }
}
