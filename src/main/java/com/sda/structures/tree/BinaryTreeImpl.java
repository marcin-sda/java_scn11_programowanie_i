package com.sda.structures.tree;

import java.util.ArrayDeque;
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
                } else {
                    break;
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
        return remove(element, mRoot);
    }

    /**
     * EN: Searches tree for an element.
     * PL: Szuka elementu w drzewie.
     *
     * @param element to be searched (element do znalezienia)
     * @return true if element was found (prawda jeśli znaleziono element)
     */
    public boolean find(T element) {
        return recuSearch(mRoot, element) != null;
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

            case DFS_PREORDER:
                recuTraverseDFSPreOrder(mRoot);
                break;

            case DFS_POSTORDER:
                recuTraverseDFSPostOrder(mRoot);
                break;

            case BFS:
                traverseBFS(mRoot);
                break;

                default:
                break;
        }
    }

    private boolean remove(T element, TreeNode<T> root) {
        // search for node to remove and its parent
        TreeNode<T> parent = root;
        TreeNode<T> current = root;
        int comparison = current.data.compareTo(element);
        while (comparison != 0) {
            parent = current;
            if (comparison > 0){
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null){
                return false;
            }
            comparison = current.data.compareTo(element);
        }
        //case 1: node to be deleted is a leaf
        if (current.leftChild == null && current.rightChild == null) {
            if (current == mRoot) {
                mRoot = null;
            }
            else if(parent.leftChild == current) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        }
        //case 2: if node to be deleted has only one child
        //there is only left child
        else if (current.rightChild == null) {
            if (current == mRoot) {
                mRoot = current.leftChild;
            } else if (parent.leftChild == current) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        }
        //there is only right child
        else if (current.leftChild == null) {
            if(current == mRoot) {
                mRoot = current.rightChild;
            } else if (parent.leftChild == current) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        }
        // case 3: node to be deleted has both children
        else if (current.leftChild != null && current.rightChild != null) {
            //Find node with smallest value (successor) in right sub-tree
            //of node that is going to be deleted.
            TreeNode<T> minNode = findMinNode(current.rightChild);
            //Copy value from successor to node we are deleting.
            current.data = minNode.data;
            //Remove findMinNode since it contains duplicate value.
            if (current.rightChild == minNode) {
                current.rightChild = minNode.rightChild;
            } else {
                remove(minNode.data, current.rightChild);
            }
        }
        return true;
    }

    //Recursively search for a node with given value, starting from given node.
    private TreeNode<T> recuSearch(TreeNode<T> node, T element) {
         if (node == null) {
             return null;
         }
         int comparison = node.data.compareTo(element);
         if (comparison == 0) {
             return node;
         } else if (comparison < 0) {
             return recuSearch(node.rightChild, element);
         } else {
             return recuSearch(node.leftChild, element);
         }
    }

    //Recursively traverse tree in depth-first manner (in-order).
    private void recuTraverseDFSInOrder(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        recuTraverseDFSInOrder(root.leftChild);
        System.out.println(root.data);
        recuTraverseDFSInOrder(root.rightChild);
    }

    //Recursively traverse tree in depth-first manner (pre-order).
    private void recuTraverseDFSPreOrder(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        recuTraverseDFSPreOrder(root.leftChild);
        recuTraverseDFSPreOrder(root.rightChild);
    }

    //Recursively traverse tree in depth-first manner (post-order).
    private void recuTraverseDFSPostOrder(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        recuTraverseDFSPreOrder(root.leftChild);
        recuTraverseDFSPreOrder(root.rightChild);
        System.out.println(root.data);
    }

    //Traverse tree in breadth-first search manner.
    private void traverseBFS(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode<T>> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            final TreeNode<T> current = queue.poll();
            System.out.println(current.data.toString() + " ");
            if (current.leftChild != null) {
                queue.offer(current.leftChild);
            }
            if (current.rightChild != null) {
                queue.offer(current.rightChild);
            }
        }
    }

    //Finds minimum starting from given parent.
    private TreeNode<T> findMinNode(TreeNode<T> parent) {
        if (parent.leftChild == null) {
            return parent;
        }
        return findMinNode(parent.leftChild);
    }
}
