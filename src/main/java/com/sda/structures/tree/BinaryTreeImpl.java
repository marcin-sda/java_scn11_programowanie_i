package com.sda.structures.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeImpl <T extends Comparable<T>> implements BinaryTree <T> {

    TreeNode<T> mRoot = null;

    /**
     * EN: Adds new element to the tree.
     * PL: Dodaje nowy element do drzewa
     *
     * @param element to be added (element do dodania)
     */
    public void add(T element) {
        if (mRoot == null) {
            mRoot = new TreeNode<>(element);
        } else {
            int comparison = 0;
            TreeNode<T> current = mRoot;
            while (true) {
                comparison = element.compareTo(current.data);
                if (comparison > 0) {
                    if (current.rightChild == null) {
                        current.rightChild = new TreeNode<>(element);
                        break;
                    } else {
                        current = current.rightChild;
                    }
                } else if (comparison < 0) {
                    if (current.leftChild == null) {
                        current.leftChild = new TreeNode<>(element);
                        break;
                    } else {
                        current = current.leftChild;
                    }
                }
            }
        }
    }

    /**
     * EN: Removes given element from the tree.
     * PL: Usuwa dany element z drzewa.
     *
     * @param element to be removed (element do usunięcia)
     * @return true if successfully removed (prawda jeśli udało się usunąć)
     */
    public boolean remove(T element) {
    }

    /**
     * EN: Searches tree for an element.
     * PL: Szuka elementu w drzewie.
     *
     * @param element to be searched (element do znalezienia)
     * @return true if element was found (prawda jeśli znaleziono element)
     */
    public boolean find(T element) {
        return false;
    }

    /**
     * EN: Traverses tree in given order.
     * PL: Przechodzi drzewo według danego porządku przechodzenia.
     *
     * @param mode define traversal mode (definiuje porządek przechodzenia)
     */
    public void traverse(TraversalMode mode) {
        switch (mode) {
            case DFS_INORDER:
                recuTraverseDFSInOrder(mRoot);
                break;

            case BFS:
                break;

                default:
                break;
        }
    }

    private void recuTraverseDFSInOrder(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        recuTraverseDFSInOrder(root.leftChild);
        System.out.println(root.data);
        recuTraverseDFSInOrder(root.rightChild);
    }

}
