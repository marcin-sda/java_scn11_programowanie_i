package com.sda.structures.list;

public class DoublyLinkedListImpl implements List {
    DoublyLinkedListNode mHead = new DoublyLinkedListNode();
    int mNodeCounter = 0;

    //zostaje
    private int count() {
        int counter = 0;
        DoublyLinkedListNode current = mHead;
        while(current != null) {
            current = current.mNext;
            counter++;
        }
        return counter - 1;
    }

    //zostaje
    public void print() {
        DoublyLinkedListNode current = mHead.mNext;
        while(current != null) {
            System.out.println(current.mValue);
            current = current.mNext;
        }
    }

    //zostaje
    private boolean isValidPosition(int position) {
        if (position < 0 || position >= size()) {
            return false;
        }
        return true;
    }

    //zostaje
    @Override
    public boolean isEmpty() {
        return mHead.mNext == null;
    }

    //zostaje
    @Override
    public int size() {
        return mNodeCounter;
    }

    @Override
    public void prepend(Integer data) {
        DoublyLinkedListNode newDoublyLinkedListNode = new DoublyLinkedListNode();
        newDoublyLinkedListNode.mValue = data;
        newDoublyLinkedListNode.mNext = mHead.mNext;
        newDoublyLinkedListNode.mPrev = mHead;
        mHead.mNext = newDoublyLinkedListNode;
        mNodeCounter++;
    }

    @Override
    public void append(Integer data) {
        DoublyLinkedListNode newDoublyLinkedListNode = new DoublyLinkedListNode();
        newDoublyLinkedListNode.mValue = data;
        DoublyLinkedListNode current = mHead;
        while(current.mNext != null) {
            current = current.mNext;
        }
        newDoublyLinkedListNode.mPrev = current;
        current.mNext = newDoublyLinkedListNode;
        mNodeCounter++;
    }

    @Override
    public boolean insert(Integer data, int position) {
        if (!isValidPosition(position)) {
            return false;
        }
        DoublyLinkedListNode newDoublyLinkedListNode = new DoublyLinkedListNode();
        newDoublyLinkedListNode.mValue = data;
        DoublyLinkedListNode current = mHead;
        while(position >= 0) {
            position--;
            current = current.mNext;
        }
        newDoublyLinkedListNode.mNext = current;
        DoublyLinkedListNode tmp = current.mPrev;
        newDoublyLinkedListNode.mPrev = tmp;
        current.mPrev = newDoublyLinkedListNode;
        tmp.mNext = newDoublyLinkedListNode;
        mNodeCounter++;
        return true;
    }

    @Override
    public void remove(int position) {
        if (!isValidPosition(position)) {
            return;
        }
        DoublyLinkedListNode previous = mHead;
        while(position > 0) {
            position--;
            previous = previous.mNext;
        }
        DoublyLinkedListNode a = previous;
        DoublyLinkedListNode c = a.mNext.mNext;
        DoublyLinkedListNode b = a.mNext;
        //b.mPrev = null;
        //b.mNext = null;
        a.mNext = c;
        c.mPrev = a;
        /*previous.mNext = previous.mNext.mNext;
        previous.mNext.mPrev = previous;*/
        mNodeCounter--;
    }

    @Override
    public Integer get(int position) {
        if (!isValidPosition(position)) {
            return null;
        }
        DoublyLinkedListNode current = mHead.mNext;
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
        DoublyLinkedListNode current = mHead.mNext;
        while(position > 0) {
            position--;
            current = current.mNext;
        }
        current.mValue = data;
    }
}
