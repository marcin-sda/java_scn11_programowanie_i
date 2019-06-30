package com.sda.structures.tree;

/**
 * EN: Binary tree interface.
 * PL: Interfejs drzewa binarnego
 *
 * @param <T> type of data stored in the tree
 *            (typ danych przechowywanych w drzewie)
 */
public interface BinaryTree <T extends Comparable<T>> {

    /**
     * EN: A tree traversal mode.
     * PL: Porządek przechodzenia drzewa.
     */
    enum TraversalMode {
        BFS,
        DFS_INORDER,
        DFS_PREORDER,
        DFS_POSTORDER
    }

    /**
     * EN: Adds new element to the tree.
     * PL: Dodaje nowy element do drzewa
     *
     * @param element to be added (element do dodania)
     */
    void add(T element);

    /**
     * EN: Removes given element from the tree.
     * PL: Usuwa dany element z drzewa.
     *
     * @param element to be removed (element do usunięcia)
     * @return true if successfully removed (prawda jeśli udało się usunąć)
     */
    boolean remove(T element);

    /**
     * EN: Searches tree for an element.
     * PL: Szuka elementu w drzewie.
     *
     * @param element to be searched (element do znalezienia)
     * @return true if element was found (prawda jeśli znaleziono element)
     */
    boolean find(T element);

    /**
     * EN: Traverses tree in given order.
     * PL: Przechodzi drzewo według danego porządku przechodzenia.
     *
     * @param mode define traversal mode (definiuje porządek przechodzenia)
     */
    void traverse(TraversalMode mode);
}
