package com.sda.structures.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TreeTest {
    BinaryTree<Integer> mTree;

    @Before
    public void setup() {
        mTree = new BinaryTreeImpl<>();
    }

    @Test
    public void testAddedElementCanBeFound() {
        ArrayList<Integer> values = getRandomValues(20);
        for (Integer element : values) {
            mTree.add(element);
        }
        boolean found = false;
        for (Integer element : values) {
            found = mTree.find(element);
            if (!found) {
                break;
            }
        }
        mTree.traverse(BinaryTree.TraversalMode.DFS_INORDER);
        assertTrue(found);
    }

    @Test
    public void testRemovedElementCannotBeFound() {
        final int nodesCount = 1000;
        //Build tree using random values.
        ArrayList<Integer> values = getRandomValues(nodesCount);
        for (Integer element : values) {
            mTree.add(element);
        }
        //Shuffle elements so they will not be removed in the same order they were added.
        Collections.shuffle(values);
        //Build set to remove duplicates - tree does not hold duplicate values.
        Set<Integer> set = new HashSet<>();
        set.addAll(values);
        for (Integer element : set) {
            //Each element from set should be present in tree before it is removed.
            boolean found = mTree.find(element);
            assertTrue(found);
            mTree.remove(element);
            //Removed element should no longer be present.
            found = mTree.find(element);
            assertFalse(found);
        }
    }

    private ArrayList<Integer> getRandomValues(int amount) {
        Random random = new Random();
        ArrayList<Integer> values = new ArrayList<>();
        while (amount > 0) {
            values.add(random.nextInt(256));
            amount--;
        }
        return values;
    }
}
