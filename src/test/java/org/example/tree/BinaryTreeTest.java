package org.example.tree;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class BinaryTreeTest{

    @Test
    @DisplayName("it should be able to add to a binary search tree")
    public void testShouldAddBinarySearchTree(){
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.add(3);
        binarySearchTree.add(1);
        binarySearchTree.add(2);
        assertTrue(binarySearchTree.isValid());
    }

    @Test
    @DisplayName("it should be able to search node to a binary search tree")
    public void testShouldSearchrBinarySearchTree(){
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.add(3);
        binarySearchTree.add(1);
        binarySearchTree.add(2);
        binarySearchTree.add(4);
        assertTrue(binarySearchTree.isValid());
        assertEquals(2,binarySearchTree.valueOf(binarySearchTree.searchNode(2)));
        assertEquals(4,binarySearchTree.valueOf(binarySearchTree.searchNode(4)));
    }

    @Test
    @DisplayName("it should be able to search in order successor in  a binary search tree")
    public void testShouldSearchInorderSuccessorBinarySearchTree(){
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.add(3);
        binarySearchTree.add(1);
        binarySearchTree.add(2);
        assertEquals(3,binarySearchTree.inorderSuccessor(2));
        assertEquals(2,binarySearchTree.inorderSuccessor(1));
        assertNull(binarySearchTree.inorderSuccessor(3));
    }

    @Test
    @DisplayName("it should delete leaf Node")
    public void testShouldDeleteLeafNode(){
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.add(3);
        binarySearchTree.add(1);
        binarySearchTree.add(2);
        assertEquals(2,binarySearchTree.inorderSuccessor(1));

        binarySearchTree.delete(2);

        assertTrue(binarySearchTree.isValid());
        assertNull(binarySearchTree.searchNode(2));
        assertEquals(3,binarySearchTree.inorderSuccessor(1));
    }
}
