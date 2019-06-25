package com.sda.structures.list;

/**
 * TODO:
 * 1. Czy można zmienić listę tak aby nie trzymać pustego węzła mHead?
 * 2. Czy możemy wyodrębnić przynajmniej niektóre pętle while do jednej wspólnej metody?
 * 3. Jak zmienić implementację żeby pozycje na liście zaczynały się od 1?
 */
public class ListImpl implements List {

    Node mHead = new Node();
    int mNodeCounter = 0;

    private int count() {
        int counter = 0;
        Node current = mHead;
        while(current != null) {
            current = current.mNext;
            counter++;
        }
        return counter - 1;
    }

    public void print() {
        Node current = mHead.mNext;
        while(current != null) {
            System.out.println(current.mValue);
            current = current.mNext;
        }
    }

    private boolean isValidPosition(int position) {
        if (position < 0 || position >= size()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        return mHead.mNext == null;
    }

    @Override
    public int size() {
        return mNodeCounter;
    }

    @Override
    public void prepend(Integer data) {
        Node newNode = new Node();
        newNode.mValue = data;
        newNode.mNext = mHead.mNext;
        mHead.mNext = newNode;
        mNodeCounter++;
    }

    @Override
    public void append(Integer data) {
        Node newNode = new Node();
        newNode.mValue = data;
        Node current = mHead;
        while(current.mNext != null) {
            current = current.mNext;
        }
        current.mNext = newNode;
        mNodeCounter++;
    }

    @Override
    public boolean insert(Integer data, int position) {
        if (!isValidPosition(position)) {
            return false;
        }
        Node newNode = new Node();
        newNode.mValue = data;
        Node previous = null;
        Node current = mHead;
        while(position >= 0) {
            position--;
            previous = current;
            current = current.mNext;
        }
        newNode.mNext = current;
        previous.mNext = newNode;
        mNodeCounter++;
        return true;
    }

    @Override
    public void remove(int position) {
        if (!isValidPosition(position)) {
            return;
        }
        Node previous = mHead;
        while(position > 0) {
            position--;
            previous = previous.mNext;
        }
        previous.mNext = previous.mNext.mNext;
        mNodeCounter--;
    }

    @Override
    public Integer get(int position) {
        if (!isValidPosition(position)) {
            return null;
        }
        Node current = mHead.mNext;
        while(position > 0) {
            position--;
            current = current.mNext;
        }
        return current.mValue;
    }

    @Override
    public void set(Integer data, int position) {
        if (!isValidPosition(position)) {
            return;
        }
        Node current = mHead.mNext;
        while(position > 0) {
            position--;
            current = current.mNext;
        }
        current.mValue = data;
    }
}
