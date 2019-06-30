package com.sda.structures.tree;

public class TreeNode <T> {
    public T data;
    public TreeNode<T> leftChild = null;
    public TreeNode<T> rightChild = null;

    TreeNode(T data) {
        this.data = data;
    }
}
